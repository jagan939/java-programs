import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int marsExploration(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char expected;

            if (i % 3 == 0) {
                expected = 'S';
            } else if (i % 3 == 1) {
                expected = 'O';
            } else {
                expected = 'S';
            }

            if (s.charAt(i) != expected) {
                count++;
            }
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

OUTPUT:
Input (stdin)
SOSSPSSQSSOR
Your Output (stdout)
3
Expected Output
3
