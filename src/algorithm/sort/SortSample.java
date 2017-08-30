package algorithm.sort;

import java.util.Arrays;

public class SortSample {

    public static void main(String[] args) {

        int[] num = new int[]{1, 3, 5, 3, 4, 5, 9, 7, 5, 6};

        // mergeSort
//        int[] n1 = Arrays.copyOf(num, num.length);
//        mergeSort(n1);
//        printArray(n1);

        // bubbleSort
//        int[] n2 = Arrays.copyOf(num, num.length);
//        bubbleSort(n2);
//        printArray(n2);

        // selectionSort
//        int[] n3 = Arrays.copyOf(num, num.length);
//        selectionSort(n3);
//        printArray(n3);
//
        // insertSort
//        int[] n4 = Arrays.copyOf(num, num.length);
//        insertSort(n4);
//        printArray(n4);


        // quickSort
        int[] n5 = Arrays.copyOf(num, num.length);
        printArray(n5);
        quickSort(n5);
        printArray(n5);
    }

    private static void quickSort(int[] num) {
        quickSortRecursive(num, 0, num.length-1);
    }

    private static void quickSortRecursive(int[] arr, int start, int end) {

        if (start >= end)
            return;
        int mid = arr[end];
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right)
                left++;
            while (arr[right] >= mid && left < right)
                right--;
            swap(arr, left, right);
        }
        if (arr[left] >= arr[end])
            swap(arr, left, end);
        else
            left++;

//        System.out.println(String.format("start=%d, left=%d, end=%d", start, left, end));
        quickSortRecursive(arr, start, left - 1);
        quickSortRecursive(arr, left+1, end);

//        if (start >= end)
//            return;
//        int mid = arr[end];
//        int left = start, right = end-1;
//        while (left < right) {
//            while (left < right && arr[left] <= mid)
//                left++;
//            while (left < right && arr[right] >= mid)
//                right--;
//            // 当 left == right 时就不用交还了
//            if (left != right)
//                swap(arr, left, right);
//        }
//
//        System.out.println(left);
//        printArray(arr);
//        if (arr[left] >= arr[end]) {
//            swap(arr, left, end);
//        } else {
//            left++;
//        }
//
//        quickSortRecursive(arr, start, left-1);
//        quickSortRecursive(arr, left, end);
    }

    private static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    private static void insertSort(int[] num) {
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < i; j++) {
                if (num[j] > num[i]) {
                    // 把 num[i] 插到 num[j] 的位置，num[j] 及其向后倒 num[i-1] 的所有数字向后移动一位
                    num[j] = num[i];
                    int t = i-1;
                    while (t-1 >= j) {
                        num[t] = num[t-1];
                        t--;
                    }
                }
            }
        }
    }

    private static void bubbleSort(int[] num) {
        int tmp;
        for (int i = num.length-1; i >= 0; i--) {
            // 第一遍排序后最大的数字排到了最后
            for (int j = 0; j < i; j++) {
                if (num[j] > num[j+1]) {
                    tmp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = tmp;
                }
            }
        }
    }

    private static void mergeSort(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }
        sort(num, 0, num.length-1);
    }

    private static void selectionSort(int[] num) {
        int tmp;
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[j] < num[i]) {
                    tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                }
            }
        }
    }

    private static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(a, left, mid);
        sort(a, mid+1, right);
        merge(a, left, mid, right);
    }

    /**
     * 此时 严格 left < right
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    private static void merge(int[] a, int left, int mid, int right) {
//        System.out.println(String.format("merge left=%d, mid=%d, right=%d", left, mid, right));
        // 这样对于空间的利用不好，可以直接传递到这边一个 a.length 的数组作为参数
        int[] tmp = new int[right-left+1];
        int t = 0;
        int l1 = left;
        int l2 = mid+1;
        while (l1 <= mid && l2 <= right) {
            if (a[l1] <= a[l2]) {
                tmp[t++] = a[l1++];
            } else {
                tmp[t++] = a[l2++];
            }
        }

        while (l1 <= mid) {
            tmp[t++] = a[l1++];
        }
        while (l2 <= right) {
            tmp[t++] = a[l2++];
        }

        // 对数组进行一个拷贝
        for (int i = left; i <= right; i++) {
            a[left] = tmp[i-left];
        }
    }

    private static void printArray(int[] num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            builder.append(num[i]);
            if (i != num.length-1) {
                builder.append(", ");
            }
        }
        System.out.println(builder.toString());
    }


}
