package com.enmuser;

import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    //
      TankFrame tankFrame = new TankFrame();


      while (true){
          try {
              TimeUnit.MILLISECONDS.sleep(100);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          tankFrame.repaint();
      }
  }
}
