package com.enmuser.abstractfactory.specifyfactory;

import com.enmuser.Direction;
import com.enmuser.Group;
import com.enmuser.TankFrame;
import com.enmuser.abstractfactory.*;
import com.enmuser.abstractfactory.specifybase.RectangleBullet;
import com.enmuser.abstractfactory.specifybase.RectangleExplode;

public class RectangleFactory extends GameFactory {

    private RectangleFactory(){

    }

    private static class RectangleFactoryInner{
        private static final RectangleFactory DEFAULT_FACTORY = new RectangleFactory();
    }

    public static RectangleFactory getInstance(){
        return RectangleFactoryInner.DEFAULT_FACTORY;
    }
    @Override
    public BaseBullet createBullet(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return new RectangleBullet(x,y,direction,tankFrame,group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectangleExplode(x,y,tankFrame);
    }

    @Override
    public BaseTank createTank(int x, int y, Direction direction, Group group, TankFrame tankFrame) {
        return null;
    }
}
