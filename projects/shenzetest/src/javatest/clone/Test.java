package javatest.clone;

public class Test {

    static void myMethod(Point pt1) {
        pt1.x = 23;
        System.out.println("x=" + pt1.x);
    }

    public static void main(String[] args) {
        System.out.println("start to new:");
        Point pt = new Point(2, 4);
        System.out.println("x=" + pt.x);
        System.out.println("start to clone:");
        Point pt2 = (Point) pt.clone();
        myMethod(pt2);
        System.out.println("x=" + pt.x);
    }
}
