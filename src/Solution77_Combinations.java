import java.util.ArrayList;
import java.util.List;

public class Solution77_Combinations {

    List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        Solution77_Combinations s = new Solution77_Combinations();
        s.combine(5, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || n < k || k < 1) {
            return new ArrayList<>();
        }

        res.clear();
        List<Integer> current = new ArrayList<>();
        backtracking(current, k, n, 0);

        printArray();

        return res;
    }

    void backtracking(List<Integer> current,
                      int k, int n, int last) {
        if (k == 0) {
            res.add(new ArrayList<>(current));
        } else {
            for (int i = last+1; i <= n-k+1; i++) {
                current.add(i);
                backtracking(current, k-1, n, i);
                current.remove(current.size()-1);
            }
        }

    }

    void printArray() {
        for (int i = 0; i < res.size(); i++) {
            StringBuilder b = new StringBuilder();
            int n = res.get(i).size();
            for (int j = 0; j < n; j++) {
                b.append(res.get(i).get(j));
                if (j < n-1) {
                    b.append(", ");
                }
            }
            System.out.println(b.toString());
        }
    }
}
