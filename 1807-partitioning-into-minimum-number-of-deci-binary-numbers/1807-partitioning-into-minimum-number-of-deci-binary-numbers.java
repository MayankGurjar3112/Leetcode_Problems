class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (int i : n.toCharArray()) {
            max = Math.max(i - '0', max);
            if (max == 9)
                break;
        }
        return max;
    }
}