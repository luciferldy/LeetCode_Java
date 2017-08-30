public class Solution29_Divide {

    public static void main(String[] args) {
        Solution29_Divide s = new Solution29_Divide();
        System.out.println(-7/2);
        System.out.println(s.divide(Integer.MIN_VALUE, 1));
    }

    public int divide(int dividend, int divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        int c = 0, sum = 0;
        if (dividend > 0 && divisor < 0) {
            while (true) {
                sum += -divisor;
                c++;
                if (sum == dividend) {
                    return -c;
                } else if (sum > dividend) {
                    // 可以包含当 abs(dividend) < abs(divisor) 的情况
                    return -(--c);
                }
            }
        } else if (dividend < 0 && divisor > 0) {
            while (true) {
                sum -= divisor;
                c++;
                if (sum == dividend) {
                    return -c;
                } else if (sum < dividend) {
                    return -(--c);
                }
            }
        } else if (dividend < 0 && divisor < 0) {
            while (true) {
                sum += divisor;
                c++;
                if (sum == dividend) {
                    return c;
                } else if (sum < dividend) {
                    return --c;
                }
            }
        } else {
            while (true) {
                sum += divisor;
                c++;
                if (sum == dividend) {
                    return c;
                } else if (sum > dividend) {
                    return --c;
                }
            }
        }
    }
}
