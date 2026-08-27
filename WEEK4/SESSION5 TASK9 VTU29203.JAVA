class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);

                answer[i][j] =
                    prefix[r2 + 1][c2 + 1]
                  - prefix[r1][c2 + 1]
                  - prefix[r2 + 1][c1]
                  + prefix[r1][c1];
            }
        }

        return answer;
    }
}

OUTPUT:
Accepted
Runtime: 0 ms
Case 1
Case 2
Input
mat =
[[1,2,3],[4,5,6],[7,8,9]]
k =
1
Output
[[12,21,16],[27,45,33],[24,39,28]]
Expected
[[12,21,16],[27,45,33],[24,39,28]]
