import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Solution49_GroupAnagrams {

    public static void main(String[] args) {
        Solution49_GroupAnagrams s = new Solution49_GroupAnagrams();
        String res = s.sort("eat");
        System.out.print(res);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null)
            return null;
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 0)
            return result;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String after = sort(str);
            if (map.containsKey(after)) {
                map.get(after).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(after, list);
            }
        }

        result.addAll(map.values());
        return result;
    }

    private String sort(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            for (int j = i+1; j < ch.length; j++) {
                if (ch[i] > ch[j]) {
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                }
            }
        }
        return String.valueOf(ch);
    }
}
