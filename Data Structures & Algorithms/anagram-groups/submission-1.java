class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        List<String> charMap = new ArrayList<String>();
        for(String str : strs){
            int[] count = new int[26];
            final char[] chars = str.toCharArray();
            for(char c : chars){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
