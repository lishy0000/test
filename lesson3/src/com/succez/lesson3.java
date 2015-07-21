package com.succez;

public class lesson3 {
//返回节点的字符串
	static char[] chars={'A','B','C','D','E'};
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
//找出该层所有节点并加载在字符串中
	static void TreeL(TNode tree, int n, StringBuilder sb) {
		if (tree != null) {

			TreeL(tree.left, --n, sb);
			if (n == 0)
				sb.append(tree.value);

			TreeL(tree.right, n, sb);

		}
	}

	public static void main(String[] args) {
		 TNode root = new TNode();  
         
	
		TNode tree1 = Testtree1.prepareTest4(root,chars,0,0);
		String value1 = TreeLevel(tree1, 3);
		System.out.println(value1);

	}

}
