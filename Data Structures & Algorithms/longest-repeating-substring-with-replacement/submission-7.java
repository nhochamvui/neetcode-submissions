class Solution {
    public int characterReplacement(String s, int k) {
        // ABCDEFG
        int[] map = new int[26];
        int l = 0;
        int max = 0, result = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map[c - 'A']++;
            max = Math.max(max, map[c - 'A']);
            while (r - l + 1 - max > k) {
                map[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
