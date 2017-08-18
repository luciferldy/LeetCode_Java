import java.util.ArrayList;
import java.util.List;

public class Solution22_GenerateParenthesis {

    public static void main(String[] args) {
        Solution22_GenerateParenthesis s = new Solution22_GenerateParenthesis();
        List<String> r = s.generateParenthesis(3);
        System.out.println(r);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, n, "", res);
        return res;
    }

    private void generate(int left, int right, String o, List<String> res) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(o);
            return;
        }
        generate(left-1, right, o+"(", res);
        generate(left, right-1, o+")", res);
    }
}
