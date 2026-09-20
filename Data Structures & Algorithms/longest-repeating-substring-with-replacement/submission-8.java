class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int l = 0, max = 0;
        for (int r = 0; r < s.length(); r++) {
            Character c = s.charAt(r);
            map.merge(c, 1, (x, y) -> x + y);
            max = Math.max(max, map.get(c));
            while (r - l + 1 - max > k) {
                Character t = s.charAt(l);
                map.put(t, map.get(t) - 1);
                l++;
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
