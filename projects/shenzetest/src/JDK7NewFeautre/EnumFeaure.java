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
public class EnumFeaure {

    // Start with JDK7 switch parameter can be used by String type
    public String generate(String name, String gender) {
        String title = "";
        switch (gender) {
        case "男":
            title = name + "先生";
            break;
        case "女":
            title = name + "女士";
            break;
        default:
            title = name;
        }
        return title;
    }

    public static void main(String[] args) {
        EnumFeaure enumFeaure = new EnumFeaure();
        System.out.println(enumFeaure.generate("name1", "男"));
        System.out.println(enumFeaure.generate("name1", "女"));
    }
}
