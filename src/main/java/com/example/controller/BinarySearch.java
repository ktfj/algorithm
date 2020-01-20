
package com.example.controller;
/**
 * 二分查找 。
 * @Author Admin
 * @Version 1.0
 * @Date 2019年8月13日
 */
public class BinarySearch {
	
	  public static void main(String[] args) {
//		  int []arr={2,4,6,8,9,10};
//		  int index=ordinaryBinary(arr,0,arr.length-1,8);
		  
//		  int []arr={8};//2,4,6,8,8,8,8,9,10
//		  int index=changeBinaryOne(arr,0,arr.length-1,8);
		  
		  int []arr={3,4,6,7,10};
		  int index=changeBinaryThree(arr,0,arr.length-1,5);
		  if(index!=-1){
			   System.out.println("元素所在的位置："+index);
		  }else{
			   System.out.println("元素不在数组中");
		  }
	  }
	  /**
	   * 递归实现-普通的二分查找。  即有序数据集合中不存在重复的数据
	   * 优势：
	   *   时间复杂度是 logn;
	   * 
	   * 局限性：
	   *   1、二分查找的数据结构是 顺序表结构，也就是数组。（因为该算法需要按照下标随机访问元素）
	   *   2、数据是有序的。所以需要先排序(最快O(nlogn))。
	   *   3、数据太小的话，直接遍历。数据太大，数组装不下。数组需要联系的内存空间。
	   * 
	   * @Author lib
	   * @Version 1.0
	   * @param arr
	   * void
	   * @Date 2019年8月13日 上午10:17:18
	   */
	  public static int ordinaryBinary(int []arr,int left,int right,int element){
		      if(left>right){return -1;}
		      int mid =(left+right)/2;		      
		      if(arr[mid]==element){
		    	     return mid;
		      }else if(arr[mid]>element){
		    	    right=mid-1;
		    	    return ordinaryBinary(arr,left,right,element);
		      }else{
		    	    left=mid+1;
		    	    return ordinaryBinary(arr,left,right,element);
		      }		  
	  }
	  
	  /**
	   * 二分查找变体
	   * 前提：数据是有序的，有重复元素。
	   * 变体一：查询第一个值等于给定值的元素。
	   * @Author lib
	   * @Version 1.0
	   * @param arr
	   * @param left
	   * @param right
	   * @param element
	   * @return
	   * int
	   * @Date 2019年8月14日 上午10:17:21
	   */	  
	  public static int changeBinaryOne(int []arr,int left,int right,int element){  
		   while(left<=right){
			      int mid=(left+right)/2;
			      if(arr[mid]==element){
                      //注释：||与&& 第一个条件满足后，就不在判断第二个条件
			    	  if(mid==0 || arr[mid-1]!=element){
			    		   return mid;
			    	  }else{
			    		  right=mid-1;
			    	  }
			      }else if(arr[mid]>element){
			    	     right=mid-1;			    	     
			      }else{
			    	     left=mid+1;
			      }
		   }
		   return -1;
	  }
	  
	  /**
	   * 二分查找变体
	   * 前提：数据是有序的，有重复元素。
	   * 变体三：查询第一个 大于等于5的元素。
	   * @Author lib
	   * @Version 1.0
	   * @param arr
	   * @param left
	   * @param right
	   * @param element
	   * @return
	   * int
	   * @Date 2019年8月14日 上午10:17:21
	   */	  
	  public static int changeBinaryThree(int []arr,int left,int right,int element){  
		   while(left<=right){
			      int mid=(left+right)/2;
			      if(arr[mid]>=element){
			    	   if(mid==right || arr[mid-1]<element){
			    		       return mid;
			    	   }else{
			    		      right=mid-1;
			    	   }
			      }else{
			    	   left=mid+1;
			      }
		   }
		   return -1;
	  }
	  
	  
	  
	  

}

