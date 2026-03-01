class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> q = new ArrayDeque<>();
        char[] c = senate.toCharArray();
        int d = 0, r = 0, remd = 0, remr = 0;

        for (char i : c) {
            int n = i == 'R' ? 0 : 1;
            q.add(n);
            if (n == 0)
                r++;
            else
                d++;
        }

        while (q.size() > 1 && d != 0 && r != 0) {
            Integer cur = q.remove();
            if (cur == 0) {
                if (remr > 0) {
                    r--;
                    remr--;
                } else {
                    q.add(cur);
                    remd++;
                }
            } else {
                if (remd > 0) {
                    d--;
                    remd--;
                } else {
                    q.add(cur);
                    remr++;
                }
            }
        }

        return d < r ? "Radiant" : "Dire";
    }
}