package com.succez;

//��
class Testtree1 {

	static boolean exp = true;
	static int count = 0;

	// ��ͨ��
	static TNode prepareTest1() {
		TNode root = new TNode('A');
		TNode left = new TNode('B');
		TNode right = new TNode('C');

		root.left = left;
		root.right = right;

		return root;
	}

	// ȱʡ��
	static TNode prepareTest2() {
		TNode root = new TNode('A');
		TNode left = new TNode('B');
		TNode right = new TNode('C');
		TNode leftleft = new TNode('D');
		TNode leftright = new TNode('E');
		TNode rightleft = new TNode('F');

		root.left = left;
		root.right = right;
		left.left = leftleft;
		left.right = leftright;
		right.left = rightleft;

		return root;
	}

	// ����
	static TNode prepareTest3() {
		TNode root = null;
		return root;
	}

	// ���齨������static TNode prepareTest4(char[]chars) {

	public static TNode prepareTest4(TNode root, char[] a, int i,int n) {
		if (i < a.length) {
			if(Math.pow(2, n)-1<a.length)
			{
				TNode tl = new TNode();
				TNode tr = new TNode();
				root.setNode(a[i], prepareTest4(tl, a, ++count,++n),
						prepareTest4(tr, a, ++count,n));
			}
			
		}
	
		return root;
	}
}
