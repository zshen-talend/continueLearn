// ============================================================================
//
// Copyright (C) 2006-2020 Talend Inc. - www.talend.com
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
 *
 */
package javatest.stringExpression.math;

public class MathTest {

    public static void main(String[] args) {
        String expression = "(0*1--3)-5/-4-(3*(-2.13))";
        double result = Calculator.conversion(expression);
        System.out.println(expression + " = " + result);
        System.out.println();
    }

}