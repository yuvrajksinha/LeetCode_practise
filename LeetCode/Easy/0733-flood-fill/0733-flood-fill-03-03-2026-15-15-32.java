class Solution {
    public int rows,columns,original;
    public int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        columns = image[0].length;
        original = image[sr][sc];
        if(original==color){
            return image;
        }
        dfs(image,sr,sc,color);
        return image;
    }
    public void dfs(int[][] image,int r,int c,int color){
        if(r<0 || c<0 || r>=rows || c>=columns || image[r][c]!=original){
            return;
        }
        image[r][c]=color;
        for(int[] d : directions){
            dfs(image,r+d[0],c+d[1],color);
        }
    }
}