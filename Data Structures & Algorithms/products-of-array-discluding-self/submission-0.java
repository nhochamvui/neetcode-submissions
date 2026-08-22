class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroCount = 0;
        for(int num : nums){
            if(num != 0){
                prod *= num;
            }
            else{
                zeroCount++;
            }
        }

        if(zeroCount > 1){
            return new int[nums.length];
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(zeroCount > 0){
                result[i] = num == 0 ? prod : 0;
            }
            else{
                result[i] = prod/num;
            }
        }
        return result;
    }
}  
