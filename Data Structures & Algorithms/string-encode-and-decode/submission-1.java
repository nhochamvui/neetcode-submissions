class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for(String s : strs){
            result += s + '`';
        }
        // System.out.println(result);
        return result;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        if(str.length() > 0){
            String temp = "";
            for(char c : str.toCharArray()){
                if(c == '`'){
                    result.add(temp);
                    temp = "";
                }
                else{
                    temp += c;
                }
            }
        }
        
        return result;
    }
}
