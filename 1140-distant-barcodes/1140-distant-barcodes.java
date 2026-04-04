class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int barcode : barcodes) {
            freqMap.put(barcode, freqMap.getOrDefault(barcode, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        int[] res = new int[n];
        int index = 0;
        int[] prev = null;

        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            res[index++] = curr[1];
            curr[0]--;

            if (prev != null && prev[0] > 0) {
                maxHeap.offer(prev);
            }
            
            prev = curr;
        }

        return res;
    }
}