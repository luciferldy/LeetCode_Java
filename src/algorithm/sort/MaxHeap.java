package algorithm.sort;

public class MaxHeap {

    int[] heap;
    int heapSize;

    public MaxHeap(int[] array) {
        this.heap = array;
        this.heapSize = array.length;
    }

    public void buildMaxHeap() {
        for (int i = heapSize/2-1; i >= 0; i++) {
            maxify(i);
        }
    }

    public void heapSort() {
        for (int i = 0; i < heap.length; i++) {
            // 执行 n 次
            int tmp = heap[0];
            heap[0] = heap[heapSize-1];
            heap[heapSize-1] = tmp;
            heapSize--;
            maxify(0);
        }
    }

    public void maxify(int i) {
        int l = left(i);
        int r = right(i);
        int max;

        if (l < heapSize && heap[l] > heap[i])
            max = l;
        else
            max = i;
        if (r < heapSize && heap[r] > heap[i])
            max = r;

        if (max == i || max >= heapSize)
            return;

        int tmp = heap[i];
        heap[i] = heap[max];
        heap[max] = tmp;

        maxify(max);
    }

    private int parent(int i) {
        return (i-1)/2;
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return 2*i+2;
    }
}
