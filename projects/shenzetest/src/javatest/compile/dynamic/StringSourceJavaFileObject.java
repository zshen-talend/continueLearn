package javatest.compile.dynamic;

import java.io.IOException;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class StringSourceJavaFileObject extends SimpleJavaFileObject {

    private String content;

    public StringSourceJavaFileObject(String name, String content) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.content = content;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return content;
    }
}
