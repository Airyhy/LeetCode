package Heap;

import java.util.*;

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

        for (Point current : points) {
            if (maxHeap.size() < k) {
                maxHeap.offer(current);
            } else {
                if (distanceSquare(current, origin) < distanceSquare(maxHeap.peek(), origin)) {
                    maxHeap.poll();
                    maxHeap.offer(current);
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



    //heap better
    //O(N lg K) running time + O(K) memory
    public Point findKthNearest2(Point[] Plain, Point target, int k) {

        //create a max heap
        Queue<Point> heap = new PriorityQueue<>(Plain.length, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double d1 = (o1.x - target.x) * (o1.x - target.x) +
                        (o1.y - target.y) * (o1.y - target.y);
                double d2 = (o2.x - target.x) * (o2.x - target.x) +
                        (o2.y - target.y) * (o2.y - target.y);

                return (int) (d2 - d1);
            }
        });

        for(Point point : Plain) {
            heap.offer(point);

            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }



    //quick select
    //Average:O(n), worst:O(n^2)(如果不是random), O(n)
    static final Random random = new Random();
    public Point findKthNearest(Point[] Plain, Point target, int k) {
        Map<Point, Double> dis = new HashMap<>();
        for (Point point : Plain) {
            dis.put(point, Math.sqrt((point.x - target.x) * (point.x - target.x) +
                    (point.y - target.y) * (point.y - target.y)));
        }
        k = Plain.length - k - 1;
        int start = 0, end = Plain.length;
        while (true) {
            int pos = start + random.nextInt(end - start);
            double pivot = dis.get(Plain[pos]);
            Plain[pos] = Plain[end - 1];
            int left = start, right = start;

            for (; right < end - 1; right++) {
                if (dis.get(Plain[right]) <= pivot) {
                    Point temp = Plain[right];
                    Plain[right] = Plain[left];
                    Plain[left++] = temp;
                }
            }

            if (k == left - start + 1) {
                return Plain[pos];
            } else if (k < left - start + 1) {
                end = left;
            } else {
                k = k - (left - start + 1);
                start = left;
                end--;
            }
        }
    }
}
