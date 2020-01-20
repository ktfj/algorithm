
package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 *
 * @Author Administrator
 * @Version 1.0
 * @Date 2019年6月20日
 * 注意：动态代理也有个约束：目标对象一定是要有接口的，没有接口就不能实现动态代理
 */
public class StartProxy {
	  //代理只是一个中介，实际干活的还是 start对象，于是需要在代理类上维护 “start”这个变量
	  private Start start=new Start();
      //返回代理对象。
	  public Person getPerson(){
		    /**
	         * 参数一：代理类的类加载器
	         * 参数二：被代理对象的接口
	         * 参数三：InvocationHandler实现类
	         */
		  return  (Person) Proxy.newProxyInstance(StartProxy.class.getClassLoader(),start.getClass().getInterfaces(),new InvocationHandler(){
			  /**
	         * proxy : 把代理对象自己传递进来
	         * method：把代理对象当前调用的方法传递进来
	         * args:把方法参数传递进来
	         */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				//如果别人想要让start唱歌
                if (method.getName().equals("sing")) {
                    System.out.println("给1000万来再唱");
                    //实际上唱歌的还是start
                    method.invoke(start, args);
                }
				return null;
			}});
	  }
}

