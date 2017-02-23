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


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * DOC zshen  class global comment. Detailled comment
 */
public class DisplayScorllBar {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        FillLayout fillLayout = new FillLayout();
        shell.setLayout(fillLayout);

        Composite composite0 = new Composite(shell, SWT.BORDER);


        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}