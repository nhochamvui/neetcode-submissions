class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            map.add(nums[i]);
        }
        int longest = 0;
        for(Integer num : map){
            if(!map.contains(num - 1)){
                int seqSize = 1;
                while(map.contains(num + seqSize)){
                    seqSize++;
                }
                longest = seqSize > longest ? seqSize : longest;
            }
        }
        return longest;
    }
}
