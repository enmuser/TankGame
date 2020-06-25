package com.enmuser.chain_of_responsible;

import com.enmuser.Bullet;
import com.enmuser.Tank;
import com.enmuser.Wall;
import com.enmuser.mediator.GameObject;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 9:02
 */
public class TankWallCollider implements Collider{


    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall){
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if(tank.getRectangle().intersects(wall.getRectangle())){
                tank.backStep();
                return true;
            }
            return true;
        }else if(o1 instanceof Wall && o2 instanceof Tank){
            return collide(o2,o1);
        }else {
            return true;
        }
    }
}
