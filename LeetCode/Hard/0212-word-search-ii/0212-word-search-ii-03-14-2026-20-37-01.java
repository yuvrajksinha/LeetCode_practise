class Solution {
    class Trie{
        class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isWord=false;
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
            curr.isWord = true;
        }

        public boolean search(String word){
            TrieNode curr = root;
            for(char c:word.toCharArray()){
                int index = c-'a';
                if(curr.children[index]==null){
                    return false;
                }
                curr = curr.children[index];
            }
            return curr.isWord;
        }

        public boolean startsWith(String prefix){
            TrieNode curr = root;
            for(char c:prefix.toCharArray()){
                int index = c-'a';
                if(curr.children[index]==null){
                    return false;
                }
                curr = curr.children[index];
            }
            return true;
        }
    }

    public int columns,rows;
    public int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }
        this.board = board;
        rows = board.length;
        columns = board[0].length;
        Set<String> set = new HashSet<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<columns;c++){
                dfs(r,c,set,new StringBuilder(),trie);
            }
        }
        return new ArrayList<>(set);
    }

    public void dfs(int r,int c,Set<String> words, StringBuilder word,Trie trie){
        if(r<0||c<0||r>=rows||c>=columns||board[r][c]=='#'){
            return;
        }
        char currLetter = board[r][c];
        word.append(currLetter);
        if(!trie.startsWith(word.toString())){
            word.deleteCharAt(word.length()-1);
            return;
        }
        if(trie.search(word.toString())){
            words.add(word.toString());
        }
        board[r][c]='#';
        for(int[] d:directions){
            dfs(r+d[0],c+d[1],words,word,trie);
        }
        word.deleteCharAt(word.length()-1); //backtrack
        board[r][c]=currLetter;
    }
}