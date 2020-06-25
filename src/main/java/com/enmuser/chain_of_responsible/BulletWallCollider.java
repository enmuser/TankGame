package com.enmuser.chain_of_responsible;

import com.enmuser.Bullet;
import com.enmuser.Tank;
import com.enmuser.Wall;
import com.enmuser.mediator.GameObject;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 9:01
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if(bullet.getRectangle().intersects(wall.getRectangle())){
                bullet.die();
                return true;
            }
            return true;
        }else if(o1 instanceof Wall && o2 instanceof Bullet){
            return collide(o2,o1);
        }else {
            return true;
        }
    }
}
