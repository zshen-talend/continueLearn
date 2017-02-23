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
public class BinaryIntegralLiteral {

    // Add "0b" or "0B" mark it is Binary Integral
    public void display() {
        System.out.println(0b001001); // 输出9
        System.out.println(0B001110); // 输出14
    }

    public static void main(String[] args) {
        BinaryIntegralLiteral binaryIntegralLiteral = new BinaryIntegralLiteral();
        binaryIntegralLiteral.display();
    }
}
