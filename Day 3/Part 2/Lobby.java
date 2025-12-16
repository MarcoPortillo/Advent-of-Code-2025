import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lobby {

            public static void main(String[] args) {
                List<String> banksList = readFile("LobbyInput.in");
                long totalNumber = 0;

                for (int i = 0; i< banksList.size(); i++) {
                    StringBuilder result = new StringBuilder();
                    int startIndex = 0;
                    int remaining = 12;

                    while (remaining > 0) {
                        int largest = -1;
                        int largestIndex = startIndex;

                        int maxIndex = banksList.get(i).length() - remaining;

                        for (int j = startIndex; j <= maxIndex; j++) {
                            char number = banksList.get(i).charAt(j);
                            int currentNumber = number - '0';

                            if (currentNumber > largest) {
                                largest = currentNumber;
                                largestIndex = j;
                            }
                        }

                        result.append(largest);
                        startIndex = largestIndex + 1;
                        remaining--;
                    }
                totalNumber += Long.parseLong(result.toString());
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
