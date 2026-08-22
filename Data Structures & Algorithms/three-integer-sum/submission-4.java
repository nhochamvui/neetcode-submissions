class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> map = new HashSet<>();
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right || right > left) {
                int x = nums[i];
                int y = nums[left];
                int z = nums[right];
                int sum = x + y + z;
                if (sum < 0) {
                    left++;
                    continue;
                }
                if (sum > 0) {
                    right--;
                    continue;
                }
                String key = String.valueOf(x) + String.valueOf(y) + String.valueOf(z);
                if (sum == 0) {
                    if (!map.contains(key)) {
                        map.add(key);
                        results.add(Arrays.asList(x, y, z));
                    }
                    left++;
                }
            }
        }
        return results;
    }
}
