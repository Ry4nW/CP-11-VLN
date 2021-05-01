import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readingText {

    private static ArrayList<String> lines = new ArrayList<>();

    private static void wordInFile(String word) {

        ArrayList<Integer> indexes = new ArrayList<>();

        for (int i = 0; i <= lines.size() - 1; i++) {
            for (int y = 0, j = word.length(); j < lines.get(i).length(); y++, j++) {

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

        while ((line = bR.readLine()) != null) {
            lines.add(line);
        }
        bR.close();

        wordInFile("devices");
    }
}
