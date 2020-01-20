
package com.example.controller;
/**
 *
 * @Author Administrator
 * @Version 1.0
 * @Date 2019年5月5日
 */
public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=recuresiveMethod(10);
		System.out.println(sum);
	}
	/**
	 * 递归的关键：1、递归推到条件。2、递归终止条件。
	 * 一般推到公式：
	 * f(n)=f(n-1)+1;
	 * f(1)=1;
	 * 求1-100相加。
	 * 
	 * @Author lib
	 * @Version 1.0
	 * void
	 * @Date 2019年5月5日 下午3:58:57
	 */
	public static int recuresiveMethod(int n){
		if(n==1){
			return 1;
		}else{
			return recuresiveMethod(n-1)+n;
		}
	}

}

