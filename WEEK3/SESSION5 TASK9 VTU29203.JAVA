import java.util.*;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> heights[b] - heights[a]);

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            result[i] = names[idx[i]];
        }

        return result;
    }
}
OUTPUT:
Input
names =
["Mary","John","Emma"]
heights =
[180,165,170]
Output
["Mary","Emma","John"]
Expected
["Mary","Emma","John"]
