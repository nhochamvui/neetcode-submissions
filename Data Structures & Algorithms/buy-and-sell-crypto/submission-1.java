class Solution {
    // [7, 1, 5, 3, 6, 4]
    public int maxProfit(int[] prices) {
        int max = 0;
        int minB = prices[0];
        for(int p : prices){
            max = Math.max(max, p - minB);
            minB = Math.min(minB, p);
        }
        return max;
    }
}
