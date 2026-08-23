class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] res = new int[size];
        if (size == 1) {
            return res;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            int future = temperatures[i];

            while (!stack.isEmpty() && temperatures[(int) stack.peek()] < future) {
                int idx = (int) stack.peek();
                int tar = temperatures[idx];
                if (tar < future) {
                    res[idx] = i - idx;
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return res;
    }
}
