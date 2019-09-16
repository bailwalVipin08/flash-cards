package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String card = sc.nextLine();
        String definition  = sc.nextLine();
        String answer = sc.nextLine();

        if(answer.equals(definition)){
            System.out.println("Your answer is right!");
        }
        else{
            System.out.println("Your answer is wrong...");
        }

    }
}
