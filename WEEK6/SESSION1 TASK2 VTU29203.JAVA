class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }
}

OUTPUT:
Input
s =
"abab"
Output
true
Expected
true
