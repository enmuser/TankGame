package com.enmuser;

import com.enmuser.strategy.DefaultFireStrategy;
import com.enmuser.strategy.FireStrategy;
import com.sun.org.apache.regexp.internal.RE;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TankUtils {

    public static void changeColorOnce(Graphics graphics,Color onceColor){
        Color color = graphics.getColor();
        graphics.setColor(onceColor);
    }

    public static FireStrategy getSpecifiedFireStrategy(String className){
        String classNamePath = TankProperties.getProperty(className);
        try {
            Constructor<?> declaredConstructor = Class.forName(classNamePath).getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            return (FireStrategy) declaredConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return  null;
    }

  public static void main(String[] args) {
    //

      String defaultStrategy = TankProperties.getProperty("DefaultStrategy");
      try {
          Constructor<?> declaredConstructor = Class.forName(defaultStrategy).getDeclaredConstructor(null);
          declaredConstructor.setAccessible(true);
          Object newInstance = declaredConstructor.newInstance();
          System.out.println(newInstance);
      } catch (InstantiationException e) {
          e.printStackTrace();
      } catch (IllegalAccessException e) {
          e.printStackTrace();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (NoSuchMethodException e) {
          e.printStackTrace();
      } catch (InvocationTargetException e) {
          e.printStackTrace();
      }
  }

}
