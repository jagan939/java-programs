class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}

OUTPUT:
Input
nums =
[0,1,0,3,12]
Output
[1,3,12,0,0]
Expected
[1,3,12,0,0]
