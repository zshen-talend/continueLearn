package javatest.compile.asm;

import java.awt.Component;
import java.awt.Graphics;

public class DrawingComponent extends Component {

    @Override
    public void paint(Graphics g) {
        g.drawLine(30, 30, 30, 100);
        g.drawLine(30, 100, 70, 100);
        g.drawLine(70, 100, 30, 30);
    }
}
