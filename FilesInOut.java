import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;

public class FilesInOut {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputFileName, outputFileName;

        // Entering input file
        System.out.println("supply filename for input:");
        inputFileName = in.nextLine();
        try {
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);

            // Entering output file
            System.out.println("supply filename for output:");
            outputFileName = in.nextLine();
            PrintWriter writer = new PrintWriter(outputFileName);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                StringBuilder formattedName = new StringBuilder();
                String formattedDate;

                // format name
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];

                    if (i == 0) {
                        // capitalize first letter of first name
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(formattedWord);
                    } else if (i == 1 && word.length() == 2) {
                        // add middle initial if present
                        formattedName.append(". ").append(word.toUpperCase());
                    } else if (i == words.length - 1) {
                        // capitalize first letter of last name and remove any digits
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(" ").append(formattedWord.replaceAll("[0-9]", ""));
                    } else {
                        // capitalize first letter of middle name and remove any digits
                        String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                        formattedName.append(" ").append(formattedWord.replaceAll("[0-9]", ""));
                    }
                }

                // format date
                int dateIndex = line.lastIndexOf(" ");
                String dateString = line.substring(dateIndex + 1);
                String day = dateString.substring(0, 2);
                String month = dateString.substring(2, 4);
                String year = dateString.substring(4);
                formattedDate = day + "/" + month + "/" + year;

                // write formatted output to file
                writer.println(formattedName.toString() + " " + formattedDate);
            }
            System.out.println("The file has been formatted!");

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
