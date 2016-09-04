package SweepLine;

import java.util.*;

/**
 * Given an interval list which are flying and landing time of the flight.
 * How many airplanes are on the sky at most?
 *
 * For interval list

 [
 [1,10],
 [2,3],
 [5,8],
 [4,7]
 ]
 */


public class numberOfAirplanes {



    public class Interval
    {
        int start, end;
        Interval( int start, int end){
        this.start = start;
        this.end = end;
        }
    }

    class point {
        int time;
        int isStart;

        public point(int _time, int _isStart){
            this.time = _time;
            this.isStart = _isStart;
        }
    }

    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if(airplanes==null || airplanes.size()==0){
            return 0;
        }

        int max = 0, cnt = 0;
        List<point> list = new ArrayList<>();
        for(Interval in : airplanes){
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


    //method 2 hashmap
    public int countOfAirplanes2(List<Interval> airplanes) {
        // write your code here
        int max = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        for (Interval interval: airplanes) {
            for (int i = interval.start; i < interval.end; ++i) {
                if (hashMap.containsKey(i)) {
                    hashMap.put(i, hashMap.get(i) + 1);
                } else {
                    hashMap.put(i, 1);
                }
                max = Math.max(hashMap.get(i), max);
            }
        }
        return max;
    }

}
