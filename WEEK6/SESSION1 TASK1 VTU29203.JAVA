import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
class Result {
    public static int stringSimilarity(String s) {
        int n = s.length();
        int[] z = new int[n];
        z[0] = n;
        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }
            while (i + z[i] < n &&
                   s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += z[i];
        }
        return sum;
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter =
                new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine().trim();
            int result = Result.stringSimilarity(s);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}

OUTPUT:
Input (stdin)
2
ababaa
aa
Your Output (stdout)
11
3
Expected Output
11
3
