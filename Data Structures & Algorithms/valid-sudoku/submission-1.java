class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<String, Set<Character>> squareMap = new HashMap<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char x = board[i][j];
                if(x == '.'){
                    continue;
                }
                String squareKey = (i / 3) + "," + (j / 3);
                if(colMap.computeIfAbsent(j, k -> new HashSet<>()).contains(x)
                 || rowMap.computeIfAbsent(i, k -> new HashSet<>()).contains(x)
                 || squareMap.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(x)){
                    return false;
                }
                rowMap.get(i).add(x);
                colMap.get(j).add(x);
                squareMap.get(squareKey).add(x);
            }
        }
        return true;
    }
}
