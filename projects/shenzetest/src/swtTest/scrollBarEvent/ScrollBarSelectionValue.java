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
 * DOC zshen  class global comment. Detailled comment
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;

public class ScrollBarSelectionValue {
  public static void main(String[] args) {
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());


    // Create a List with a vertical ScrollBar
    List list = new List(shell, SWT.V_SCROLL);

    // Add a bunch of items to it
    for (int i = 0; i < 500; i++) {
      list.add("A list item");
    }

    // Get the ScrollBar
    ScrollBar sb = list.getVerticalBar();
    // Show the selection value
    System.out.println("Selection: " + sb.getSelection());

    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}