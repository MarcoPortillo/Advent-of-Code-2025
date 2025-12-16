import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingDeparment {
    
    public static void main(String[] args) {
        List<String> dataFile = readFile("PrintingInputTest.in");
        char[][] dataGrid = convertTo2DGrid(dataFile);
        int rollsOfPaper = 0;


        //goes around the grid
        for (int row = 0; row < dataGrid.length; row++) {
            for (int col = 0; col < dataGrid[row].length; col++) {
                   char rollOfPaper =  dataGrid[row][col];
                   if(rollOfPaper == '@') {
                    
                   }

            }
        }
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

    public static char[][] convertTo2DGrid(List<String> data) {
        int rows = data.size();
        int cols = data.get(0).length();
        char[][] dataGrid = new char[rows][cols];

        for(int r=0;r<rows;r++) {
            String line = data.get(r);
            for(int c=0;c<cols;c++) {
                dataGrid[r][c] = line.charAt(c);
            }
        }

        return dataGrid;
    }


}
