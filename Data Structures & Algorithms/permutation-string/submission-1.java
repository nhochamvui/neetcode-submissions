class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            map1[c - 'a']++;
        }
        int windowSize = s1.length();
        for (int r = 0; r < s2.length(); r++) {
            Character c = s2.charAt(r);
            map2[c - 'a']++;
            // 0 1 2 3 4
            if (r >= windowSize) {
                Character t = s2.charAt(r - windowSize);
                map2[t - 'a']--;
            }
            if (Arrays.equals(map1, map2)) {
                return true;
            }
        }
        return false;
    }
}
