package com.succez;
//测试类
class Testtree1 {
//常规数测试用例
	static TNode prepareTest1() {
		TNode root = new TNode("A");
		TNode left = new TNode("B");
		TNode right = new TNode("C");

		root.left = left;
		root.right = right;

		return root;
	}
//	//缺省数测试用例
	static TNode prepareTest2() {
		TNode root = new TNode("A");
		TNode left = new TNode("B");
		TNode right = new TNode("C");
		TNode leftleft = new TNode("D");
		TNode leftright = new TNode("E");
		TNode rightleft = new TNode("F");
		
		
		root.left = left;
		root.right = right;
		left.left=leftleft;
		left.right=leftright;
		right.left=rightleft;
		
		return root;
	}
//空树测试用例
	static TNode prepareTest3() {
		TNode root = null;
		return root;
	}

}

