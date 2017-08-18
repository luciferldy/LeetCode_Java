import java.util.Stack;

public class Solution20_ValidParentheses {

    public static void main(String[] args) {
        Solution20_ValidParentheses s = new Solution20_ValidParentheses();
        System.out.println(s.isValid("()"));
    }

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length()%2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.size() != 0 && stack.pop() == '(') {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (stack.size() != 0 && stack.pop() == '[') {
                        break;
                    } else {
                        return false;
                    }
                case '}':
                    if (stack.size() != 0 && stack.pop() == '{') {
                        break;
                    } else {
                        return false;
                    }
                    default:
                        return false;
            }
        }

        return stack.size() == 0;
    }
}
