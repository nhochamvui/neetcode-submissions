class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<int[]> arr = new ArrayList<>();
        map.forEach((key, value) -> arr.add(new int[]{value, key}));
        arr.sort((a, b) -> b[0] - a[0]);
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
