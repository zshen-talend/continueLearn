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
package swtTest;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class VirtualTable {

    private static int count = 0;

    private static boolean removeFlag = true;

    private static boolean initalFlag = false;

    private static int currentLocation = 0;

    private static SelectionListener selectListener = null;

    private static boolean down = false;

    private static boolean up = false;

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        FillLayout fillLayout = new FillLayout();
        shell.setLayout(fillLayout);

        createVirtualTable(shell);

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    /**
     * DOC zshen Comment method "createVirtualTable".
     */
    private static void createVirtualTable(final Composite parent) {
        final int COUNT = 100;
        final String[] itemStrings = new String[COUNT];
        for (int i = 0; i < COUNT; i++) {
            itemStrings[i] = "item " + i;
        }
        final Table table = new Table(parent, SWT.BORDER | SWT.VIRTUAL);
        //
        selectListener = new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                Table table = (Table) ((ScrollBar) e.widget).getParent();
                // if (table.getTopIndex() == 0) {
                // removeFlag = false;
                // } else {
                removeFlag = true;
                // }
                initalFlag = true;

            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }

        };

        // Listener scrollBarListener = new Listener() {
        //
        // public void handleEvent(Event event) {
        // removeFlag = false;
        // removeFlag = true;
        // }
        //
        // };

        table.getVerticalBar().addSelectionListener(selectListener);
        // table.getVerticalBar().setMaximum(10);
        table.addListener(SWT.SetData, new Listener() {

            @Override
            public void handleEvent(Event event) {

                TableItem item = (TableItem) event.item;
                int index = event.index;
                // if (index == 0) {
                // table.clearAll();
                // }
                item.setText(itemStrings[index]);
                Table table = (Table) event.widget;
                table.setDragDetect(false);
                if (!removeFlag) {
                    table.getVerticalBar().setSelection(currentLocation);

                }

                if (removeFlag && initalFlag) {
                    table.getVerticalBar().removeSelectionListener(selectListener);
                    removeFlag = false;

                    // table.removeListener(SWT.SetData, this);
                    // table.remove(5);
                    currentLocation = table.getTopIndex();
                    int len = table.getVerticalBar().getThumb();
                    if (index > currentLocation) {

                        down = true;
                    } else if (index == currentLocation) {
                        if (down) {// middle state
                            down = false;
                            up = false;
                        } else {
                            up = true;
                        }
                    }
                    long middleValue = Math.round(table.getItemCount() / 2.0);
                    if ((index == (middleValue + table.getVerticalBar().getThumb() + 2) || index == table.getItemCount() - 1)
                            && down || index == (middleValue - table.getVerticalBar().getThumb() - 2) && up) {
                        table.removeAll();
                    }
                    table.setItemCount(COUNT);
                    // currentLocation = index - currentLocation > 0 ? (currentLocation + len + 1) : (currentLocation -
                    // len - 1);
                    // if (currentLocation > table.getItemCount()) {
                    // currentLocation = table.getItemCount();
                    // } else if (currentLocation < 0) {
                    // currentLocation = 0;
                    // }
                    // table.getVerticalBar().removeSelectionListener(selectListener);
                    table.setTopIndex(currentLocation);

                    // table.getVerticalBar().addSelectionListener(selectListener);
                    // table.getVerticalBar().setSelection(currentLocation);
                    // rebuildTable(currentLocation);
                    // table.addListener(SWT.SetData, this);
                    removeFlag = false;
                    table.getVerticalBar().addSelectionListener(selectListener);
                }

            }
        });
        table.setItemCount(COUNT);
        // table.setSelection(10);
        Button button = new Button(parent, SWT.PUSH);
        button.setText("Change item at index 5");
        button.addListener(SWT.Selection, new Listener() {

            @Override
            public void handleEvent(Event event) {
                itemStrings[5] = "item " + System.currentTimeMillis();
                table.clear(5);
            }
        });

    }

    public void rebuildTable(int index) {

    }

    /**
     * DOC zshen Comment method "createVirtualTable".
     */
    private static void createVirtualTable1(Composite parent) {
        final int COUNT = 100000;
        final int PAGE_SIZE = 64;
        final Table table = new Table(parent, SWT.VIRTUAL | SWT.BORDER);
        table.addListener(SWT.SetData, new Listener() {

            @Override
            public void handleEvent(Event event) {
                TableItem item = (TableItem) event.item;
                int index = event.index;
                int page = index / PAGE_SIZE;
                int start = page * PAGE_SIZE;
                int end = start + PAGE_SIZE;
                end = Math.min(end, table.getItemCount());
                for (int i = start; i < end; i++) {
                    item = table.getItem(i);
                    item.setText("Item " + i);
                }
            }
        });
        table.setItemCount(COUNT);

        // Button button = new Button(parent, SWT.PUSH);
        // button.setText("Change next 64 items");
        // button.addListener(SWT.Selection, new Listener() {
        //
        // public void handleEvent(Event event) {
        // itemStrings[5] = "item " + System.currentTimeMillis();
        // table.clear(5);
        // }
        // });

    }

    /**
     * DOC zshen Comment method "createVirtualTable".
     */
    private static void createVirtualTree(Composite parent) {
        final Tree tree = new Tree(parent, SWT.VIRTUAL | SWT.BORDER);
        File[] roots = File.listRoots();
        File[] CRoot = new File[1];
        CRoot[0] = roots[3];
        tree.setData(CRoot);
        tree.addListener(SWT.SetData, new Listener() {

            @Override
            public void handleEvent(Event event) {
                TreeItem item = (TreeItem) event.item;
                TreeItem parentItem = item.getParentItem();
                File file = null;
                if (parentItem == null) {
                    /* root-level item */
                    File[] files = (File[]) tree.getData();
                    file = files[event.index];
                    item.setText(file.toString());
                } else {
                    File[] files = (File[]) parentItem.getData();
                    file = files[event.index];
                    item.setText(file.getName());
                }
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    if (files != null) {
                        item.setData(files);
                        item.setItemCount(files.length);
                        // item.setExpanded(true);
                    }
                }
                // if (parentItem != null && parentItem.getText().contains("C")
                // && ((Tree) event.widget).getItem(4).getText().contains("G")) {
                // ((Tree) event.widget).removeAll();
                // }
                // if (((Tree) event.widget).getSelection()[0].getText().equalsIgnoreCase("c:\\")) {
                // ((Tree) event.widget).removeAll();
                // }
            }
        });
        tree.setItemCount(CRoot.length);
        tree.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                TreeItem item = (TreeItem) e.item;
                Tree tree = (Tree) e.getSource();
                if (!item.getText().equalsIgnoreCase("f:\\")) {

                    TreeItem topitem = tree.getTopItem();
                    int count = topitem.getParentItem().getItemCount();

                    TreeItem parentItem = topitem.getParentItem();
                    parentItem.removeAll();
                    parentItem.setItemCount(count);

                    TreeItem perviousItem = parentItem.getParentItem()
                            .getItem(parentItem.getParentItem().indexOf(parentItem) - 1);
                    int newCount = perviousItem.getItemCount();
                    perviousItem.setExpanded(false);
                    perviousItem.removeAll();
                    perviousItem.setItemCount(newCount);
                    // int /* long */hItem1 = OS.SendMessage(tree.handle, OS.TVM_GETNEXTITEM, OS.TVGN_FIRSTVISIBLE, 0);
                    // int /* long */hItem2 = OS.SendMessage(tree.handle, OS.TVM_GETNEXTITEM, OS.TVGN_NEXTVISIBLE, 0);
                    // TVITEM tvItem1 = new TVITEM();
                    // tvItem1.mask = OS.TVIF_HANDLE | OS.TVIF_PARAM;
                    // tvItem1.hItem = hItem1;
                    // TVITEM tvItem2 = new TVITEM();
                    // tvItem2.mask = OS.TVIF_HANDLE | OS.TVIF_PARAM;
                    // tvItem2.hItem = hItem2;
                    // OS.SendMessage(tree.handle, OS.TVM_GETITEM, 0, tvItem1);
                    // OS.SendMessage(tree.handle, OS.TVM_ENSUREVISIBLE, 0, hItem2);
                    // OS.SendMessage(tree.handle, OS.TVM_GETITEM, 0, tvItem2);
                    // TreeItem item1 = tree.getItems()[0].getItems()[tvItem1.lParam];
                    // TreeItem item2 = tree.getItems()[0].getItems()[tvItem2.lParam];

                }

            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // TODO Auto-generated method stub

            }

        });

    }

    private class MyTable extends Table {

        /**
         * DOC zshen MyTable constructor comment.
         * 
         * @param parent
         * @param style
         */
        public MyTable(Composite parent, int style) {
            super(parent, style);
        }

        public void setItem(int index) {
            checkWidget();
            int count = (int) /* 64 */OS.SendMessage(handle, OS.LVM_GETITEMCOUNT, 0, 0);
            if (!(0 <= index && index < count)) {
                return;
            }

        }

    }

}
