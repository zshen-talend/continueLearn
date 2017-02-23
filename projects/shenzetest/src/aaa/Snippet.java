// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package aaa;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.ole.win32.OLE;
import org.eclipse.swt.ole.win32.OleClientSite;
import org.eclipse.swt.ole.win32.OleFrame;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * DOC talend class global comment. Detailled comment
 */
public class Snippet {

    public static void main(String[] args) {
        Shell shell = new Shell();
        shell.setSize(1000, 800);
        Composite c = new Composite(shell, SWT.NULL);
        c.setLayout(new FillLayout(org.eclipse.swt.SWT.VERTICAL));
        c.setSize(800, 700);
        OleFrame oleFrame = new OleFrame(c, SWT.NONE);
        File file = new File("D:\\sm-20160121-1514-00059.pdf");
        OleClientSite clientSite = new OleClientSite(oleFrame, SWT.BORDER, file);
        clientSite.doVerb(OLE.OLEIVERB_SHOW);
        System.out.println(clientSite.getProgramID());
    }
}
