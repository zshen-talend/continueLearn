package javatest.file;

import java.nio.file.Paths;

public class PathsTest {

	public static void main(String[] args) {
		System.out.println( Paths.get("baidu.txt").toAbsolutePath());
	}

}
