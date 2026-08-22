class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            Set<Character> map = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char x = board[i][j];
                if(x == '.'){
                    continue;
                }
                if(map.contains(x)){
                    return false;
                }

                map.add(x);
            }
        }

        for(int i = 0; i < 9; i++){
            Set<Character> map = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char x = board[j][i];
                if(x == '.'){
                    continue;
                }
                if(map.contains(x)){
                    return false;
                }

                map.add(x);
            }
        }
        for(int square = 0; square < 9; square++){
            Set<Character> map = new HashSet<>();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    char x = board[row][col];
                    if(x == '.'){
                        continue;
                    }
                    if(map.contains(x)){
                        return false;
                    }

                    map.add(x);
                }
            }
        }
        return true;
        // 0 -> 8
        // 0 1 2 | 3 4 5 | 6 7 8
        // 1     |       | 
        // 2     |       |
      // 3 ----------------------
        // 3     |       |
        // 4     |       |
        // 5     |       |
    }
}
