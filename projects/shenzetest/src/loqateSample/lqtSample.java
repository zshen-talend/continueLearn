// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package loqateSample;

import com.loqate.lqtInputRecord;
import com.loqate.lqtProcessList;
import com.loqate.lqtProcessOptions;
import com.loqate.lqtProcessResult;
import com.loqate.lqtServer;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class lqtSample {

    static {
        System.loadLibrary("lqtjava");
    }

    public static void main(String args[]) {
        // Loqate objects
        lqtServer srv = lqtServer.create();
        lqtInputRecord rec = lqtInputRecord.create();
        lqtProcessResult res = lqtProcessResult.create();

        // Initialize the server
        if (args.length > 0) {
            srv.init(args[0]);
        } else {
            srv.init("D:\\Program Files\\Loqate\\data");
        }

        // Create the process list
        lqtProcessList lst = lqtProcessList.create();
        lqtProcessOptions opts = lqtProcessOptions.create();
        lst.add("Verify", opts);
        // lst.add("Geocode", opts);

        try {
            // Open the Loqate session
            int session = srv.open();

            // Process data
            try {
                // Set the relevant Loqate values
                rec.set("Address", "411 E Pine St");
                rec.set("Country", "us");

                // Process the record
                srv.process(rec, lst, res);

                // Output the result
                System.out.println(res.getAccuracyCode());
                for (int i = 0; i < res.getCount(); i++) {
                    System.out.println("Organization:" + res.getField(i, "Organization"));
                    System.out.println("SubBuilding:" + res.getField(i, "SubBuilding"));
                    System.out.println("SubBuilding:" + res.getField(i, "Premise"));
                    System.out.println("Building:" + res.getField(i, "Building"));
                    System.out.println("PostBox:" + res.getField(i, "PostBox"));
                    System.out.println("DependentThoroughfare:" + res.getField(i, "DependentThoroughfare"));
                    System.out.println("Thoroughfare:" + res.getField(i, "Thoroughfare"));
                    System.out.println("DoubleDependentLocality:" + res.getField(i, "DoubleDependentLocality"));
                    System.out.println("DependentLocality:" + res.getField(i, "DependentLocality"));
                    System.out.println("Locality:" + res.getField(i, "Locality"));
                    System.out.println("SubAdministrativeArea:" + res.getField(i, "SubAdministrativeArea"));
                    System.out.println("AdministrativeArea:" + res.getField(i, "AdministrativeArea"));
                    System.out.println("SuperAdministrativeArea:" + res.getField(i, "SuperAdministrativeArea"));
                    System.out.println("PostalCode:" + res.getField(i, "PostalCode"));
                    System.out.println("Telephone:" + res.getField(i, "Telephone"));
                    System.out.println("CountryName:" + res.getField(i, "CountryName"));
                    System.out.println("ISO3166-2:" + res.getField(i, "ISO3166-2"));
                    System.out.println("Latitude:" + res.getField(i, "Latitude"));
                    System.out.println("Longitude:" + res.getField(i, "Longitude"));
                    System.out.println("GeoAccuracy:" + res.getField(i, "GeoAccuracy"));
                    System.out.println("Address:" + res.getField(i, "Address"));
                    System.out.println("getAccuracyCode:" + res.getAccuracyCode());
                    System.out.println("getStatus:" + res.getStatus());
                }
                System.out.flush();
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }

            // Close the session
            srv.close(session);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

        // Destroy the process list
        lqtProcessList.destroy(lst);
        lqtProcessOptions.destroy(opts);

        // Tidy up
        srv.shutdown();
        lqtInputRecord.destroy(rec);
        lqtProcessResult.destroy(res);
        lqtServer.destroy(srv);
    }
}
