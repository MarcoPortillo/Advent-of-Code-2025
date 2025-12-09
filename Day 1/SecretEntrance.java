import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SecretEntrance {
    public static void main(String[] args) {
        ArrayList<String> fileData = readFile("puzzleInput.in");
        if(fileData.size() > 0) {
            int dialNumber = 50;
            int passwordNumber = 0;
            for (String StringNumber : fileData) {
                
                int IntegerNumber = extractCurrentNumberAsInteger(StringNumber);
                int wrapNumber = IntegerNumber % 100;
                
                if(StringNumber.startsWith("L")) {
                    dialNumber = dialNumber - wrapNumber;
                     if(dialNumber < 0) {
                        dialNumber += 100;
                    }
                    
                }
                if(StringNumber.startsWith("R")) {
                    dialNumber = dialNumber + wrapNumber;
                    if(dialNumber > 99) {
                        dialNumber -= 100;
                    }
                }

                if(dialNumber == 0) {
                        passwordNumber++;
                } 
            }
            System.out.println(passwordNumber);
        } else {
            System.out.println("File has not data");
        }
    }

    public static Integer extractCurrentNumberAsInteger(String number) {
        return Integer.parseInt(number.substring(1));
    }

    public static ArrayList<String> readFile(String fileName) {
        File puzzleInput = new File(fileName);
        ArrayList<String> data = new ArrayList<String>();
        try (Scanner myReader = new Scanner(puzzleInput)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found Exception");
            e.printStackTrace();
        }
        return data;
    }

    
}