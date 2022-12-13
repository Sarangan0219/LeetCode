package PriorotyQueue;

/*

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the
k closest points to the origin (0, 0). The distance between two points on the X-Y plane is the Euclidean distance
(i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

*/

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new PointComparator());

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }


        return pq.toArray(new int[k][2]);
    }



    class PointComparator implements Comparator<int[]> {


        @Override
        public int compare(int[] a, int[] b) {
            int  aSqrt = (a[0]*a[0]) + (a[1]*a[1]);
            int  bSqrt = (b[0]*b[0]) + (b[1]*b[1]);
            if (aSqrt < bSqrt) {
               return 1;
            } else if (aSqrt > bSqrt) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
