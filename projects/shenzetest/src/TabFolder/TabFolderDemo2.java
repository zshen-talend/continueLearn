package TabFolder;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class TabFolderDemo2 extends Composite {

    public TabFolderDemo2(Composite parent, int style) {
        super(parent, style);
        setLayout(new FillLayout(SWT.HORIZONTAL));

        CTabFolder tabFolder = new CTabFolder(this, SWT.BORDER);
        tabFolder.setSimple(false);
        // tabFolder.setSelectionBackground(ElementFactory.getImage());

        CTabItem tbtmTabitem_1 = new CTabItem(tabFolder, SWT.NONE);
        tbtmTabitem_1.setText("tabItem1");

        Composite composite = new Composite(tabFolder, SWT.NONE);
        tbtmTabitem_1.setControl(composite);
        composite.setLayout(new GridLayout(1, false));
        Label lblChild = new Label(composite, SWT.NONE);
        lblChild.setText("child");

        CTabItem tbtmTabitem = new CTabItem(tabFolder, SWT.NONE);
        tbtmTabitem.setText("tabItem2");

        Composite composite_1 = new Composite(tabFolder, SWT.NONE);
        tbtmTabitem.setControl(composite_1);

    }

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        FillLayout fillLayout = new FillLayout();
        shell.setLayout(fillLayout);
        shell.setText("Show CTabFolder");
        TabFolderDemo2 tabFolderDemo2 = new TabFolderDemo2(shell, SWT.CLOSE);
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}