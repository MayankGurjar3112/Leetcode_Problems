class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int prev = -1;

        for (char c : word.toCharArray()) {
            int curr = c - 'a';

            if (prev == curr && count != 9)
                count++;
            else {
                if (prev != -1) {
                    sb.append(count);
                    sb.append((char) (prev + 'a'));
                }
                count = 1;
            }

            prev = curr;
        }

        sb.append(count);
        sb.append((char) (prev + 'a'));

        return sb.toString();
    }
}