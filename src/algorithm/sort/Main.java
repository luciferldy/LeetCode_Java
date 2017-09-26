package algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Main m = new Main();
        long lo = 10;
        m.a(10, lo);

        if (1 > 0)
            return;

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

    static class A {
        void test() {
            System.out.println("A");
        }
    }

    static class B extends A {
        void test() {
//            super.test();
            System.out.println("B");
        }
    }

    void a(int a, int b){
        System.out.println("int");

    }
    void a(int a, float b){
        System.out.println("float");

    }
    void a(int a, double b){
        System.out.println("double");
    }
}

