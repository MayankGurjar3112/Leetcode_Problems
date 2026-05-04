class Trie {
    class Node {
        private Node[] node = new Node[26];
        private boolean flag = false;

        public boolean containsKey(char c) {
            return node[c - 'a'] != null;
        }

        public Node get(char c) {
            return node[c - 'a'];
        }

        public void put(char c, Node n) {
            node[c - 'a'] = n;
        }

        public void setEnd() {
            flag = true;
        }

        public boolean isEnd() {
            return flag;
        }
    }

    Node root = new Node();
    
    public void insert(String word) {
        Node temp = root;

        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!temp.containsKey(c)) 
                temp.put(c, new Node());
            temp = temp.get(c);
        }

        temp.setEnd();
    }
    
    public boolean search(String word) {
        Node temp = root;

        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!temp.containsKey(c)) 
                return false;
            temp = temp.get(c);
        }

        return temp.isEnd();        
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;

        int n = prefix.length();
        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);
            if (!temp.containsKey(c)) 
                return false;
            temp = temp.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */