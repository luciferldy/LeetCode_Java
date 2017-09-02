import java.util.Arrays;

public class Solution67_AddBinary {

    public static void main(String[] args) {
        Solution67_AddBinary s = new Solution67_AddBinary();
        String result = s.addBinary("11", "1");
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        int m1 = a.length();
        int m2 = b.length();

        if (m1 == 0)
            return b;
        if (m2 == 0)
            return a;

        int maxLength = Math.max(m1, m2);
        int[] a1 = new int[maxLength];
        int[] a2 = new int[maxLength];

        int i, i1, i2;
        for (i = maxLength-1, i1 = m1-1, i2 = m2-1; i >= 0; i--, i1--, i2--) {
            if (i1 >= 0)
                a1[i] = a.charAt(i1) - '0';
            if (i2 >= 0)
                a2[i] = b.charAt(i2) - '0';
        }

        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));

        int up = 0;
        int tmp;
        for (i = a1.length-1; i >= 0; i--) {
            tmp = a1[i] + a2[i] + up;
            up = tmp/2;
            a1[i] = tmp%2;
        }

        StringBuilder builder = new StringBuilder();
        for (i = 0; i < a1.length; i++) {
            builder.append(a1[i]);
        }
        if (up == 0)
            return builder.toString();
        else
            return up+builder.toString();
    }
}
