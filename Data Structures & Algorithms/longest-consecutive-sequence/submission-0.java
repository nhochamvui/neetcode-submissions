class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> map = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            map.add(nums[i]);
        }
        int longest = 0;
        for(Integer num : map){
            if(!map.contains(num - 1)){
                Set<Integer> sequence = new HashSet<>();
                sequence.add(num);
                int i = 1;
                while(map.contains(num + i)){
                    sequence.add(num + i);
                    i++;
                }
                int seqSize = sequence.size();
                longest = seqSize > longest ? seqSize : longest;
            }
        }
        return longest;
    }
}
