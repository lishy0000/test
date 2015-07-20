package com.succez;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("deprecation")
class testtree {
	static TNode prepareTest1() {
		TNode root = new TNode("A");
		TNode left = new TNode("B");
		TNode right = new TNode("C");

		root.left = left;
		root.right = right;

		return root;
	}
}

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
		TNode tree2 = lesson3.prepareTest1();
		TNode tree3 = testtree.prepareTest1();
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree2, 0));
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree2, -1));
		Assert.assertEquals("DEF", lesson3.TreeLevel(tree2, 3));
		Assert.assertEquals("BC", lesson3.TreeLevel(tree2, 2));
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree3, 0));
		Assert.assertEquals("n不能为0和负数", lesson3.TreeLevel(tree3, -1));
		Assert.assertEquals("", lesson3.TreeLevel(tree3, 3));
		Assert.assertEquals("BC", lesson3.TreeLevel(tree3, 2));

	}
}
