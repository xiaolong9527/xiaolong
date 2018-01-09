//package com.cn.zhou.cache;
//
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Component;
//
///**
// * Created by GWCheng on 2016/3/3.
// */
//@Component
////这里定义了之后就不必在下面的每个方法上写 cacheNames="books" 了
//@CacheConfig(cacheNames = "books")
//public class CacheService {
//
//    @Cacheable(key="#isbn")
//    public Book findBook(String isbn) throws BookNotFoundException {
//        System.out.println("isbn="+isbn+" 方法调用");
//        Book book = null;
//        if (isbn == "123") {
//            book = new Book("123", "Thinking in Java");
//        } else if (isbn == "456") {
//            book = new Book("456", "Effective Java");
//        } else {
//            throw new BookNotFoundException("没有找到isbn对应的书");
//        }
//        return book;
//
//    }
//}
