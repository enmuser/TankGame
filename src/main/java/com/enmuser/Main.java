package com.enmuser;

import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    //
      TankFrame tankFrame = new TankFrame();
      int initEnemyNums = Integer.parseInt(TankProperties.getProperty("enemy_init_nums"));

    for (int i = 0; i < initEnemyNums; i++){
      tankFrame.enemyTanks.add(new Tank(i*100+100,100,Direction.DOWN,tankFrame,Group.BAD,true));
    }

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
