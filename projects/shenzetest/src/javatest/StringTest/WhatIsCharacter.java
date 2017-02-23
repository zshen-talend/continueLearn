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
package javatest.StringTest;

/**
 * DOC talend class global comment. Detailled comment
 */
public class WhatIsCharacter {

    public static void main(String[] args) {
        Object originalCanonicalValue = Character.toTitleCase('a');
        if (originalCanonicalValue instanceof Character) {
            System.out.println("originalCanonicalValue instanceof Character is true");
        }
    }
}
