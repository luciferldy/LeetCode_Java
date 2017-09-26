public class Solution88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                num[k++] = nums1[i++];
            } else {
                num[k++] = nums2[j++];
            }
        }
        if (i == m) {
            while(j < n) {
                num[k++] = nums2[j++];
            }
        }
        if (j == n) {
            while(i < m) {
                num[k++] = nums1[i++];
            }
        }

        for ( i = 0; i < m+n; i++) {
            nums1[i] = num[i];
        }
    }
}
