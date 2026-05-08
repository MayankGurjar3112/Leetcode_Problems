class Solution {
    public boolean canAliceWin(int n) {
        boolean alice = true;
        for (int i = 10; n > 0; i--) {
            if (n < i)
                break;
            n -= i;
            alice = !alice;
        }
        return !alice;
    }
}