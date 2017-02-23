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
package JDK7NewFeautre;

/**
 * DOC talend class global comment. Detailled comment
 */
public class Underscore {

    // Underscore can be instead into number constants to split them
    public void display() {
        System.out.println(1_500_000); // 输出1500000
        double value1 = 5_6.3_4;
        int value2 = 89_3___1;
        System.out.println(value1); // 输出56.34
        System.out.println(value2); // 输出8931
    }

    public static void main(String[] args) {
        Underscore underscore = new Underscore();
        underscore.display();
    }
}
