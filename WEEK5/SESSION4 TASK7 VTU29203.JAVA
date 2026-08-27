class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }

        int maxLen = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            if (lastIndex[ch] >= start) {
                start = lastIndex[ch] + 1;
            }

            lastIndex[ch] = end;
            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }
}

OUTPUT:
Input
s =
"abcabcbb"
Output
3
Expected
3
