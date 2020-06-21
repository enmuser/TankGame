package com.enmuser.abstractfactory;

import com.enmuser.*;

public class DefaultFactory extends GameFactory{

    private DefaultFactory(){

    }

    private static class DefaultFactoryInner{
        private static final DefaultFactory DEFAULT_FACTORY = new DefaultFactory();
    }

    public static DefaultFactory getInstance(){
        return DefaultFactoryInner.DEFAULT_FACTORY;
    }
    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new Bullet(x,y,direction,tankFrame,group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x,y,tankFrame);
    }

    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return null;
    }
}
