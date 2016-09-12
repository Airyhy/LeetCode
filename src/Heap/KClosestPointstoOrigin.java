package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Find the K closest points to the origin in 2D plane, given an array containing N points.
 * You can assume K is much smaller than N and N is very large.
 * You need only use standard math operators (addition, subtraction, multiplication, and division).
 *
 * A: 耗时最多的一道题！！基本思想肯定是用heap，java中用PriorityQueue实现。
 * 注意，题目有写“K is much smaller than N and N is very large”。
 * 应该要加一个filter排除不可能的点，这道题我自己也不是很有把握。。还要注意，只能用加减乘除运算符，也就是不能开方

 ￼
 */
public class KClosestPointstoOrigin {

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public  Point[] getKClosest(Point[] points, Point origin, int k) {
        Point[] result = new Point[k];

        if (k<=0 || points.length < k) {
            return result;
        }

        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {

                return distanceSquare(p2, origin) - distanceSquare(p1, origin);
            }
        });

        int tempMax = Integer.MAX_VALUE;

        for (Point current : points) {
            if (maxHeap.size() < k) {
                maxHeap.offer(current);
            } else {
                if (tempMax==Integer.MAX_VALUE){
                    tempMax = distanceSquare(maxHeap.peek(), origin);
                }

                if( tempMax <= Math.max(current.x,current.y)){
                    continue;
                }

                if (distanceSquare(current, origin) < distanceSquare(maxHeap.peek(), origin)) {
                    maxHeap.poll();
                    maxHeap.offer(current);
                    tempMax = distanceSquare(maxHeap.peek(), origin);
                }
            }
        }

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public int distanceSquare(Point p1, Point p2){

        return (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y);
    }

}
