package com.succez;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class test2 {

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
		Assert.assertEquals("0", new intToHex(0).reresult);
		Assert.assertEquals("-1", new intToHex(-1).reresult);
		Assert.assertEquals("F", new intToHex(15).reresult);
		Assert.assertEquals("10", new intToHex(16).reresult);
		Assert.assertEquals("7FFFFFFF", new intToHex(Integer.MAX_VALUE).reresult);
		Assert.assertEquals("80000000", new intToHex(Integer.MIN_VALUE).reresult);
		
	}
}
