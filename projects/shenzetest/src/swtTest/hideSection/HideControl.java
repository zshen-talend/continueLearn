package swtTest.hideSection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

/**
 * Test.java
 * 
 * 2007-12-27 下午03:34:16
 * 
 * Copyright 2007 Sigmasoft, Inc. All rights reserved. Sigmasoft PROPRIETARY/CONFIDENTIAL. Use is subject to license
 * terms.
 */

/**
 * Class instruction
 * 
 * @author fangyao
 * 
 */

public class HideControl {

    public static void main(String[] args) {
        exclude();
    }

    // exclude
    private static void exclude() {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        final GridLayout gridLayout = new GridLayout();
        shell.setLayout(gridLayout);

        final Group reportGroup = new Group(shell, SWT.SHADOW_IN);
        final Button specifyFile = new Button(shell, SWT.PUSH | SWT.LEFT);
        // specifyFile.setVisible(false);
        specifyFile.setText("指定文件");
        GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
        // gd.exclude = true;
        specifyFile.setLayoutData(gd);

        specifyFile.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                // 必须同时设置这两个属性才能实现隐藏,显示也一样
                // 得到GridData
                GridData gd = (GridData) reportGroup.getLayoutData();
                gd.exclude = !gd.exclude;
                // 得到visible
                boolean visible = reportGroup.getVisible();
                visible = !visible;
                reportGroup.setVisible(visible);
                reportGroup.getParent().layout();

            }

        });

        reportGroup.setText("请选择");
        GridLayout layout = new GridLayout(2, false);
        reportGroup.setLayout(layout);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        // gd.exclude = true;
        reportGroup.setLayoutData(gd);
        // reportGroup.setVisible(false);
        reportGroup.getParent().layout();

        shell.setSize(300, 200);

        shell.open();
        // shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }
}
