// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package javatest.math;


public class TheDifferentBetweenPlusAndMultiply {

    public static void main(String[] args) {
        double f1 = .0;
        for (int i = 1; i <= 11; i++) {
            f1 += .1;
        }
        double f2 = .1 * 11;
        // f2=1.1 f1=1.09999999 so println -1
        System.out.println(Double.compare(f1, f2));
    }
}
