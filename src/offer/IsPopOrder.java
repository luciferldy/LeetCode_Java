package offer;

import java.util.Scanner;
import java.util.Stack;

public class IsPopOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] push = new int[n];
            int[] pop = new int[n];

            for (int i = 0; i < n; i++) {
                push[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                pop[i] = scanner.nextInt();
            }

            boolean result = isPopOrder(push, pop);
            System.out.println("result " + result);
        }
    }

    private static boolean isPopOrder(int[] push, int[] pop) {
        boolean possible = false;

        int i1 = 0, i2 = 0;
        if (push != null && pop != null) {
            Stack<Integer> stack = new Stack<>();

            while (i1 < push.length || i2 < pop.length) {

                // 直到找到 push 中与 pop 相应位置匹配的数字
                while (stack.empty() || stack.peek() != pop[i2]) {
                    if (i1 == push.length)
                        break;
                    stack.push(push[i1]);
                    i1++;
                }

                // 跳出来表示 stack.peek() == pop[i2] 或者栈里压满了。
                if (stack.peek() != pop[i2])
                    break;

                stack.pop();
                i2++;
            }

            if (stack.empty() && i2 == pop.length)
                possible = true;
        }

        return possible;
    }
}
