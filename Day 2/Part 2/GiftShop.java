import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GiftShop {
   
        public static void main(String[] args) {
            long totalInvalidadIDs = 0;
            String[] rangesID = readFile("giftShopInput.in");
            for(String range : rangesID) {
                long start = Long.parseLong(range.split("-")[0]);
                long end = Long.parseLong(range.split("-")[1]);
                    for(long i=start;i<=end;i++) {
                        String number = String.valueOf(i);
                        int numberLength = number.length();


                        int half = numberLength / 2; 
                        boolean isRepeated = false;

                        int index = 0;
                        while(index < half) { 

                            String offset = number.substring(0, index + 1);
                            int offsetLength = offset.length();

                            if (numberLength % offsetLength != 0) {
                                index++;
                                continue;
                            }

                            int next = offsetLength;
                            boolean valid = true;

                                 while (next + offsetLength <= numberLength) {
                                    String sequence = number.substring(next, next + offsetLength);

                                    if (!offset.equals(sequence)) {
                                        valid = false;
                                        break;
                                    }

                                    next += offsetLength;
                                }

                            if (valid && next == numberLength) {
                                    isRepeated = true;
                                    break;
                            }

                            index++;
                        }

                        if (isRepeated) {
                            totalInvalidadIDs += i;
                        }
                    }
                }   
            System.out.println("total: " + totalInvalidadIDs);
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


