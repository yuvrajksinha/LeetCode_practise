class Solution {
    private int rows,columns;
    private int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        rows = heights.length;
        columns = heights[0].length;
        boolean[][] isReachingPacific = new boolean[rows][columns]; //if the cell can reach pacific
        boolean[][] isReachingAtlantic = new boolean[rows][columns];//if the cell can reach atlantic
        for(int r=0;r<rows;r++){ //for all the row elements
            dfs(heights,r,0,isReachingPacific,heights[r][0]);//LEFT most column is true for all row r elements to reach pacific
            dfs(heights,r,columns-1,isReachingAtlantic,heights[r][columns-1]);//same for RIGHT most column elements to reach atlantic as they are in touch with it 
        }
        for(int c=0;c<columns;c++){ //for all the col elements 
            dfs(heights,0,c,isReachingPacific,heights[0][c]);//TOP constant column move
            dfs(heights,rows-1,c,isReachingAtlantic,heights[rows-1][c]);//BOTTOM constant col move 
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                if(isReachingPacific[r][c]&&isReachingAtlantic[r][c]){
                    result.add(List.of(r,c)); 
                }
            }
        }
        return result;
    }
    public void dfs(int[][] heights,int r,int c,boolean[][] isReaching,int prevHeight){
        if(r<0||c<0||r>=rows||c>=columns||isReaching[r][c]||heights[r][c]<prevHeight){//we move up from the oceans to check so will water go up the mountain kinda so the new length we get should be greater than the previous height we got, if its not then no need to go further
            return; 
        }
        isReaching[r][c]=true;//if all of that is satisfying then move inward in 4 directions with prev height as this one and move the rows
        for(int[] d:directions){
            dfs(heights,r+d[0],c+d[1],isReaching,heights[r][c]);
        }
    }
}