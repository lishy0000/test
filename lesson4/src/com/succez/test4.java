package com.succez;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class test4 {
	String ur1 = "http://www.baidu.com/img/baidu_sylogo1.gif";  
	String ur2 = "http://www.baidu/img/baidu_sylogo1.gif"; 
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
		File file1=new File("F:\\" + "百度.gif");
		File file2=new File("F:\\" + "bu.gif");
		lesson4.lesson( ur1,"百度.gif" );
		lesson4.lesson( ur2,"bu.gif");
		Assert.assertTrue(file1.exists());
	    Assert.assertTrue(!file2.exists());
	}
}
