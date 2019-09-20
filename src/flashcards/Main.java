package flashcards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Input number of cards: \n>");
        int numOfCards = Integer.parseInt(sc.nextLine());

        Map<String, String> cardToDefinition = new LinkedHashMap<>();
        Map<String, String> definitionToCard = new LinkedHashMap<>();

        String answer = null;

        for(int i = 0; i < numOfCards ; i++){
            boolean flag = true;
            while(flag){
                System.out.printf("The card #%d: \n>", i+1);
                String card = sc.nextLine();
                System.out.printf("The definition of the card #%d: \n>", i+1);
                String def = sc.nextLine();
                boolean keyExists = cardToDefinition.containsKey(card);

                if(keyExists) {
                    System.out.println("Key already exists! Please enter a new Key");
                    flag = true;
                }
                else {
                    if (cardToDefinition.isEmpty() || !keyExists) {
                        cardToDefinition.put(card, def);
                        flag = false;
                        break;
                    }
                }

            }

         }

        for(Map.Entry<String, String> cardDef :  cardToDefinition.entrySet()){
            System.out.printf("Print the definition of \"%s\": \n>",cardDef.getKey());
            answer = sc.nextLine();
            if(answer.equals(cardDef.getValue())){
                System.out.println("Correct answer.");
            }
            else if(definitionToCard.containsKey(answer)){
                System.out.printf("Wrong answer. (The correct one is \"%s\", you've just written the definition of \"%s\".",cardDef.getValue(), definitionToCard.get(answer));
            }

            else{
                System.out.printf("Wrong answer. (The correct one is \"%s\".)",cardDef.getValue() );
            }
        }
    }// end of function main

}//end of class Main
