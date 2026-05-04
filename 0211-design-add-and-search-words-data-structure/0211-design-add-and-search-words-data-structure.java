class WordDictionary {
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

    public void addWord(String word) {
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
        return dfs(0, word, root);
    }

    private boolean dfs(int i, String word, Node root) {
        if (root == null)
            return false;
        if (i == word.length() && root.isEnd())
            return true;
        if (i >= word.length())
            return false;

        char c = word.charAt(i);

        if (c == '.') {
            boolean search = false;

            for (int j = 0; j < 26; j++)
                search = search || dfs(i + 1, word, root.get((char) (j + 'a')));

            return search;
        }

        if (root.containsKey(c))
            return dfs(i + 1, word, root.get(c));

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */