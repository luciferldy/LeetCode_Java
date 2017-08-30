public class Solution38_CountAndSay {
    public static void main(String[] args) {
        Solution38_CountAndSay s = new Solution38_CountAndSay();
        System.out.println(s.countAndSay(12));
    }

    /**
     * shit
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String s = "1";
        int i = 1, j;
        StringBuilder builder = new StringBuilder();
        while (i < n) {
            j = 0;
            builder.delete(0, builder.length());
            while (j < s.length()) {
                char ch = s.charAt(j);
                int c = 1, k = j+1;
                while (k < s.length()) {
                    if (ch == s.charAt(k)) {
                        c++;
                        k++;
                    } else {
                        break;
                    }
                }
                builder.append(c);
                builder.append(ch);
                j += c;
            }
            s = builder.toString();
            i++;
        }

        return s;
    }
}
