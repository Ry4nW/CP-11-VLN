import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readingText {

    private static ArrayList<String> lines = new ArrayList<>();

    private static void wordInFile(String word) {

        ArrayList<String> indexes = new ArrayList<>();
        ArrayList<Integer> linesInText = new ArrayList<>();
        
        // Double loop iterates though the entirety of all elements in each line (in this case, going through the ArrayList).

        for (int i = 0; i <= lines.size() - 1; i++) {
            for (int y = 0, j = word.length() /* 2 variables to fit substring params */ ; j < lines.get(i).length(); y++, j++) {

                if (lines.get(i).substring(y, j).equals(word)) {
                    indexes.add("[" + i + ", " + y + "]");
                    linesInText.add(i + 1);
                }

            }
        }

        System.out.println("Word: \"" + word + "\"");
        System.out.println("Index location(s) in ArrayList containing word (nested): " + indexes);
        System.out.println("Line number(s) containing word: " + linesInText);
        System.out.println("Total amount of word(s) in text: " + linesInText.size());
    }
    public static void main(String[] args) throws IOException {

        FileReader fR  = new FileReader("ProgrammingHistory.txt");
        BufferedReader bR = new BufferedReader(fR);

        String line;

        while ((line = bR.readLine()) != null /* When {readLine()} reads nothing, null is returned. */) {
            lines.add(line);
        }
        bR.close();

        wordInFile("the");
    }
}
