package javatest.ClassLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
 * 

 * @ClassName: ClassLocationUtils

 * @Description: tools to find which jar does the class come from 

 * 
 */
public class ClassLocationUtils {

    /**
     * find the location of the class come from
     * @param cls
     * @return
     */
    public static String where(final Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("null input: cls");
        }
        URL result = null;
        final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
        final ProtectionDomain pd = cls.getProtectionDomain();
        if (pd != null) {
            final CodeSource cs = pd.getCodeSource();
            if (cs != null) {
                result = cs.getLocation();
            }
            if (result != null) {
                if ("file".equals(result.getProtocol())) {
                    try {
                        if (result.toExternalForm().endsWith(".jar") ||
                                result.toExternalForm().endsWith(".zip")) {
                            result = new URL("jar:".concat(result.toExternalForm())
                                    .concat("!/").concat(clsAsResource));
                        } else if (new File(result.getFile()).isDirectory()) {
                            result = new URL(result, clsAsResource);
                        }
                    }
                    catch (MalformedURLException ignore) {}
                }
            }
        }
        if (result == null) {
            final ClassLoader clsLoader = cls.getClassLoader();
            result = clsLoader != null ?
                    clsLoader.getResource(clsAsResource) :
                    ClassLoader.getSystemResource(clsAsResource);
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ClassLocationUtils.where(java.lang.Thread.class);
    }

}
