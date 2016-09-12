package Math;

/**
 * 给两个长方形的topLeft和bottomRight坐标, 判断这两个长方形是否重叠
 限制条件是所有的边都跟X或Y轴平行.
 */
public class OverlapRectangle {

    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    public static boolean overlap(Point topLeftA, Point bottomRightA, Point topLeftB, Point bottomRightB) {
        if (topLeftA.x >= bottomRightB.x || topLeftB.x >= bottomRightA.x) {
            return false;
        }

        if (bottomRightA.y >= topLeftB.y || bottomRightB.y >= topLeftA.y) {
            return false;
        }

        return true;
    }
}
