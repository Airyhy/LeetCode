package VFacebookTemp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *  Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 *  find the minimum number of conference rooms required.

 For example,
 Given [[0, 30],[5, 10],[15, 20]],
 return 2.

 */
public class MeetingRooms2 {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    class point {
        int time;
        int isStart;

        public point(int _time, int _isStart){
            this.time = _time;
            this.isStart = _isStart;
        }
    }

    public int minMeetingRooms(Interval[] intervals) {

        if(intervals==null || intervals.length==0){
            return 0;
        }

        int max = 0, cnt = 0;
        List<point> list = new ArrayList<>();
        for(Interval in : intervals){
            list.add(new point(in.start,1));
            list.add(new point(in.end,0));
        }

        Collections.sort(list, new Comparator<point>(){
            @Override
            public int compare(point p1, point p2){
                if(p1.time == p2.time) return p1.isStart - p2.isStart;
                else return p1.time - p2.time;
            }
        });

        for (point p : list){
            if(p.isStart==1){
                cnt++;
            } else {
                cnt--;
            }
            max = Math.max(max,cnt);
        }
        return max;
    }

}

