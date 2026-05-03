class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (char c : s.toCharArray()) {
            int i = c - 'a';

            if (i == 1 && stack.peek() == 0) {
                stack.pop();
                stack.push(4);
            } else if (i == 2 && stack.peek() == 4)
                stack.pop();
            else
                stack.push(i);
        }

        if (stack.peek() == -1)
            return true;
        return false;
    }
}