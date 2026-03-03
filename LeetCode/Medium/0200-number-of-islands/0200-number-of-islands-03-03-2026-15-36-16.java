class Solution {
    public int rows,columns,count;
    public int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(grid[r][c]=='1'){
                    dfs(grid,r,c);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int r,int c){
        if(r<0 || c<0 || r>=rows || c>=columns || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        for(int[] d : directions){
            dfs(grid,r+d[0],c+d[1]);
        }
    }
}