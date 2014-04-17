package controller;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class SettingManagetTester {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(SettingManager.getManager().getDBSetting().getBeforeSleepTime());
	}
}
