class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = 0, l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                l = Math.max(map.get(c) + 1, l);
            }
            map.put(c, r);
            max = Math.max(max, r - l + 1);
        }
        // a-0, b-1
        return max;
    }
}
