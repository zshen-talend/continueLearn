// ============================================================================
//
// Copyright (C) 2006-2014 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package swtTest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class CanvasTest {

    public static void main(String[] args) {
        final Display display = Display.getDefault();
        final Shell shell = new Shell();
        shell.setLayout(new RowLayout());
        final Canvas canvas = new Canvas(shell, SWT.BORDER);
        // 监听canvas的重绘事件
        canvas.addPaintListener(new PaintListener() {

            @Override
            public void paintControl(final PaintEvent event) {
                Image image = (Image) canvas.getData();
                if (image != null) {
                    event.gc.drawImage(image, 10, 10);// 定位图像左上角距canvas左上角的距离
                }
            }
        });
        final Image refreshImage = new Image(display, "D:\\图标\\1.jpg");
        final Image nextIamge = new Image(display, "D:\\图标\\2.png");

        Button button1 = new Button(shell, SWT.NONE);
        button1.setText("大力水手");
        button1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                canvas.setData(nextIamge);
                canvas.redraw();
            }
        });
        Button button2 = new Button(shell, SWT.NONE);
        button2.setText("海绵宝宝");
        button2.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                canvas.setData(refreshImage);
                canvas.redraw();
            }
        });
        Button clearButton = new Button(shell, SWT.NONE);
        clearButton.setText("清除图像");
        clearButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                canvas.setData(null);
                canvas.redraw();
            }
        });
        shell.layout();
        shell.open();
        shell.setSize(300, 200);
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

}
