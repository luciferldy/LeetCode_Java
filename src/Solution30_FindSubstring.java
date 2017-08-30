import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution30_FindSubstring {

    public static void main(String[] args) {
        Solution30_FindSubstring s = new Solution30_FindSubstring();
        String str = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        List<Integer> result = s.findSubstring(str, words);
        System.out.println(result);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();

        int len = words[0].length();
        int size = words.length;

        if (s.length() < len*size) {
            return result;
        }

        // 初始化 hashmap
        HashMap<String, Integer> map = new HashMap<>();

        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }

        HashMap<String, Integer> tmp = new HashMap<>();

        // 匹配的话最多进行到 s.length()-len*size+1 处
        for (int i = 0; i < s.length()-len*size+1; i++) {

            tmp.clear();
            tmp.putAll(map);

            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i+j*len, i+j*len+len);
                if (tmp.containsKey(str)) {
                    int num = tmp.get(str);
                    if (num == 1) {
                        tmp.remove(str);
                    } else {
                        tmp.put(str, num-1);
                    }
                } else {
                    break;
                }
            }

            if (tmp.isEmpty()) {
                result.add(i);
            }
        }

        return result;
    }

    private void printArray(String[] words) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            builder.append(words[i]);
            if (i != words.length-1) {
                builder.append(", ");
            }
        }
        System.out.println(builder.toString());
    }
}
