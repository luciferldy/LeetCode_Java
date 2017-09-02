import java.util.ArrayList;
import java.util.Arrays;

public class Solution66_PlusOne {

    public int[] plusOne(int[] digits) {
        ArrayList<Integer> l = new ArrayList<>();
        int up = 1;
        for (int i = digits.length-1; i>=0; i--) {
            l.add(0, (digits[i]+up)%10);
            up = (digits[i]+up)/10;
        }

        if (up != 0) {
            l.add(0, up);
        }

        int[] result = new int[l.size()];
        for (int i = 0; i < l.size(); i++)
            result[i] = l.get(i);

        return result;
    }
}
