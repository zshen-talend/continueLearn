package db.jdbc.zjy.test;


import junit.framework.*;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.zjy.test");
		suite.addTestSuite(StuinfoServiceTest.class);
		return suite;
	}
}