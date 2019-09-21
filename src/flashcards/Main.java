package flashcards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static Scanner sc = new Scanner(System.in);

//    static Map<String, String> definitionToCard = new LinkedHashMap<>();

    public static void main(String[] args) {

        Map<String, String> cardToDefinition = new LinkedHashMap<>();
        String action;
        do {
            System.out.printf("\nInput the action (add, remove, import, export, ask, exit):\n>");
            action = sc.nextLine();
            switch (action) {
                case "add":
                    addCards(cardToDefinition);
                    break;
                case "remove":
                    removeCards(cardToDefinition);
                    break;
                case "import":
                    importCards(cardToDefinition);
                    break;
                case "ask":
                    ask(cardToDefinition);
                    break;
                case "exit":
                    System.out.print("Bye bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while(!"exit".equals(action));

    }// end of function main


    public static void addCards(Map<String, String> container){

        System.out.printf("The card: \n>");
        String card = sc.nextLine();
        System.out.printf("The definition of the card : \n>");
        String def = sc.nextLine();

        boolean defExists = container.containsValue(def);

        if(cardExists(container,card)){
            System.out.printf("The card \"%s\" already exists.", card);
        }
        else if(defExists){
            System.out.printf("The definition \"%s\" already exists.", def);
        }
        else{
            container.put(card, def);
            System.out.printf("The pair (\"%s\":\"%s\") has been added.", card, def);
        }
    }

    public static void removeCards(Map<String, String> container){

        System.out.printf("The card: \n>");
        String card = sc.nextLine();

        if(!cardExists(container,card)){
            System.out.printf("Can't remove \"%s\": there is no such card.", card);
        }
        else{
            container.remove(card);
            System.out.printf("The card \"%s\" has been removed.", card);
        }
    }

    public static void importCards(Map<String, String> container) {
        System.out.printf("File name: \n>");
        String filename = sc.nextLine();
        try {
            ArrayList<String> listOfCards = FileOperations.readLines(filename, container);
            String card;
            String def;
            for (int i = 0; i < listOfCards.size(); i += 2) {
                card = listOfCards.get(i);
                def = listOfCards.get(i + 1);
                container.put(card, def);
            }

            System.out.println(listOfCards.size()/2 + " cards have been loaded");

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }


    static void ask(Map<String, String> container){

        String[] keys = container.keySet().toArray(new String[container.size()]);

        System.out.println("How many times to ask?");

        int n = sc.nextInt();
        sc.nextLine();
        Random random = new Random();

        String randomKey;
        String answer;
        for(int i = 0; i < n; i++){

            if(container.isEmpty()){
                System.out.println("Empty List...!");
                break;
            }

            randomKey = keys[random.nextInt(keys.length)];
            System.out.printf("\nPrint the definition of \"%s\": \n\r>",randomKey);
            answer = sc.nextLine();

            if(answer.equals(container.get(randomKey))){
                System.out.println("Correct answer.");
            }
            else{
                System.out.printf("Wrong answer. (The correct one is \"%s\".)", container.get(randomKey));
            }
        }

    } /* end of method ask */


    static boolean cardExists(Map<String, String> container, String card){
        if(container.containsKey(card))
            return  true;

        return false;
    }
}//end of class Main
