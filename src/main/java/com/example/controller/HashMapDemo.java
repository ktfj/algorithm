
package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @Author Administrator
 * @Version 1.0
 * @Date 2019年4月17日
 */
public class HashMapDemo {
    public static void main(String[] args) {
    	     Map<String,Object> map=new HashMap<>();
    	     map.put("orderCode", "123456");
    	     map.put("orderStatus", "new");
    	     foreachHashMap(map);
	}
    public static void foreachHashMap(Map<String,Object> map){
    	    //获取key-value对（Entry）的set集合。
    	    Set<Entry<String,Object>> entrySet=map.entrySet();
    	     
    	    entrySet.forEach(item->{
    	    	   System.out.println(item.getKey()+"::"+item.getValue());
    	    });
    	
    }
}

