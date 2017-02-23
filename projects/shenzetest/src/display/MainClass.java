// ============================================================================
//
// Copyright (C) 2006-2013 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package display;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;

public class MainClass {

    public static void main(String[] a) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout());

        ProgressBar pb1 = new ProgressBar(shell, SWT.HORIZONTAL | SWT.SMOOTH);
        pb1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        pb1.setMinimum(0);
        pb1.setMaximum(30);

        new LongRunningOperation(display, pb1).start();

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}

class LongRunningOperation extends Thread {

    private Display display;

    private ProgressBar progressBar;

    public LongRunningOperation(Display display, ProgressBar progressBar) {
        this.display = display;
        this.progressBar = progressBar;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            display.syncExec(new Runnable() {

                public void run() {
                    if (progressBar.isDisposed()) {
                        return;
                    }
                    progressBar.setSelection(progressBar.getSelection() + 1);
                }
            });
        }
    }
}
