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
			File file1 = new File("test1file1.txt");
			File file2 = new File("test1file2.txt");
			byte[] bytes1 = lesson1.file2buf(file1);
			byte[] bytes2 = lesson1.file2buf(file2);
			byte[] bytes0 = { 'a', 'b' };
			lesson1.bytefile(bytes0);
			File file3 = new File("test1file3.txt");
			byte[] bytes3 = lesson1.file2buf(file3);
			String k1 = new String(bytes1);
			String k2 = new String(bytes2);
			String k3 = new String(bytes3);
			// 读取文件，比较文本内容是否一致
			Assert.assertEquals("safd", k1);
			Assert.assertEquals("", k2);
			// 代码构造bytes，写入文件，读取出来，判断是否一致
			Assert.assertEquals("ab", k3);
			// 读取文件，写入文件，再次读取出来，看是否与一开始读取的一致
			lesson1.bytefile(bytes1);
			byte[] bytes4 = lesson1.file2buf(file3);
			String k4 = new String(bytes4);
			Assert.assertEquals(k1, k4);
			lesson1.bytefile(bytes2);
			byte[] bytes5 = lesson1.file2buf(file3);
			String k5 = new String(bytes5);
			Assert.assertEquals(k2, k5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}