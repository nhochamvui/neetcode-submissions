class Solution {
    
    public int[] productExceptSelf(int[] nums) {
        return withUpgradedPrePostFix(nums);
        // return withPrePostFix(nums);
        // return withNaive(nums);
    }

    private int[] withUpgradedPrePostFix(int[] nums){
        int[] result = new int[nums.length];
        int prefix = 1;
        for(int i = 0; i < nums.length; i++){
            if(i == 0) {
                result[0] = 1;
            }
            else{
                result[i] = result[i - 1] * nums[i-1];
            }
        }
        int postfix = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }

    private int[] withPrePostFix(int[] nums){
        int[] prefixes  = new int[nums.length]; 
        int[] postFixes = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num = 1;
            //if not first element
            if(i != 0){
                num = nums[i-1] * prefixes[i-1];
            }
            prefixes[i] = num;
        }
        for(int i = nums.length - 1; i >= 0; i--){
            int num = 1;
            //if not last element
            if(i != (nums.length - 1)){
                num = nums[i+1] * postFixes[i+1];
            }
            postFixes[i] = num;
        }
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = prefixes[i] * postFixes[i];
        }
        return result;
    }

    public int[] withNaive(int[] nums){
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
