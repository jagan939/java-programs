import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int[][] result = new int[m][n];

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            // Top row
            for (int j = layer; j < n - layer; j++)
                elements.add(matrix.get(layer).get(j));

            // Right column
            for (int i = layer + 1; i < m - layer - 1; i++)
                elements.add(matrix.get(i).get(n - layer - 1));

            // Bottom row
            for (int j = n - layer - 1; j >= layer; j--)
                elements.add(matrix.get(m - layer - 1).get(j));

            // Left column
            for (int i = m - layer - 2; i > layer; i--)
                elements.add(matrix.get(i).get(layer));

            int len = elements.size();
            int rot = r % len;

            List<Integer> rotated = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                rotated.add(elements.get((i + rot) % len));
            }

            int idx = 0;

            // Top row
            for (int j = layer; j < n - layer; j++)
                result[layer][j] = rotated.get(idx++);

            // Right column
            for (int i = layer + 1; i < m - layer - 1; i++)
                result[i][n - layer - 1] = rotated.get(idx++);

            // Bottom row
            for (int j = n - layer - 1; j >= layer; j--)
                result[m - layer - 1][j] = rotated.get(idx++);

            // Left column
            for (int i = m - layer - 2; i > layer; i--)
                result[i][layer] = rotated.get(idx++);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().trim().split(" "))
                            .map(Integer::parseInt)
                            .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

OUTPUT:
Input (stdin)
4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Your Output (stdout)
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
Expected Output
2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
