class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        long min = Integer.MAX_VALUE;
        long points = 0;
        long ce = currentEnergy;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i : enemyEnergies) {
            pq.add(i);
            min = Math.min(min, i);
        }

        while (!pq.isEmpty()) {
            int cur = pq.remove();
            points += (ce / min);
            ce %= min;
            if (points > 0)
                ce += cur;
        }

        return points;
    }
}