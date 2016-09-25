package VmwareTemp;


public class mergeString {

    /**
     * 把俩string merge成一个 ， 规则是一边来一个 剩余的全部append上去  即  abc ,  cdefg->    acbdcefg
     */
    String mergeStrings(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();

        int idx1 = 0;
        int idx2 = 0;

        StringBuffer sb = new StringBuffer();

        while (idx1<len1 || idx2<len2) {
            if (idx1 < len1) {
                sb.append(a.charAt(idx1));
                idx1++;
            }
            if (idx2 < len2) {
                sb.append(b.charAt(idx2));
                idx2++;
            }
        }

        return sb.toString();
    }

    /**
     * balance array:   找一个数组中某个数， 使得左边和等于右边和   找不到return -1 。  之前那个帖子说用DP 感觉没必要我也没想到呢·· 直接做O（n）的能过
     */

    int isArray_Balanced(int[] arr) {
        if (arr==null || arr.length == 0)
            return -1;
        if (arr.length == 1)
            return 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i ++) {
            sum += arr[i];
            arr[i] = sum;
        }

        int rightSum = 0;
        for (int i = arr.length - 1; i >= 1; i --) {
            int cur = arr[i] - arr[i - 1];
            if (arr[i - 1] == rightSum)
                return i;
            rightSum += cur;
        }
        return -1;
    }

    /**
     * remove listnode greater than x : Linkedlist中 remove掉val 大于x的node
      */

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode removeNodes(ListNode list, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list;
        ListNode cur = dummy;

        while (cur.next!=null) {
            if (cur.next.val > x) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    /**
     * 4. point2D, point3D:    需要implement 俩class和各自的function
     * 还是很简单的并没有遇到之前帖子里面说的那些问题··· 可能是他们改了。
     * 感觉就为了考你point3D extends point2D 的constructor 怎么写， 应该是用super吧。 然后override一个print的function···
     */

    public class Point {
        protected double x;
        protected double y;

        Point(double xCoord, double yCoord){
            this.x = xCoord;
            this.y = yCoord;
        }

        public double distance(Point a, Point b) {
            double dx = a.x - b.x;
            double dy = a.y - b.y;
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    public class Point3D extends Point {
        protected double z;

        Point3D(double x, double y, double zCoord){
            super(x, y);
            this.z = zCoord;
        }

        public double distance(Point3D p1, Point3D p2){
            double dx = p1.x - p2.x;
            double dy = p1.y - p2.y;
            double dz = p1.z - p2.z;
            return Math.sqrt(dx * dx + dy * dy + dz *dz);
        }
    }
}
