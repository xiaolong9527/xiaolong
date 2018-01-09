package com.cn.zhou.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class TestEhcache {
    public static void main(String[] args) {
    	testEhcache();
	}
	
    public static void testEhcache() {
        // Creating a CacheManager based on a specified configuration file.
        CacheManager manager = CacheManager.newInstance("src/main/resources/ehcache.xml");
        // obtains a Cache called sampleCache1, which has been preconfigured in the configuration file
        Cache cache = manager.getCache("sampleCache1");
        // puts an element into a cache
        Element element = new Element("key1", "哈哈");
        cache.put(element);
        //The following gets a NonSerializable value from an element with a key of key1.
        Object value = element.getObjectValue();
        System.out.println(value.toString());
        manager.shutdown();
    }
}
