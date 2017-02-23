// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package swtTest.scrollBarEvent;

/**
 * DOC zshen class global comment. Detailled comment
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;

public class ScrollBarSelectionListener {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        final ScrolledComposite sc1 = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        Button button1 = new Button(sc1, SWT.PUSH);
        button1.setText("Button 1");
        button1.setSize(400, 300);
        sc1.setContent(button1);

        final ScrolledComposite sc2 = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        Button button2 = new Button(sc2, SWT.PUSH);
        button2.setText("Button 2");
        button2.setSize(300, 400);
        sc2.setContent(button2);

        final ScrollBar vBar1 = sc1.getVerticalBar();
        final ScrollBar vBar2 = sc2.getVerticalBar();
        final ScrollBar hBar1 = sc1.getHorizontalBar();
        final ScrollBar hBar2 = sc2.getHorizontalBar();
        SelectionListener listener1 = new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int x = hBar1.getSelection() * (hBar2.getMaximum() - hBar2.getThumb())
                        / Math.max(1, hBar1.getMaximum() - hBar1.getThumb());
                int y = vBar1.getSelection() * (vBar2.getMaximum() - vBar2.getThumb())
                        / Math.max(1, vBar1.getMaximum() - vBar1.getThumb());
                sc2.setOrigin(x, y);
            }
        };
        SelectionListener listener2 = new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                int x = hBar2.getSelection() * (hBar1.getMaximum() - hBar1.getThumb())
                        / Math.max(1, hBar2.getMaximum() - hBar2.getThumb());
                int y = vBar2.getSelection() * (vBar1.getMaximum() - vBar1.getThumb())
                        / Math.max(1, vBar2.getMaximum() - vBar2.getThumb());
                sc1.setOrigin(x, y);
            }
        };
        vBar1.addSelectionListener(listener1);
        hBar1.addSelectionListener(listener1);
        vBar2.addSelectionListener(listener2);
        hBar2.addSelectionListener(listener2);

        shell.setSize(400, 300);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
