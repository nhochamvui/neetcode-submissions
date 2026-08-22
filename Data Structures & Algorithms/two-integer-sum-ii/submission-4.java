class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left <= right - 1 || right >= left + 1){
            int x = numbers[left];
            int y = numbers[right];
            if(x + y > target){
                right--;
                continue;
            }
            if(x + y < target){
                left++;
                continue;
            }
            return new int[]{left+1, right+1};
        }

        return null;
    }
}
