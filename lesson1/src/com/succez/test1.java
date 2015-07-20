package com.succez;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author John
 *
 */

@SuppressWarnings("deprecation")
public class test1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			File file1 = new File("F:\\a.txt");
			File file2 = new File("F:\\b.txt");
			byte[] bytes1 = lesson1.file2buf(file1);
			byte[] bytes2 = lesson1.file2buf(file2);
			String k1 = new String(bytes1);
			String k2 = new String(bytes2);
			Assert.assertEquals("safd", k1);
			Assert.assertEquals("", k2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}