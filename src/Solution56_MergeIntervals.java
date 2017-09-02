import utils.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution56_MergeIntervals {

    public static void main(String[] args) {
        Solution56_MergeIntervals s = new Solution56_MergeIntervals();
        List<Interval> l = new ArrayList<>();
        l.add(new Interval(1 ,4));
        l.add(new Interval(0, 1));
        s.merge(l);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null)
            return null;
        if (intervals.size() == 0)
            return intervals;

        List<Interval> res = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start || (o1.start == o2.start && o1.end < o2.end)) {
                    return -1;
                } else if (o1.start > o2.start) {
                    return 1;
                }
                return 0;
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            System.out.println(String.format("start: %d, end: %d", intervals.get(i).start, intervals.get(i).end));
        }

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (end >= intervals.get(i).start) {
                if (end < intervals.get(i).end)
                    end = intervals.get(i).end;
            } else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        res.add(new Interval(start, end));

        return res;
    }

    private void sort(List<Interval> intervals) {
        int size = intervals.size();
        Interval t1, t2;
        int start, end;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                t1 = intervals.get(i);
                t2 = intervals.get(j);
                if (t1.start > t2.start ||
                        (t1.start == t2.start && t1.end > t2.end)) {
                    start = t1.start;
                    end = t1.end;
                    t1.start = t2.start;
                    t1.end = t2.end;
                    t2.start = start;
                    t2.end = end;
                }
            }
        }
    }
}
