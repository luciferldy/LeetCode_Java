package string;

/**
 * 参考阮一峰 http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * 下面可能是多余的
 * {@link "http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html"}
 */
public class KMP {

    public static void main(String[] args) {
        String a = "BBC ABCDAB ABCDABCDABDE";
        String b = "ABCDABD";

        if (kmp(a, b)) {
            System.out.println("kmp return true.");
        } else {
            System.out.println("kmp return false.");
        }
    }

    public static boolean kmp(String a, String b) {
        int n = b.length();
        int[] part = new int[n];
        for (int i = 0; i < n; i++) {
            String s = b.substring(0, i+1);
//            String prev = s.substring(0, s.length()-1);
//            String next = s.substring(1, s.length());
//            System.out.println(String.format("prev: %s, next: %s", prev, next));

            part[i] = partition(s);
        }

        printArray(part);

        int i = 0;
        int move = 0;
        while (i < a.length()-n+1) {
            int j;
            for (j = 0; j < n; j++) {
                if (a.charAt(i+j) != b.charAt(j)) {
                    // 在 j 处无法匹配表示已经有 j 个匹配了。好好想一下可以的
                    if (j == 0) {
                        break;
                    }
                    // move 的距离=已经匹配的字符数-对应部分的匹配值
                    move = j-part[j-1];
                    break;
                }
            }

            // 当第一位就不匹配时
            if (j == 0) {
                i++;
                continue;
            }

            if (j == n) {
                System.out.println(String.format("%s match %s", b, a.substring(i)));
                return true;
            }

            System.out.println(String.format("move %d",  move));
            // 移动
            if (move > 0)
                i+=move;
            else
                i++;
        }

        return false;
    }

    private static int partition(String src) {
        int len = src.length();
        String[] prev = new String[len-1];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = src.substring(0, i+1);
        }
        String[] next = new String[len-1];
        for (int i = 0; i < prev.length; i++) {
            next[i] = src.substring(len-1-i);
        }

        int max = 0;
        for (int i = 0; i < prev.length; i++) {
            for (int j = 0; j < next.length; j++) {
                if (prev[i].equals(next[j])) {
                    if (prev[i].length() > max) {
                        max = prev[i].length();
                    }
                }
            }
        }

        return max;
    }

    // 最长公共子串，注意区分最长公共子序列
    public static int lcss(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] c = new int[m][n];

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    if (a.charAt(i) == b.charAt(j)) {
                        c[i][j] = 1;
                        if (1 > max)
                            max = 1;
                    } else {
                        c[i][j] = 0;
                    }
                    continue;
                }

                if (a.charAt(i) == b.charAt(j)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    if (c[i][j] > max)
                        max = c[i][j];
                } else {
                    c[i][j] = 0;
                }
            }
        }

        return max;
    }

    private static void printArray(int[] arr) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            b.append(arr[i]);
            if (i != arr.length-1) {
                b.append(", ");
            }
        }
        System.out.println(b.toString());
    }
}
