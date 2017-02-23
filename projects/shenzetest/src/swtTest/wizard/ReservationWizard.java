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
package swtTest.wizard;

/**
 * DOC talend class global comment. Detailled comment
 */
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;

class ReservationData {

    Date arrivalDate;

    Date departureDate;

    int roomType;

    String customerName;

    String customerPhone;

    String customerEmail;

    String customerAddress;

    int creditCardType;

    String creditCardNumber;

    String creditCardExpiration;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("* HOTEL ROOM RESERVATION DETAILS *\n");
        sb.append("Arrival date:\t" + arrivalDate.toString() + "\n");
        sb.append("Departure date:\t" + departureDate.toString() + "\n");
        sb.append("Room type:\t" + roomType + "\n");
        sb.append("Customer name:\t" + customerName + "\n");
        sb.append("Customer email:\t" + customerEmail + "\n");
        sb.append("Credit card no.:\t" + creditCardNumber + "\n");

        return sb.toString();
    }
}

public class ReservationWizard extends Wizard {

    static final String DIALOG_SETTING_FILE = "C:/userInfo.xml";

    static final String KEY_CUSTOMER_NAME = "customer-name";

    static final String KEY_CUSTOMER_EMAIL = "customer-email";

    static final String KEY_CUSTOMER_PHONE = "customer-phone";

    static final String KEY_CUSTOMER_ADDRESS = "customer-address";

    ReservationData data = new ReservationData();

    public ReservationWizard() {
        setWindowTitle("Hotel room reservation wizard");
        setNeedsProgressMonitor(true);
        setDefaultPageImageDescriptor(ImageDescriptor.createFromFile(null, "C:/icons/hotel.gif"));
        DialogSettings dialogSettings = new DialogSettings("userInfo");
        try {
            dialogSettings.load(DIALOG_SETTING_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setDialogSettings(dialogSettings);
    }

    @Override
    public void addPages() {
        addPage(new FrontPage());
        addPage(new CustomerInfoPage());
        addPage(new PaymentInfoPage());
    }

    @Override
    public boolean performFinish() {
        if (getDialogSettings() != null) {
            getDialogSettings().put(KEY_CUSTOMER_NAME, data.customerName);
            getDialogSettings().put(KEY_CUSTOMER_PHONE, data.customerPhone);
            getDialogSettings().put(KEY_CUSTOMER_EMAIL, data.customerEmail);
            getDialogSettings().put(KEY_CUSTOMER_ADDRESS, data.customerAddress);
            try {
                getDialogSettings().save(DIALOG_SETTING_FILE);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        try {
            getContainer().run(true, true, new IRunnableWithProgress() {

                @Override
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    monitor.beginTask("Store data", 100);
                    monitor.worked(40);

                    System.out.println(data);
                    Thread.sleep(2000);
                    monitor.done();
                }
            });
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean performCancel() {
        boolean ans = MessageDialog.openConfirm(getShell(), "Confirmation", "Are you sure to cancel the task?");
        if (ans) {
            return true;
        } else {
            return false;
        }
    }
}