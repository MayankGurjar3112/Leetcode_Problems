class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        List<Integer> list = new ArrayList<>();

        for (List<Integer> i : edges)
            in[i.get(1)]++;

        for (int i = 0; i < n; i++)
            if (in[i] == 0) 
                list.add(i);

        return list;
    }
}