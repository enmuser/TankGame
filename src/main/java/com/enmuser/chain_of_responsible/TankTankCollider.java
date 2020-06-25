package com.enmuser.chain_of_responsible;

import com.enmuser.Tank;
import com.enmuser.mediator.GameObject;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/24 20:02
 */
public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            if(tank1.getRectangle().intersects(tank2.getRectangle())){
                tank1.setX(tank1.getPrex());
                tank1.setY(tank1.getPrey());
                tank1.setDirection(tank1.changDirection(tank1.getDirection()));
                tank2.setX(tank2.getPrex());
                tank2.setY(tank2.getPrey());
                tank2.setDirection(tank2.changDirection(tank2.getDirection()));
            }
        }else {
        }
        return true;
    }


}
