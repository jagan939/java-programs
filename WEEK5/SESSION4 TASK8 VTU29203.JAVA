class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (map1.containsKey(w) && map1.get(w) != p) {
                return false;
            }

            if (map2.containsKey(p) && map2.get(p) != w) {
                return false;
            }

            map1.put(w, p);
            map2.put(p, w);
        }

        return true;
    }
}

OUTPUT:
Input
words =
["abc","deq","mee","aqq","dkd","ccc"]
pattern =
"abb"
Output
["mee","aqq"]
Expected
["mee","aqq"]
