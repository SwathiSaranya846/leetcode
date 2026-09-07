class WordDictionary {
    class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEnd;
    }
    TrieNode root;

    public WordDictionary() {
        root=new TrieNode();

        
    }
    
    public void addWord(String word) {
        TrieNode current=root;
        for(char ch:word.toCharArray()){
            int index=ch-'a';
            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.isEnd=true;
        
    }
    
    public boolean search(String word) {
        return dfs(word,0,root);
        
    }
    private boolean dfs(String word,int index,TrieNode node){
        if(index==word.length()){
            return node.isEnd;
        }
        char ch=word.charAt(index);
        if(ch!='.'){
            int i=ch-'a';
            if(node.children[i]==null){
                return false;
            }
            return dfs(word,index+1,node.children[i]);
        }
        for(int i=0;i<26;i++){
            if(node.children[i]!=null){
                if(dfs(word,index+1,node.children[i])){
                    return true;
                }

            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */