class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int n = num.length();
        
        for (char c : num.toCharArray()) {
            char top = sb.length() == 0 ? '/' : sb.charAt(sb.length() - 1); 
            while (top > c && k > 0) {
                sb.setLength(sb.length() - 1);
                top = sb.length() == 0 ? '/' : sb.charAt(sb.length() - 1); 
                k--;
            }
            sb.append(c);
        } 

        while (sb.length() > 0 && sb.charAt(0) == '0') 
            sb.deleteCharAt(0);

        if (sb.length() == 0 || k >= sb.length()) return "0";

        if (k > 0) sb.setLength(sb.length() - k);

        return sb.toString();
    }
}