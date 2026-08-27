class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            ans[index++] = nums[i];
            ans[index++] = nums[i + n];
        }

        return ans;
    }
}

OUTPUT:
Input
nums =
[2,5,1,3,4,7]
n =
3
Output
[2,3,5,4,1,7]
Expected
[2,3,5,4,1,7]
