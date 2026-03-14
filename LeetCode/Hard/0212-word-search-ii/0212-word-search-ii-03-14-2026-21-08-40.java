class Solution {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    TrieNode root = new TrieNode();
    public void insert(String word){
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
            }
            curr=curr.children[index];
        }
        curr.word = word;
    }
    public int rows,columns;
    public int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        for(String word:words){
            insert(word);
        }
        rows = board.length;
        columns = board[0].length;
        List<String> list = new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                dfs(board,r,c,root,list);
            }
        }
        return list;
    }
    public void dfs(char[][] board,int r,int c,TrieNode root,List<String> words){
        if(r<0||c<0||r>=rows||c>=columns||board[r][c]=='#'){
            return;
        }
        char currChar = board[r][c];
        //search in Trie itself here 
        int index = currChar-'a'; 
        TrieNode node = root.children[currChar-'a']; //bring root child of the character
        if(node==null){ //if its not there then stop the process here itself
            return;
        }
        if(node.word!=null){//if the node has a word in the word variable, then its a word we inserted
            words.add(node.word); //so add it to the list
            node.word=null; //make it null so its not added again(remove duplicates)
        }
        
        board[r][c]='#';  //mark it as visited and not to be used again in the same word
        for(int[] d:directions){
            dfs(board,r+d[0],c+d[1],node,words);
        }
        board[r][c]=currChar; //when done we backtrack to what it was before
    }
}