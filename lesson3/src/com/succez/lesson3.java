package com.succez;

class TNode {
	String value;
	TNode left, right;

	public TNode(String s) {
		this.value = s;
	}
}


public class lesson3 {

	static TNode prepareTest1() {
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

	// prepareTest2

	// -1,0,1,2,3
	static String TreeLevel(TNode tree, int n) {
		if (tree == null) {
			
			return "空树";
		} else if (n <= 0) {
			return "n不能为0和负数";
		} else {
			StringBuilder sb = new StringBuilder();

			TreeL(tree, n, sb);

			return sb.toString();
		}
	}

	static void TreeL(TNode tree, int n, StringBuilder sb) {
		if (tree != null) {

			TreeL(tree.left, --n, sb);
			if (n == 0)
				sb.append(tree.value);

			TreeL(tree.right, n, sb);

		}
	}

	public static void main(String[] args) {

		TNode tree1 = prepareTest1();
		String value1 = TreeLevel(tree1, 0);
		System.out.println(value1);

	}

}
