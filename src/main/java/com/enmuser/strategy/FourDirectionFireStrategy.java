package com.enmuser.strategy;

import com.enmuser.*;

import java.util.concurrent.TimeUnit;

public class FourDirectionFireStrategy implements FireStrategy {

    private FourDirectionFireStrategy(){

    }

    private static class FourDirectionFireStrategyInner{
        private static final FourDirectionFireStrategy DEFAULT_FIRE_STRATEGY = new FourDirectionFireStrategy();
    }

    public static FourDirectionFireStrategy getInstance(){
        return FourDirectionFireStrategyInner.DEFAULT_FIRE_STRATEGY;
    }

    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bulletY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Direction direction = tank.getDirection();
        Group group = tank.getGroup();
        TankFrame tankFrame = tank.getTankFrame();
        Direction[] values = Direction.values();
        for (Direction direction1: values){
            tank.setDirection(direction1);
            tank.paint(tankFrame.getGraphics());
//            try {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
           // new Bullet(bulletX,bulletY,direction1,tankFrame,group);
            tankFrame.gameFactory.createBullet(bulletX,bulletY,direction1,group,tankFrame);
        }


//            case LEFT:
//                new Bullet(bulletX,bulletY+4,direction,tankFrame,group);
//                break;
//            case UP:
//                new Bullet(bulletX,bulletY,direction,tankFrame,group);
//                break;
//            case RIGHT:
//                new Bullet(bulletX,bulletY+4,direction,tankFrame,group);
//                break;
//            case DOWN:
//                new Bullet(bulletX,bulletY,direction,tankFrame,group);
//                break;
//        }
    }
}
