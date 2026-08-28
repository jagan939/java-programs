import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<Integer> circularPalindromes(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();

        for (int shift = 0; shift < n; shift++) {
            int max = 1;

            for (int center = 0; center < n; center++) {
                int left = center;
                int right = center;

                while (left >= 0 && right < n &&
                       s.charAt((left + shift) % n) ==
                       s.charAt((right + shift) % n)) {
                    max = Math.max(max, right - left + 1);
                    left--;
                    right++;
                }

                left = center;
                right = center + 1;

                while (left >= 0 && right < n &&
                       s.charAt((left + shift) % n) ==
                       s.charAt((right + shift) % n)) {
                    max = Math.max(max, right - left + 1);
                    left--;
                    right++;
                }
            }

            result.add(max);
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        List<Integer> result = Result.circularPalindromes(s);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

OUTPUT:
Input (stdin)
13
aaaaabbbbaaaa
Your Output (stdout)
12
12
10
8
8
9
11
13
11
9
8
8
10
Expected Output
12
12
10
8
8
9
11
13
11
9
8
8
10
