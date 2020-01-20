
package com.example.controller;

import java.util.Arrays;

/**
 *
 * @Author Administrator
 * @Version 1.0
 * @Date 2019年5月5日
 */
public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={5,1,1,2,0,0};//[]
//		bubbleSort(5,arr);
//		insetionSort(5,arr);
//		selectionSort(5,arr);
//		mergeSort(5,arr);
//		quickSort(arr,0,arr.length-1);
//		Arrays.stream(arr).forEach((item)->{System.out.println(item);}); 
	}
	
	/**
	 * 冒泡排序的思想：在于相邻的两个元素互换位置。直到所有元素的都有序后停止。
	 * 一次互换位置，至少有一个元素，排在它应该排在的 位置上。
	 * 从小到大排序。
	 * @Author lib
	 * @Version 1.0
	 * @param arr
	 * void
	 * @Date 2019年5月5日 下午1:40:07
	 */
    public static void bubbleSort(int n,int []arr){
    	for(int i=0;i<n;i++){
    		boolean flag=false;
    		//一次互换位置，至少有一个元素，排在它应该排在的 位置上。所以不需要再次循环所有（j<n-i-1）
    		for(int j=0;j<n-i-1;j++){
    			if(arr[j]>arr[j+1]){
    				int temp;
    				temp=arr[j];
    				arr[j]=arr[j+1];
    				arr[j+1]=temp;
    				flag=true; //表示有数据交换。
    			}
    		}
    		//本次循环若没有元素互换位置，说明元素顺序都已经排列好啦。
    		if(!flag){
    			break;
    		}
    	}
    	
        Arrays.stream(arr).forEach((item)->{System.out.println(item);});    	  
    }
    
    /**
     * 插入排序。
     * 思想：将数组中的元素分为两个区间。一是排序区间，二是未排序区间。初始已排序区间只有一个元素，
     *      插入排序的核心思想是：取未排序区间的一个元素，在已排序区间中找到合适的位置将其插入，并
     *      保证已排序区间的元素位置一直有序。重复操作，直至未排序区间元素为空。
     * 
     * 在已排序区间找到合适的位置插入流程:取未排序区间的一元素，和已排序区间的元素做循环对比（注意：是从已排序区间的首开始，
     * 还是尾部开始循环）。而且 是先移动数据，把所有需要往后移动的数据 都已完之后，然后再插入数据。
     * 
     * 
     * @Author lib
     * @Version 1.0
     * void
     * @Date 2019年5月5日 下午2:21:55
     */
    
    public static void insetionSort(int n,int []arr){
    	for(int i=1;i<n;i++){
    		  int currentEle=arr[i];
    		  int j=i-1; //从当前元素的前一个元素开始循环比较。--已次向前比较。
    		  for(;j>=0;j--){
    			   if(arr[j]>currentEle){
    				   arr[j+1]=arr[j];//数据移动。
    			   }else{
    				   break;
    			   }
    		  }
    		  //这里使用j+1的原因是：for循环里面j--了。
    		  arr[j+1]=currentEle; //插入数据。
    	}
    	 Arrays.stream(arr).forEach((item)->{System.out.println(item);});       	   	   	
    }
    /**
     * 选择排序：
     *  排序的思想与插入排序类型。也分为 已排序区间  和 未排序区间。
     *  
     *  不同的是：选择排序--每次把未排序区间的最小值，放到已排序区间的队尾。
     * 
     * 流程：最外层一次循环，把第一个值（默认最小）与数组中其他值做对比，找出最小值。然后与第一个值互换位置。
     * @Author lib
     * @Version 1.0
     * @param n
     * @param arr
     * void
     * @Date 2019年5月6日 上午11:28:55
     */
    public static void selectionSort(int n,int []arr){
    	for(int i=0;i<n;i++){
    		 for(int j=i+1;j<n;j++){
    			  if(arr[i]>arr[j]){
    				  int temp;
    				  temp=arr[i];
    				  arr[i]=arr[j];
    				  arr[j]=temp;
    			  }
    		 }
    		 
    	}
    	Arrays.stream(arr).forEach((item)->{System.out.println(item);}); 
    }
    /**
     * 归并排序。
     * 
     * 思想：分治思想+递归。
     * 流程：把数组从中间分成两部分。然后对这两部分数组分别排序。最后再将排好序的两部分合并在一起。这样整个数组就有序啦。
     * 
     * @Author lib
     * @Version 1.0
     * void
     * @Date 2019年5月8日 上午10:53:08
     */
    public static void mergeSort(int n,int arr[]){
    	   int []temp=new int[n];
    	   merge_sort(arr,0,n-1,temp);
    	   Arrays.stream(arr).forEach((item)->{System.out.println(item);}); 
    }
    public static void merge_sort(int arr[],int left,int right,int temp[]){
    	   if(left>=right){return;} //递归终止条件。
    	    //取中间位置。
		    int mid=(left+right)/2;
		    //分治递归。
		    merge_sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
		    merge_sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
		    
		    //讲 左边[left,mid]和右边[mid+1,right] 两个数组合到临时数组。
		    merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
    }
    public static void merge(int arr[],int left,int mid,int right,int temp[]){
  	           int i=left;//左序列 指针--指向第一个元素。
  	           int j=mid+1;//右序列指针--指向第二个元素。
  	           int k=0;//临时数组的指针。
  	           
  	           while(i<=mid && j<=right){
  	        	   if(arr[i]<=arr[j]){
  	        		    temp[k++]=arr[i++];
  	        	   }else{
  	        		    temp[k++]=arr[j++];
  	        	   }
  	           }
  	           
  	           //判断哪个子数组还有剩余的数据???
  	           //将左边剩余元素填充进temp中
  	           while(i<=mid){
  	        	  temp[k++]=arr[i++];
  	           }
  	           //将右序列剩余元素填充进temp中
  	           while(j<=right){
  	        	  temp[k++]=arr[j++];
  	           }
  	           
  	           //将临时数组temp中的数据，在拷贝到远数组中。
  	           k=0;
  	           while(left<=right){
  	        	     arr[left++]=temp[k++];
  	           }
  	
    }
    
    /**
     * https://juejin.im/post/5b55660ee51d4519202e2003
     * 快排的思想：
     *   从数组[p,r]中随意找一个数作为 基准数（这里找第一个元素）。 那么 把数组中 小于基准数的 元素放在左边，大于基准数的元素放在右边。
     *   然后递归 把数组拆分[p,q],[q+1,r],对拆分后的数组进行同样的操作。
     *   
     *   递归拆分的限制条件是：数据中仅仅剩余两个元素，这么就不能再次拆分。
     *   
     * 
     * @Author lib
     * @Version 1.0
     * @param n
     * @param arr
     * void
     * @Date 2019年8月6日 上午10:37:14
     */
    
    public static void quickSort(int arr[],int left,int right){
    	  if(left>=right){return;}
    	  int mid=partition(arr,left,right);
    	  
    	  quickSort(arr,left,mid);
    	  quickSort(arr,mid+1,right);   	  
    }
    
    public static int partition(int arr[],int left,int right){

    	  //选择 第一个数组第一个元素作为基准元素。
    	  int temp=arr[left];
    	  
    	  while(left<right){
    		  /**
    		   * 1、选择第一个元素存储到temp中，就相当于第一个位置，挖了一个坑。
    		   * 现在来埋坑：从右边开始寻找，找到一个小于temp的元素来填充这个坑
    		   * 
    		   * 注意：>= 一定是找小于不能是等于的数。
    		   */
    		  while(right>left && arr[right]>=temp){
    			    right--;
    		  }
    		  
    		  //找到这个元素，来埋坑。但是第一个坑埋完后。右边又出现一个新坑。
    		  if(right>left){
    			    arr[left]=arr[right];
    			    left++;//left 左边的元素就不需要动啦。
    		  }
    		  
    		  /**
    		   * 2、右边产生了新坑。
    		   * 现在来埋坑：从左边开始寻找，找到一个大于temp的元素来填充这个坑
    		   */
    		  while(left>right && arr[left]<=temp){
    			        left++;
  		      }
    		  //找到了这个元素，埋坑
    		  if(left<right){
    			  arr[right]=arr[left];
    			  right--;
    		  }  		     		  
    	  }
    	  
    	  //埋到最后，肯定有个坑未被填埋。那就拿temp中的元素来填。
    	  arr[left]=temp;
    	 
    	  return left;
  }

	public void Test() {

	}

}

