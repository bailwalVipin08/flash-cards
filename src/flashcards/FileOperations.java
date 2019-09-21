package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class FileOperations {

    static ArrayList<String> readLines(String filename, Map<String, String> container) throws IOException {
        ArrayList<String> cardsAndDef = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                cardsAndDef.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return cardsAndDef;
    }



   }/* end of class FileOperations */
