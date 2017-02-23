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

/**
 * DOC talend class global comment. Detailled comment
 */
package swtTest.wizard;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import swtTest.List.ListDemo;

public class HotelReservation extends ApplicationWindow {

    @Override
    protected Control createContents(Composite parent) {
        Button button = new Button(parent, SWT.PUSH);
        button.setText("Make a reservation");
        button.addListener(SWT.Selection, new Listener() {

            @Override
            public void handleEvent(Event event) {
                ReservationWizard wizard = new ReservationWizard();

                WizardDialog dialog = new WizardDialog(getShell(), wizard);
                dialog.setBlockOnOpen(true);
                int returnCode = dialog.open();
                if (returnCode == Dialog.OK) {
                    System.out.println(wizard.data);
                } else {
                    System.out.println("Cancelled");
                }
            }
        });
        return button;
    }

    public HotelReservation(Shell parentShell) {
        super(parentShell);
    }

    public static void main(String[] args) {
        try {
            Display display = Display.getDefault();
            ListDemo shell = new ListDemo(display, SWT.SHELL_TRIM);
            shell.open();
            shell.layout();
            HotelReservation reservation = new HotelReservation(shell);
            reservation.setBlockOnOpen(true);
            reservation.open();
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
