package com.succez;

//树
class Testtree1 {

	// 普通树
	static TNode prepareTest1() {
		TNode root = new TNode("A");
		TNode left = new TNode("B");
		TNode right = new TNode("C");

		root.left = left;
		root.right = right;

		return root;
	}

	// 缺省树
	static TNode prepareTest2() {
		TNode root = new TNode("A");
		TNode left = new TNode("B");
		TNode right = new TNode("C");
		TNode leftleft = new TNode("D");
		TNode leftright = new TNode("E");
		TNode rightleft = new TNode("F");

		root.left = left;
		root.right = right;
		left.left = leftleft;
		left.right = leftright;
		right.left = rightleft;

		return root;
	}

	// 空树
	static TNode prepareTest3() {
		TNode root = null;
		return root;
	}

	// 数组构造的树

	static TNode prepareTest4(String[] a) {
		TNode tree;
		if (a.length == 0) {
			return null;
		} else

			tree = new TNode(a[0]);
		int n = 1;
		int i = 1;

		TreeL(tree, n, a, i);

		return tree;
	}

	static void TreeL(TNode tree, int n, String[] a, int i) {
		if (i <= a.length && Math.pow(2, n - 1) - 1 < a.length) {
			tree.value = a[i - 1];
			TNode l = new TNode();
			TNode r = new TNode();
			tree.left = l;
			tree.right = r;
			TreeL(l, ++n, a, i = i * 2);
			TreeL(r, n, a, i = i + 1);

		}

	}
}
