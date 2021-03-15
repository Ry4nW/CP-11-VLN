// All tests passed.

public class Main {

    static int problemOne(String s){

        int vowelCount = 0;

        // This loop iterates through all characters within the parameter String {s} provided.
        for (int i = 0, j = 1 /* Declared to specifically fit [String substring()] parameters. */; i < s.length(); i++, j++) {

            // Checks whether or not current character is a vowel.
            if (s.substring(i, j).equals("a") || s.substring(i, j).equals("e") || s.substring(i, j).equals("i") ||
            s.substring(i, j).equals("o") || s.substring(i, j).equals("u")) {

                 vowelCount++; // Increments {vowelCount} if so.

            }

        }

        return vowelCount;
    }

    static int problemTwo(String s){

        int bobCount = 0;

        // Iterates through all characters in {s}.
        for (int i = 0; i + 2 < s.length(); i++) {

            // Checks if the current character at index {i} and the two after match with "bob".
            if (s.startsWith("bob", i)) {

                bobCount++; // Increments {bobCount} if so.

            }
        }
        return bobCount;
    }

    static String problemThree(String s){
        String alp = "abcdefghijklmnopqrstuvwxyz";
        String prevChr = "";
        String curStr = "";
        String str = "";

        // Again, iterates through all characters with Integers declared to fit [substring()] params.
        for (int i = 0, j = 1; i < s.length(); i++, j++) {

            /* Checks whether or not the previous character in the {alp}'s index is in order of the alphabet. This is
            done by comparing the index numbers in String {alp}, which matches the order of the alphabet. We do not
            need to iterate through {alp} as we can locate the index in {alp} that matches the previous character using
            [indexOf()].
             */
            if (alp.indexOf(prevChr) <= alp.indexOf(s.substring(i, j))) {
                curStr += s.substring(i, j); // Adds current character to {curStr} if so.

                // Checks if our current string is longer than the string we intend to return; the longest one being our goal.
                if (curStr.length() > str.length()) {
                    str = curStr; // Return variable {str} becomes {curStr} if so.
                }

            } else {
                curStr = s.substring(i, j); // {curStr} becomes the current character if not, resetting the string.
            }
            prevChr = s.substring(i, j); // Becomes the current character so we can access it in the next iteration.
        }
        return str;
    }
    public static void main(String[] args) {

        System.out.println(problemOne("azcbobobegghakl"));
        System.out.println(problemTwo("azcbobobegghakl"));
        System.out.println(problemThree("azcbobobegghakl"));

    }
}
