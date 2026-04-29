/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) 
            return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();

        Queue<Node> q = new ArrayDeque<>();
        Node Null = new Node();

        q.add(root);
        q.add(Null);

        while (!q.isEmpty()) {
            Node cur = q.remove();

            if (cur == Null) {
                list.add(l);
                l = new ArrayList<>();
                if (q.isEmpty())
                    break;
                q.add(Null);
            } else {
                l.add(cur.val);
                for (Node i : cur.children)
                    q.add(i);
            }
        }

        return list;
    }
}