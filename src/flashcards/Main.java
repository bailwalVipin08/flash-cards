package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Input number of cards: \n>");
        int numOfCards = Integer.parseInt(sc.nextLine());

        String[] cards = new String[numOfCards];
        String[] definitions = new String[numOfCards];
        String answer = null;

        for(int i = 0; i < numOfCards ; i++){
            System.out.printf("The card #%d: \n>", i+1);
            cards[i] = sc.nextLine();
            System.out.printf("The definition of the card #%d: \n>", i+1);
            definitions[i] = sc.nextLine();
        }

        for(int i = 0; i < numOfCards ; i++){
            System.out.printf("Print the definition of \"%s\": \n>", cards[i]);
            answer = sc.nextLine();
            if(answer.equals(definitions[i])){
                System.out.println("Correct answer.");
            }
            else{
                System.out.printf("Wrong answer. (The correct one is \"%s\".)", definitions[i]);
            }
        }
    }
}
