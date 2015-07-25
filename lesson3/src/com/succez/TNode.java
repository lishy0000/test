package com.succez;

//节点基类
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