import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {

    Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static void main(String[] args) {
        Solution17 s = new Solution17();
        List<String> res = s.letterCombinations("23");
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            ArrayList<String> a = new ArrayList<>();
            for (char c: map.get(digits.charAt(0)).toCharArray()) {
                a.add(String.valueOf(c));
            }
            return a;
        } else {
            List<String> tmp = letterCombinations(digits.substring(1));
            List<String> res = new ArrayList<>();
            for (char c: (map.get(digits.charAt(0))).toCharArray()) {
                for (String s:
                     tmp) {
                    res.add(c + s);
                }
            }
            return res;
        }

    }
}
