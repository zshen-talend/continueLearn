package Java8_new.lambda.actionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by liangyh on 2016-11-27.
 */
public class ListenerTest {
    public static void main(String[] args) {
        JButton testButton = new JButton("button");
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click button, 匿名内部类");
            }
        });

        testButton.addActionListener(event -> System.out.println("click button, lambda"));

        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(testButton, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}