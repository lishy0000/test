package com.succez;

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
public class test3 {

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
		TNode tree1 = Testtree1.prepareTest1();// 常规树
		TNode tree2 = Testtree1.prepareTest2();// 缺省数
		TNode tree3 = Testtree1.prepareTest3();// 空树
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree1, 0));
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree1, -1));
		Assert.assertEquals("", lesson3.TreeLevel(tree1, 3));
		Assert.assertEquals("BC", lesson3.TreeLevel(tree1, 2));
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree2, 0));
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree2, -1));
		Assert.assertEquals("DEF", lesson3.TreeLevel(tree2, 3));
		Assert.assertEquals("BC", lesson3.TreeLevel(tree2, 2));
		Assert.assertEquals("空树", lesson3.TreeLevel(tree3, 1));

	}
}
