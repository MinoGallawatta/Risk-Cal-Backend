package com.cdr.CDR.mapper;

import com.cdr.CDR.structure.Properties;
import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DataMapper {
    private static final Map<Integer, Integer> map =   new HashMap<Integer,Integer>();
    private static java.util.Properties properties = new java.util.Properties();

    public static void loadProperties(){
        Map<String, String> ldapContent = new HashMap<String, String>();
        try{
            properties.load(new FileInputStream("data2.properties"));

            for (final String name: properties.stringPropertyNames())
                map.put(Integer.valueOf(name), Integer.valueOf(properties.getProperty(name)));
        }
        catch (Exception e){
            e.printStackTrace();
        }


        for (String key : properties.stringPropertyNames()) {
            ldapContent.put(key, properties.get(key).toString());
        }
    }
    public static void saveData(Properties prop,Integer val){
        map.put(prop.getHc(),val);


        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            properties.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()));
        }
        try{
            properties.store(new FileOutputStream("data2.properties"), null);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Integer findData(Properties properties){
        int cdrVal = map.get(properties);
        System.out.println(cdrVal);
        return cdrVal;
    }

}
