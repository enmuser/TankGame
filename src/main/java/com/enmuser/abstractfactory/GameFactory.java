package com.enmuser.abstractfactory;

import com.enmuser.Direction;
import com.enmuser.Group;
import com.enmuser.TankFrame;

public abstract class GameFactory {
    public abstract BaseBullet createBullet(int x, int y, Direction direction, Group group,TankFrame tankFrame);
    public abstract BaseExplode createExplode(int x,int y,TankFrame tankFrame);
    public abstract BaseTank createTank(int x,int y,Direction direction,Group group,TankFrame tankFrame);
}
