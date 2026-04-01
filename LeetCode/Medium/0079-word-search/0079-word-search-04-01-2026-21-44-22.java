class Solution {
    public int rows,columns;
    public int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        columns = board[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(board[r][c]==word.charAt(0)){
                    if(dfs(board,r,c,0,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int r,int c,int index,String word){
        if(index==word.length()){
            return true;
        }
        if(r<0||c<0||r>=rows||c>=columns||board[r][c]!=word.charAt(index)){//board[r][c]=='#' -> false
            return false;
        }
        char currChar = board[r][c];
        board[r][c]='#';
        for(int[] d:directions){
            if(dfs(board,r+d[0],c+d[1],index+1,word)){
                return true;
            }
        }
        board[r][c]=currChar;
        return false;
    }
}