class Solution {
    public int minimumOperations(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode Null = new TreeNode();

        q.add(root);
        q.add(Null);

        int count = 0;

        while (!q.isEmpty()) {
            TreeNode cur = q.remove();

            if (cur == Null) {
                if (!list.isEmpty()) {
                    count += getMinSwaps(list);
                }
                list = new ArrayList<>();
                if (q.isEmpty()) break;
                q.add(Null);
            } else {
                list.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return count;
    }

    private int getMinSwaps(List<Integer> l) {
        int n = l.size();
        int[] arr = new int[n];
        int[] sorted = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = l.get(i);
            sorted[i] = arr[i];
        }
        
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != sorted[i]) {
                swaps++;
                
                int currentVal = arr[i];
                int targetVal = sorted[i];
                int targetIdx = map.get(targetVal);

                arr[targetIdx] = currentVal;
                arr[i] = targetVal;

                map.put(currentVal, targetIdx);
            }
        }
        return swaps;
    }
}