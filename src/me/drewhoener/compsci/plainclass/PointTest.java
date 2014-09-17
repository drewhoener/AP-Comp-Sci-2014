package me.drewhoener.compsci.plainclass;

public class PointTest {

    public static void main(String[] args) {

        PointTest pt = new PointTest();

    }

    public PointTest() {
        Point p1 = new Point();
        Point p2 = new Point(17, 6);

        p1.translatePoint(5, -2);
        p2.translatePoint(-3, -8);

        System.out.println("Point 1: (" + p1.getPointX() + ", " + p1.getPointY() + ")");
        System.out.println("Point 2: (" + p2.getPointX() + ", " + p2.getPointY() + ")");

        System.out.println();
        System.out.println("Point 1 distance from Origin: " + p1.distFromOrigin());
        System.out.println("Point 2 distance from Origin: " + p2.distFromOrigin());
    }

}
