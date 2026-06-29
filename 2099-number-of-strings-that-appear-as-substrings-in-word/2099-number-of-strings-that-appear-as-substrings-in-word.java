class Solution {
    public int numOfStrings(String[] patterns, String word) {
        word = " ".concat(word).concat(" ");
        int count = 0;
        for (String s : patterns) {
            String[] temp = word.split(s);
            if (temp.length > 1)
                count++;
        }
        return count;
    }
}