public class Solution91_DecodeWays {

    int count;

    public static void main(String[] args) {
        Solution91_DecodeWays s = new Solution91_DecodeWays();
        String str = "1168963884134125126536966946586868418993819971673459188478711546479621135253876271366851168524933185";
        s.numDecodings(str);
        System.out.println(s.count);
    }

    public int numDecodings(String s) {

        if (s == null || s.equals(""))
            return 0;

        count = 0;

        char[] ch = s.toCharArray();
        backTracing(ch, 0);

        return count;
    }

    private void backTracing(char[] ch, int i) {
        if (i >= ch.length) {
            count++;
            return;
        }

        // 开头不能为0
        if (ch[i] == '0') {
            return;
        }

        if (i+1 < ch.length) {
            // 如果第二位是 0 的话则一定跟随前一位
            if (ch[i+1] == '0') {
                Integer t = Integer.parseInt(String.valueOf(ch, i, 2));
                if (t == 10 || t == 20)
                    backTracing(ch, i+2);
            } else {
                Integer t = Integer.parseInt(String.valueOf(ch, i, 2));
                if (t > 0 && t < 27) {
                    // 多了一种回溯方法
                    backTracing(ch, i+2);
                }
                backTracing(ch, i+1);
            }
        } else {
            backTracing(ch, i+1);
        }
    }
}
