class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}

OUTPUT:
Input
nums =
[3,2,2,3]
val =
3
Output
[2,2]
Expected
[2,2]
