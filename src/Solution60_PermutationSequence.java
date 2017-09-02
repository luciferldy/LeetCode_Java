import utils.Interval;

import java.util.Scanner;

public class Solution60_PermutationSequence {

    public static void main(String[] args) {
        Solution60_PermutationSequence s = new Solution60_PermutationSequence();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] ll = line.split(",");
            if (ll.length != 2)
                continue;
            int n = Integer.valueOf(ll[0].trim());
            int k = Integer.valueOf(ll[1].trim());
            String result = s.getPermutation(n, k);
            System.out.println(result);
        }
    }

    public String getPermutation(int n, int k) {

        int[] src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = i+1;
        }

        String res = recursive(src, k);

        return res;
    }

    public String recursive(int[] a, int b) {

        int sum = 1;
        for (int i = 0; i < a.length; i++)
            sum *= (i+1);

        if (b > sum || b == 0) {
            return "";
        }

        if (a.length == 1)
            return String.valueOf(a[0]);

        int c = b / (sum/a.length);
        int d = b % (sum/a.length);

        int index;
        int bb;
        if (d == 0) {
            index = c-1;
            bb = sum/a.length;
        } else {
            index = c;
            bb = d;
        }

        int[] rs = new int[a.length-1];
        for (int i = 0; i < rs.length; i++) {
            if (i < index) {
                rs[i] = a[i];
            } else {
                rs[i] = a[i+1];
            }
        }

        return a[index] + recursive(rs, bb);
    }
}
