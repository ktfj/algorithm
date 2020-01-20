
package com.example.controller;

import com.example.vo.Node;

/**
 *
 * @Author Admin
 * @Version 1.0
 * @Date 2019年10月15日
 */
public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree=new BinaryTree();
		Node root=tree.init();
//		tree.midTraversal(root);
		root=tree.deleteTreeKey(root, 3);
		System.out.println(root);
	}
	
	public Node init(){
		Node f=new Node(7, null, null);
		Node e=new Node(4, null, null);
		Node d=new Node(2, null, null);
		
		Node c=new Node(6, null, f);
		Node b=new Node(3, d, e);
		Node a=new Node(5, b, c);
		
		return a;
	}
	/**
	 * 中序便利：先遍历改节点的左子树，然后打印节点本身，最后在遍历右子树
	 * 
	 * @Author lib
	 * @Version 1.0
	 * @param root
	 * void
	 * @Date 2019年10月17日 下午6:16:42
	 */
	public void  midTraversal(Node root){
		 if(root.getLeftNode()!=null){
			 midTraversal(root.getLeftNode());
		 }
		 printNode(root);
		 
		 if(root.getRightNode()!=null){
			 midTraversal(root.getRightNode());
		 }
	}

	public void printNode(Node root) {
		System.out.print(root.getData());  
	}
	
	/**
	 * 删除二叉搜索树中的节点，删除完后还保证是一个二叉搜索树
	 * @Author lib
	 * @Version 1.0
	 * @param node
	 * @param key
	 * void
	 * @Date 2019年10月17日 下午6:47:59
	 */
	public Node deleteTreeKey(Node node,int key){
		Node currentNode=node;
		Node parentNode = null;
		//先找到要删除的元素
		while(currentNode!=null && currentNode.getData()!=key){
			   parentNode=currentNode;
			   if(currentNode.getData()>key){
				   currentNode=currentNode.getLeftNode();
			   }else{
				   currentNode=currentNode.getRightNode();
			   }
		}
		if(currentNode==null){
			return node; // 没有找到
		}
		//要删除的节点 ，左右子树都存在。
		if(currentNode.getLeftNode()!=null && currentNode.getRightNode()!=null){
			Node minNode=currentNode.getRightNode();
			Node minNodeParent=currentNode;
			while(minNode.getLeftNode()!=null){
				 minNodeParent=minNode;
				 minNode=minNode.getLeftNode();
			}
			
			currentNode.setData(minNode.getData());//把要删除节点的右子树最小值的data赋值给要删除的节点。相当于已经删除了 值等于key的节点
			
			//从这里开始就开始变成 删除  minNode这个节点。直接把这个节点赋值给currentNode。
			currentNode=minNode;
			parentNode=minNodeParent;
		}
		
		// 删除节点是叶子节点或者仅有一个子节点
        Node child;
        if(currentNode.getLeftNode()!=null){
        	child=currentNode.getLeftNode();
        }else if(currentNode.getRightNode()!=null){
        	child=currentNode.getRightNode();
        }else{
        	child=null;
        }
        
        if(parentNode==null){
        	node=child;//注意，删除的是根节点
        }else if(parentNode.getLeftNode()==currentNode){
        	parentNode.setLeftNode(child);
        }else{
        	parentNode.setRightNode(child);
        }
        return node;
	}
	
	
}

