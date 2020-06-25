package com.enmuser.strategy;

import com.enmuser.*;
import com.enmuser.decorator.RectangleDecorator;
import com.enmuser.decorator.TailDecorator;
import com.enmuser.facade.GameModel;

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
//        switch (direction){
//            case LEFT:
//                new Bullet(bulletX,bulletY+4,direction,group);
//                break;
//            case UP:
//                new Bullet(bulletX,bulletY,direction,group);
//                break;
//            case RIGHT:
//                new Bullet(bulletX,bulletY+4,direction,group);
//                break;
//            case DOWN:
//                new Bullet(bulletX,bulletY,direction,group);
//                break;
//        }

        GameModel.getInstance().addObject(new RectangleDecorator(new TailDecorator(new Bullet(bulletX,bulletY,direction,group))));
//        switch (direction){
//            case LEFT:
//                GameModel.getInstance().addObject(new RectangleDecorator(new Bullet(bulletX,bulletY+4,direction,group)));
//                break;
//            case UP:
//                new RectangleDecorator(new Bullet(bulletX,bulletY,direction,group));
//                break;
//            case RIGHT:
//                new RectangleDecorator(new Bullet(bulletX,bulletY+4,direction,group));
//                break;
//            case DOWN:
//                new RectangleDecorator(new Bullet(bulletX,bulletY,direction,group));
//                break;
//        }
    }
}
