package com.succez;

public class lesson3 {
//���ؽڵ���ַ���
	static char[] chars={'A','B','C','D','E'};
	static String TreeLevel(TNode tree, int n) {
		if (tree == null) {

			return "����";
		} else if (n <= 0) {
			return "n����Ϊ0�͸���";
		} else {
			StringBuilder sb = new StringBuilder();

			TreeL(tree, n, sb);

			return sb.toString();
		}
	}
//�ҳ��ò����нڵ㲢�������ַ�����
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
