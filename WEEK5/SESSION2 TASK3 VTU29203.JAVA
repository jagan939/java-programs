import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        int maxEndingHere = arr.get(0);
        int maxSoFar = arr.get(0);

        int subsequenceSum = 0;
        int maxElement = arr.get(0);

        for (int num : arr) {
            maxElement = Math.max(maxElement, num);

            if (num > 0) {
                subsequenceSum += num;
            }
        }

        for (int i = 1; i < arr.size(); i++) {
            maxEndingHere = Math.max(arr.get(i), maxEndingHere + arr.get(i));
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        if (subsequenceSum == 0) {
            subsequenceSum = maxElement;
        }

        return Arrays.asList(maxSoFar, subsequenceSum);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().trim().split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

OUTPUT:
Input (stdin)
2
4
1 2 3 4
6
2 -1 2 3 4 -5
Your Output (stdout)
10 10
10 11
Expected Output
10 10
10 11
