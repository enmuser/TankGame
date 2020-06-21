package com.enmuser;

import java.io.IOException;
import java.util.Properties;

public class TankProperties {

    private TankProperties(){

    }

   private static Properties properties = new Properties();

   static {
       try {
           properties.load(TankProperties.class.getClassLoader().getResourceAsStream("tankgame.properties"));
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static String getProperty(String key){
       if(key == null) return null;
       else return properties.getProperty(key);
   }
}
