import java.util.stream.StreamSupport;

public class Solution69_Sqrt {

    public static void main(String[] args) {
        Solution69_Sqrt s = new Solution69_Sqrt();
        int result = s.mySqrt(2147395599);
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        if (x == 1)
            return 1;

        long s, m = 1, e;
        s = 1;
        e = x/2;

        if (e * e <= x) {
            return (int) e;
        }

        for (int i = 0; i <= x/2; i++) {
            m = (s + e) / 2;
//            System.out.println(String.format("i = %d, m = %d, s = %d, e = %d",
//                    i,
//                    m,
//                    s,
//                    e));
            if (s == e)
                break;

            if (m * m > x) {
                e = m;
            } else if (m * m < x) {
                s = m;
            } else {
               break;
            }
        }

        return (int) m;
    }
}
