package com.enmuser;

import com.enmuser.facade.GameModel;

import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    //
      TankFrame tankFrame = new TankFrame();
      GameModel.getInstance().setTankFrame(tankFrame);

      while (true){
          try {
              TimeUnit.MILLISECONDS.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          tankFrame.repaint();
      }
  }
}
