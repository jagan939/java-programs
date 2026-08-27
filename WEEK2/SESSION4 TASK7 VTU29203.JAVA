import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

output:
Input
strs =
["eat","tea","tan","ate","nat","bat"]
Output
[["eat","tea","ate"],["bat"],["tan","nat"]]
Expected
[["bat"],["nat","tan"],["ate","eat","tea"]]
