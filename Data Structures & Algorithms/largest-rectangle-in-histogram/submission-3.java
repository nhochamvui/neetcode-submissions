class Solution {
    public int largestRectangleArea(int[] heights) {
        // find the shortest left & right of every height
        int size = heights.length;
        int[] leftMost = new int[size];
        int[] rightMost = new int[size];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < size; i++) {
            leftMost[i] = 0;
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek() + 1;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = size - 1; i >= 0; i--) {
            rightMost[i] = size - 1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek() - 1;
            }
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < size; i++) {
            int width = (rightMost[i] - leftMost[i]) + 1;
            int area = width * heights[i];
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
}
