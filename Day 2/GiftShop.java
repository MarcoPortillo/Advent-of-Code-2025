import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiftShop {
   
        public static void main(String[] args) {
            int totalInvalidadIDs = 0;
            String[] rangesID = readFile("giftShopInputTest.in");
            for(String range : rangesID) {
                int start = Integer.parseInt(range.split("-")[0]);
                int end = Integer.parseInt(range.split("-")[1]);
                    for(int i=start;i<=end;i++) {
                        int index = 0;
                        String number = String.valueOf(i);
                        int numberLength = number.length();
                        int half = numberLength / 2;
                        boolean isRepeated = false;
                        while(index < half) {
                            String offset = number.substring(0, index + 1);
                            int offsetLength = offset.length();
                            int next = offsetLength;
                            if(numberLength > 2 && offsetLength > 2) offsetLength = offsetLength + (offsetLength - 1);
                            do {
                                String sequence = number.substring(offsetLength, offsetLength + 1);
                                if(offset.equals(sequence)) {
                                    isRepeated = true;
                                } else {
                                    isRepeated = false;
                                    break;
                                }
                                next = next + offsetLength;
                            } while(next < numberLength);
                            index++;
                        }
                        if(isRepeated) totalInvalidadIDs += Integer.parseInt(number);
                    }

                    System.out.println(totalInvalidadIDs);
            }
            
        }


        public static String[] readFile(String fileName) {
            File puzzleInput = new File(fileName);
            String [] data = null;
            try (Scanner myReader = new Scanner(puzzleInput)) {
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    data = line.split(",");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found Exception");
                e.printStackTrace();
            }
            return data;
        }

}


