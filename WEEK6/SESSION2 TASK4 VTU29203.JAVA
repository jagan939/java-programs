class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        return (s + s).contains(goal);
    }
}

OUTPUT:
Input
s =
"m"
goal =
"f"
Output
false
Expected
false
