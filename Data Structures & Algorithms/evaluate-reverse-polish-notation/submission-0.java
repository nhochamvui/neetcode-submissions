class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        List<String> ops = List.of("+", "-", "*", "/");
        for (int i = 0; i < tokens.length; i++) {
            if (ops.contains(tokens[i])) {
                int sec = stack.pop();
                int first = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(sec + first);
                        break;
                    case "-":
                        stack.push(first - sec);
                        break;
                    case "*":
                        stack.push(first * sec);
                        break;
                    case "/":
                        stack.push(first / sec);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
