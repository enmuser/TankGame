package com.enmuser.strategy;

import com.enmuser.*;

/**
 * 单例
 */
public class DefaultFireStrategy implements FireStrategy {

    private DefaultFireStrategy(){

    }

    private static class DefaultFireStrategyInner{
        private static final DefaultFireStrategy DEFAULT_FIRE_STRATEGY = new DefaultFireStrategy();
    }

    public static DefaultFireStrategy getInstance(){
        return DefaultFireStrategyInner.DEFAULT_FIRE_STRATEGY;
    }

    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bulletY = tank.getY() + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Direction direction = tank.getDirection();
        Group group = tank.getGroup();
        TankFrame tankFrame = tank.getTankFrame();
        switch (direction){
            case LEFT:
                tankFrame.gameFactory.createBullet(bulletX,bulletY+4,direction,group,tankFrame);
                //new Bullet(bulletX,bulletY+4,direction,tankFrame,group);
                break;
            case UP:
                tankFrame.gameFactory.createBullet(bulletX,bulletY,direction,group,tankFrame);
                //new Bullet(bulletX,bulletY,direction,tankFrame,group);
                break;
            case RIGHT:
                tankFrame.gameFactory.createBullet(bulletX,bulletY+4,direction,group,tankFrame);
                //new Bullet(bulletX,bulletY+4,direction,tankFrame,group);
                break;
            case DOWN:
                tankFrame.gameFactory.createBullet(bulletX,bulletY,direction,group,tankFrame);
                //new Bullet(bulletX,bulletY,direction,tankFrame,group);
                break;
        }
    }
}
