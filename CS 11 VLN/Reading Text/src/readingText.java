import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readingText {
    
    // ArrayList to contain all of the lines, each as a separate element.
    private static ArrayList<String> lines = new ArrayList<>();

    private static void wordInFile(String word) {

        ArrayList<Integer> indexes = new ArrayList<>();
        
        // Double loop iterates though the entirety of all elements in each line (in this case, going through the ArrayList). 

        for (int i = 0; i <= lines.size() - 1; i++) {
            for (int y = 0, j = word.length() /* 2 variables to fit substring params */ ; j < lines.get(i).length(); y++, j++) {

                if (lines.get(i).substring(y, j).equals(word)) {
                    indexes.add(i);
                }

            }
        }

        System.out.println("Word: \"" + word + "\"");

        System.out.println("Index locations in ArrayList containing word: " + indexes);

        ArrayList<Integer> lines = new ArrayList<>();

        for (int i : indexes) {
            lines.add(i + 1);
        }

        System.out.println("Lines containing word: " + lines );
        System.out.println("Total amount of word(s) in text: " + lines.size());
    }
    public static void main(String[] args) throws IOException {

        FileReader fR  = new FileReader("ProgrammingHistory.txt");
        BufferedReader bR = new BufferedReader(fR);

        String line;

        while ((line = bR.readLine()) != null /* When {readLine()} reads nothing, null is returned. */) {
            lines.add(line);
        }
        bR.close();

        wordInFile("devices");
    }
}
