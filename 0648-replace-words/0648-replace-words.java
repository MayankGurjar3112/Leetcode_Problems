class Solution {
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

    public String check(String word) {
        Node temp = root;

        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (!temp.containsKey(c))
                break;
            temp = temp.get(c);
            if (temp.isEnd())
                return word.substring(0, i + 1);
        }

        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String i : dictionary)
            insert(i);

        String[] s = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String i : s) {
            sb.append(check(i));
            sb.append(" ");
        } 

        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}