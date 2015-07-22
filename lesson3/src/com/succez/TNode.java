package com.succez;

//�ڵ�
class TNode {
	String value;
	TNode left, right;

	public TNode() {
	}

	public TNode(String chars) {
		this.value = chars;
	}

	public TNode(TNode tnode) {
		this.value = tnode.value;
	}
}