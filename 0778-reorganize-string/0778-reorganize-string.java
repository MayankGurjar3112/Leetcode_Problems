class Solution {
    public String reorganizeString(String s) {
        int[][] arr = new int[26][2];

        for (int i = 0; i < 26; i++)
            arr[i][0] = i;

        for (char c : s.toCharArray())
            arr[c - 'a'][1]++;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        for (int i = 0; i < 26; i++)
            if (arr[i][1] != 0)
                pq.add(arr[i]);

        StringBuilder sb = new StringBuilder();
        int[] c1 = null;
        int[] c2 = null;
        while (!pq.isEmpty()) {
            c1 = pq.poll();
            c2 = pq.poll();
            if (c2 == null)
                break;
            sb.append((char) (c1[0] + 'a'));
            c1[1]--;
            sb.append((char) (c2[0] + 'a'));
            c2[1]--;
            if (c1[1] != 0)
                pq.add(c1);
            if (c2[1] != 0)
                pq.add(c2);
        }

        if (c1[1] == 1)
            sb.append((char) (c1[0] + 'a'));
        else if (c1[1] != 0)
            return "";

        return sb.toString();
    }
}