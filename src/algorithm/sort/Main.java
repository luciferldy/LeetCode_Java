package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] ls = line.split(" ");
            if (ls.length != 2) {
                continue;
            }
            int l, r;
            try {
                l = Integer.parseInt(ls[0].trim());
                r = Integer.parseInt(ls[1].trim());
            } catch (Exception e) {
                continue;
            }
            if (l >= 1 && r <= 1000000000 && r-1 >= 0 && r-1 <= 1000000) {
                System.out.println(countAmazing(l, r));
            }
        }
    }

    private static int countAmazing(int l, int r) {
        int c = 0;
        for (int i = l; i <= r; i++) {
            if (isLegal(i))
                c++;
        }
        return c;
    }

    private static boolean isLegal(int num) {
        String str = String.valueOf(num);
        char[] s = str.toCharArray();
        int[] c = new int[s.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = s[i] - '0';
        }
        Arrays.sort(c);

        // 判断 c 中有多少
        return true;
    }
}

