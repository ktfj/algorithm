
package com.example.vo;

import lombok.Data;

/**
 *
 * @Author Admin
 * @Version 1.0
 * @Date 2019年10月15日
 */
@Data
public class Node {
	 private int data;
	 private Node leftNode;
	 private Node rightNode;
	 
	 public Node(int data,Node leftNode,Node rightNode){
		     this.data=data;
		     this.leftNode=leftNode;
		     this.rightNode=rightNode;
	 }

}

