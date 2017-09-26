import utils.Arrays2;

import java.util.ArrayList;
import java.util.List;

public class Solution89_GrayCode {

    public static void main(String[] args) {
        List<Integer> l = grayCode(2);
        Arrays2.printArray2(l);
    }

    // idea is simple, G(i) = i^(i/2)
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1<<n; i++)
            result.add(i^i>>1);
        return result;
    }
}
