package javatest.clone;

public class Point implements Cloneable {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("=================>point()");
    }

    @Override
    public Object clone() {
        Point p = null;
        try {
            p = (Point) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}