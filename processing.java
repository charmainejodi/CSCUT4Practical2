import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class processing {

    public static void main(String[] args) {
        // define input and output file paths
        File inputFile = new File("C:\\Users\\jodi_\\Desktop\\checkpoint 4\\input.txt");
        File outputFile = new File("output.txt");

        try {
            // create a Scanner to read from the input file
            Scanner scanner = new Scanner(inputFile);
            // create a PrintWriter to write to the output file
            PrintWriter writer = new PrintWriter(outputFile);

            // loop through each line of the input file
            while (scanner.hasNextLine()) {
                // read the line and split it into an array of words
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                // initialize variables for the formatted name and date
                StringBuilder formattedName = new StringBuilder();
                String formattedDate = "";

                // format name
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];

                    // capitalize the first letter of the first word
                    if (i == 0) {
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(formattedWord);
                    // format middle initials (second word with two characters)
                    } else if (i == 1 && word.length() == 2) {
                        formattedName.append(". ").append(word.toUpperCase());
                    // capitalize the first letter of the last word and remove any numbers
                    } else if (i == words.length - 1) {
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(" ").append(formattedWord.replaceAll("[0-9]", ""));
                    // capitalize the first letter of all other words and remove any numbers
                    } else {
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(" ").append(formattedWord.replaceAll("[0-9]", ""));
                    }
                }

                // format date
                // find the index of the last space in the line (where the date starts)
                int dateIndex = line.lastIndexOf(" ");
                // extract the day, month, and year from the date string
                String dateString = line.substring(dateIndex + 1);
                String day = dateString.substring(0, 2);
                String month = dateString.substring(2, 4);
                String year = dateString.substring(4);
                // format the date as dd/MM/yyyy
                formattedDate = day + "/" + month + "/" + year;

                // write formatted output to file
                writer.println(formattedName.toString() + " " + formattedDate);
            }
            System.out.println("File has been formatted!");
            
            
            // close the scanner and writer
            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            // if the input file is not found, print the stack trace of the exception
            e.printStackTrace();
        }
    }
}
