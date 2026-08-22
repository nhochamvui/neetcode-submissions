class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<Character>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(!stack.isEmpty() && stack.peek() == map.get(c)){
                    stack.pop();
                }
                else {
                    return false;
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
