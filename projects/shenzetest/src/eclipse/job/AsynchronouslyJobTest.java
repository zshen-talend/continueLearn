// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package eclipse.job;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.progress.UIJob;

public class AsynchronouslyJobTest {

    private Thread thread;

    private Text t2;

    final Display display = new Display();

    final Shell shell = new Shell(display);

    ISchedulingRule Schedule_RULE = new ISchedulingRule() {

        @Override
        public boolean contains(ISchedulingRule rule) {
            return this.equals(rule);
        }

        @Override
        public boolean isConflicting(ISchedulingRule rule) {
            return this.equals(rule);
        }
    };

    public void execute(final long sleep, final String content) {
        Job job = new Job("main job") { //$NON-NLS-1$

            @Override
            protected IStatus run(final IProgressMonitor monitor) {
                monitor.beginTask("Start the jobs", 2); //$NON-NLS-1$
                // Display.getDefault().asyncExec(new Runnable() {
                //
                // @Override
                // public void run() {
                System.out.println(content + "1");
                // t2.setText(t2.getText() + t2.getLineDelimiter() + content + "1");
                monitor.worked(1);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(content + "2");
                // t2.setText(t2.getText() + t2.getLineDelimiter() + content + "2");
                monitor.worked(2);
                // }
                // });

                return Status.OK_STATUS;
            }
        };
        job.setUser(false);
        job.setRule(Schedule_RULE);
        job.schedule();
    }

    public void executeUI(final long sleep, final String content, boolean isSyn) {
        UIJob job = new UIJob("main job") {

            @Override
            public IStatus runInUIThread(IProgressMonitor monitor) {
                monitor.beginTask("Start the jobs", 2); //$NON-NLS-1$
                // System.out.println(content + "1");
                t2.setText(t2.getText() + t2.getLineDelimiter() + content + "1");
                monitor.worked(1);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // System.out.println(content + "2");
                t2.setText(t2.getText() + t2.getLineDelimiter() + content + "2");
                monitor.worked(2);

                return Status.OK_STATUS;
            }

            @Override
            public Display getDisplay() {
                return display;
            }

        };
        job.setUser(false);
        if (isSyn) {
            job.setRule(Schedule_RULE);
        }
        job.schedule();
    }

    public void build() {

        shell.setLayout(new GridLayout(2, false));

        Label label1 = new Label(shell, SWT.NONE);
        label1.setText("first button:");

        Button button1 = new Button(shell, SWT.PUSH);
        button1.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                AsynchronouslyJobTest.this.execute(5000, "backgroup work");
            }
        });
        button1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        Label label2 = new Label(shell, SWT.NONE);
        label2.setText("second button:");

        Button button2 = new Button(shell, SWT.PUSH);
        button2.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                AsynchronouslyJobTest.this.executeUI(100, "UI work syn with backgroup work", true);
            }
        });
        button2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Label label3 = new Label(shell, SWT.NONE);
        label3.setText("third button:");

        Button button3 = new Button(shell, SWT.PUSH);
        button3.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                AsynchronouslyJobTest.this.executeUI(100, "Another UI work", false);
            }
        });
        button3.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        t2 = new Text(shell, SWT.BORDER | SWT.MULTI);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.horizontalSpan = 2;
        t2.setLayoutData(gd);
        t2.setText("example...");

        shell.setSize(500, 500);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    public static void main(String args[]) {
        AsynchronouslyJobTest asynchronouslyJobTest = new AsynchronouslyJobTest();
        asynchronouslyJobTest.build();
    }

}
