package SweepLine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:
 Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 */
public class insertInterval {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList();
        if(intervals.size()<1) {
            result.add(newInterval);
            return result;
        }

        int i = 0, len = intervals.size();
        while(i<len && intervals.get(i).end<newInterval.start){
            result.add(intervals.get(i));
            i++;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        while(i<len && intervals.get(i).start<=newInterval.end){
            start = Math.min(intervals.get(i).start,start);
            end = Math.max(end,intervals.get(i).end);
            i++;
        }

        result.add(new Interval(start,end));
        while(i<len){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }

}
