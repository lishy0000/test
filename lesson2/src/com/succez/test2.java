package com.succez;

import org.junit.*;



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
		Assert.assertEquals("0", new IntToHex().intToHex(0));
		Assert.assertEquals("-1", new IntToHex().intToHex(-1));
		Assert.assertEquals("F", new IntToHex().intToHex(15));
		Assert.assertEquals("10", new IntToHex().intToHex(16));
		Assert.assertEquals("7FFFFFFF", new IntToHex().intToHex(Integer.MAX_VALUE));
		Assert.assertEquals("80000000", new IntToHex().intToHex(Integer.MIN_VALUE));
		
	}
}
