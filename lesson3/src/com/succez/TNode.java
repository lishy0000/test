package com.succez;
//�ڵ�
class TNode {
	char value;
	TNode left, right;
	public TNode(){}
	public TNode(char chars) {
		this.value = chars;
	}
	public TNode(TNode tnode) {
		this.value = tnode.value;
	}
	   public void setNode(char value,TNode lc,TNode rc){  
	        this.value = value;  
	        left = lc;  
	        right = rc;  
	    }
}