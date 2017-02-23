package LanguageTest;

import java.util.Enumeration;
import java.util.Properties;

public class Test {

    public static void main(String[] args) {

        Properties props = System.getProperties();

        Enumeration names = props.propertyNames();

        while (names.hasMoreElements()) {

            String key = (String) names.nextElement();

            String value = props.getProperty(key);

            System.out.println(key + ":" + value);

        }

    }

}
