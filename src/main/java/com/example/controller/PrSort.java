
package com.example.controller;
/**
 *
 * @Author Admin
 * @Version 1.0
 * @Date 2019年7月31日
 */
public class PrSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={1,2};
		insetionSort(arr,3);
	}
	
	public static void insetionSort(int []arr,int n){
		
	     for(int i=1;i<n;i++){
	    	   int currentEle=arr[i];
	    	   int j=i-1;
	    	   for(;j>=0;j--){
	    		     if(arr[j]>currentEle){
	    		    	 arr[j+1]=arr[j];
	    		     }else{
	    		    	 break;
	    		     }
	    	   }
	    	   arr[j+1]=currentEle;
	     }
	
	}

}

