package com.succez;

class TNode {
	String value;
	TNode left, right;

	public TNode(String s) {
		this.value = s;
	}
}
public class Wellcome {
	
	static String result="";
	static TNode prepareTest1(){
		TNode root = new TNode("A");
		TNode left = new TNode("B");
		TNode right = new TNode("C");
		
		root.left = left;
		root.right = right;
		return root;
	}
//	prepareTest2
	
	//-1,0,1,2,3
	static String TreeLevel(TNode tree, int n){
		if(tree==null){
			 System.out.print("空树");
			 return "";
			}
		else if(n<=0){System.out.print("n不能为0和负数"); return "";}
		else	{StringBuilder sb = new StringBuilder();
		
		 TreeL(tree, n, sb);
		
		return sb.toString();
	}
	}
	static void TreeL(TNode tree, int n, StringBuilder sb){
		if(tree!=null){
			  
			TreeL(tree.left,--n, sb); 
			if(n==0)
				sb.append(tree.value);
		
			TreeL(tree.right,n,sb); 
			
		}
	}
 public static void main(String[] args){
	
	 TNode tree1 = prepareTest1();
	 String value1 = TreeLevel(tree1,1);
     System.out.println(value1);

 }

}
