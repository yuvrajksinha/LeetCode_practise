class Trie {
    class TrieNode{
        TrieNode[] children = new TrieNode[26]; //every character node has 26 children node
        boolean isWord = false; //to see if this is a word added or not eg. for apple if we stop at app is that even a word that is added or not
    }

    public TrieNode root=new TrieNode(); //to create a root to go from or start search from
    
    public void insert(String word) {
        TrieNode curr = root; //take a pointer
        for(char c:word.toCharArray()){
            int index = c - 'a'; //calculate index of character in the 26 blocks
            if(curr.children[index]==null){ //if that block doesn't have any extension then create one
                curr.children[index]=new TrieNode(); //add a new trie node there 
            }
            curr=curr.children[index]; //move to the children trie node from current node
        } //eg if insert cat,cap in c will have single entry in a but for a 2 blocks of t and p will have trie nodes 
        curr.isWord = true; //at the end check if that word is one that is added or just a middle of another word that was added we need to put this boolean to check for search
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null){
                return false; //if we find there is null we know that there is no extension of this word that has been inserted in here before so return false
            }
            curr=curr.children[index];
        }
        return curr.isWord; //have to see if the ending is a word or not that has been added
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            int index = c-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return true; //here we don't have to check if its a word that has been added we just see if there are words that start with the prefix 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */