public class Solution28_Str2 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }

        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean ok = true;
                // needle.length 或者 1
                for (int j = 1; j < needle.length(); j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return i;
                }
            }
        }
        return -1;
    }
}
