
package com.example.proxy;
/**
 *
 * @Author Administrator
 * @Version 1.0
 * @Date 2019年6月20日
 */
public class ProxyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        StartProxy startProxy=new StartProxy();
        Person person=startProxy.getPerson();
        person.sing();
	}

}

