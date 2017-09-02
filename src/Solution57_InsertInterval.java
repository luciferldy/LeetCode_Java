import utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution57_InsertInterval {

    public static void main(String[] args) {
        Solution57_InsertInterval s = new Solution57_InsertInterval();
        List<Interval> old = s.generate(new int[]{
                1, 2, 3, 5, 6, 7, 8, 10, 12, 16
        });
        Interval young = new Interval(4, 9);
        List<Interval> res = s.insert(old, young);
        s.printList(res);
    }

    private List<Interval> generate(int[] src) {
        if (src.length%2 != 0)
            return null;
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < src.length; i+=2) {
            res.add(new Interval(src[i], src[i+1]));
        }

        return res;
    }

    private void printList(List<Interval> src) {
        for (int i = 0; i < src.size(); i++) {
            System.out.println(String.format("[%d, %d]", src.get(i).start, src.get(i).end));
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null) {
            if (newInterval == null)
                return null;
            else {
                List<Interval> interval = new ArrayList<>();
                interval.add(newInterval);
                return interval;
            }
        }

        if (newInterval == null)
            return intervals;

        List<Interval> n = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;

        for (int i = 0; i < intervals.size(); i++) {
            Interval t = intervals.get(i);
            if (t.end < start || end < t.start) {
                n.add(t);
                continue;
            }

            start = t.start < start ? t.start : start;
            end = t.end > end ? t.end : end;
        }

        // 需要做一遍插入排序

        int i;
        for (i = 0; i < n.size(); i++) {
            if (start < n.get(i).start) {
                n.add(i, new Interval(start, end));
                break;
            }
        }

        if (i == n.size())
            n.add(new Interval(start, end));

        return n;
    }
}
