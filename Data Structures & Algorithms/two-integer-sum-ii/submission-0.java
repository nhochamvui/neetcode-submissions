class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i+1; j < numbers.length; j++){
                int x = numbers[i];
                int y = numbers[j];
                if(x+y == target){
                    return new int[]{ i+1, j+1 };
                }
            }
        }

        return null;
    }
}
