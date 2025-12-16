import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lobby {

            public static void main(String[] args) {
                List<String> banksList = readFile("LobbyInputTest.in");
                int totalNumber = 0;

                //find first largest number
                for(int i=0;i<banksList.size();i++) {
                int largest = 0, largestIndex = 0, secondLargestIndex = 0;
                int secondLargest = 0;
                
                        for(int j=0;j<banksList.get(i).length();j++) {
                            char number = banksList.get(i).charAt(j);
                            int currentNumber = number - '0';
                            if(currentNumber > largest) {
                                largest = currentNumber;
                                largestIndex = j;
                            }
                        }

                    //find second largest number after the first one
                    for (int j=0;j<banksList.get(i).length();j++) {
                        if(j==largestIndex) continue;
                        char number = banksList.get(i).charAt(j);
                        int currentNumber = number - '0';
                        if(currentNumber > secondLargest) {
                            secondLargest = currentNumber;
                            secondLargestIndex = j;
                        }
                    }
                    int largestJoltage = 0;
                    if(largestIndex > secondLargestIndex) {
                        largestJoltage = secondLargest * 10 + largest;
                    } else {
                        largestJoltage = largest * 10 + secondLargest;
                    }

                System.out.println(largestJoltage);
                totalNumber += largestJoltage;
                }
                System.out.println(totalNumber);
            }

            public static List<String> readFile(String fileName) {
                File puzzleInput = new File(fileName);
                List<String> data = new ArrayList<String>();
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
