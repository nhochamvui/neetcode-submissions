public class Solution {
    public bool IsAnagram(string s, string t) {
        var map = new Dictionary<char, int>();
        foreach(char c in s){
            if(map.ContainsKey(c)){
                map[c] += 1;
            }
            else{
                map.Add(c, 1);
            }
        }

        foreach(char c in t){
            if(map.ContainsKey(c)){
                int current = map[c] - 1;
                if(current == 0){
                    map.Remove(c);
                }
                else {
                    map[c] = current;
                }
            }
            else{
                return false;
            }
        }
        return map.Count == 0;
    }
}
