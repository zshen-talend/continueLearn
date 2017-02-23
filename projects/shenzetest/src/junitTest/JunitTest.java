// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package junitTest;


// Day-of-week calculator
// by FYICenter.com

public class JunitTest {

    private int days = 0;

    // main method for testing purpose
    public static void main(String[] arg) {
        int d = -1;
        JunitTest o = new JunitTest(d);
        System.out.print("Day of the week: " + o.getDayOfWeek());
    }

    // constrcutor
    public JunitTest(int d) {
        days = d;
    }

    // calculate day of the week
    public String getDayOfWeek() {
        try {
            assert false : days;
        } catch (Exception e) {
            System.out.println(e);
        }
            return "Saturday";
        }

}
