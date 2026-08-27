class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";

        int count = 0;
        int n = s.length();

        for (int i = 0; i < n / 2; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }

        for (int i = n / 2; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                count--;
            }
        }

        return count == 0;
    }
}

OUTPUT:
nput
s =
"book"
Output
true
Expected
true
