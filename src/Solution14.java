public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char ch;
        StringBuilder builder = new StringBuilder();
        boolean stop;
        for (int i = 0; i < strs[0].length(); i++) {
            ch = strs[0].charAt(i);
            stop = false;
            for (int j = 1; j < strs.length; j++) {
                if (j >= strs[j].length() || strs[j].charAt(i) != ch) {
                    stop = true;
                    break;
                }
            }
            if (!stop) {
                builder.append(ch);
            } else {
                break;
            }
        }
        return builder.toString();
    }
}
