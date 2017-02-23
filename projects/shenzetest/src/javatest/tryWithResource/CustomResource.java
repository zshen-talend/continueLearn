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
package javatest.tryWithResource;

/**
 * DOC zshen class global comment. Detailled comment
 */
public class CustomResource implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("进行资源释放。");
        throw new Exception();
    }

    public void useCustomResource() throws Exception {
        // try (CustomResource resource = new CustomResource()) {
        System.out.println("使用资源。");
        // }
    }

    public static void main(String[] args) {
        try (CustomResource resource = new CustomResource()) {
            resource.useCustomResource();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
