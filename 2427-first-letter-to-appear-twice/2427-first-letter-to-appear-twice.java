class Solution {
    public char repeatedCharacter(String s) {
        Set<Integer> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c - 'a'))
                return c;
            set.add(c - 'a');
        }

        return '.';
    }
}