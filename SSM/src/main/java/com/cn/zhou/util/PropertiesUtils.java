package com.cn.zhou.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    
    public static void main(String[] args) {
        Properties properties = new Properties();
        try {
//            InputStream in = PropertiesUtils.class.getResourceAsStream("/com/cn/zhou/util/db.properties");//或者直接写成"db.properties"
            InputStream in = PropertiesUtils.class.getResourceAsStream("./db.properties");//或者直接写成"db.properties"
            properties.load(in);
            String type = properties.getProperty("jdbc.type");
            System.out.println(type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}
