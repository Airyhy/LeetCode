import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Christina on 2/19/16.
 */
public class InsertInterval {
    /**
     * sort intervals according to the start  then merge with the next one if needed
     *
     * find the place to insert
     * */
    //already sorted and the original do not need to be merged
    //O(n), O(1)
    //testcase: 开头, 结尾, 中间不干涉, 中间干涉1-3个
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int ids = 0;
        while (ids < intervals.size() && newInterval.start > intervals.get(ids).start) {ids++;}
        intervals.add(ids, newInterval);
        for (int i = Math.max(ids - 1, 0); i < intervals.size() - 1; ++i) {
            if (intervals.get(i).end < intervals.get(i + 1).start) {
                if (i >= ids) break;
                continue;
            }
            intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
            intervals.remove(i + 1);
            i--;
        }
        return intervals;
    }

    //unordered  sort together  merge all
    //O(nLog(n)), O(1)
    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < intervals.size() - 1; ++i) {
            if (intervals.get(i).end < intervals.get(i + 1).start) {continue;}
            intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
            intervals.remove(i + 1);
            i--;
        }
        return intervals;
    }

    //testcase

}
