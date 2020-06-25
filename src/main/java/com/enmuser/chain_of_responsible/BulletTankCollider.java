package com.enmuser.chain_of_responsible;

import com.enmuser.Bullet;
import com.enmuser.Explode;
import com.enmuser.Tank;
import com.enmuser.facade.GameModel;
import com.enmuser.mediator.GameObject;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/24 19:37
 */
public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            return !collideWith(bullet,tank);
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            return collide(o2,o1);
        }else {
            return true;
        }

    }

    private boolean collideWith(Bullet bullet,Tank tank){
        if(bullet.getGroup() == tank.getGroup()) return false;
        if(bullet.getRectangle().intersects(tank.getRectangle())){
            bullet.die();
            tank.die();
            GameModel gameModel = GameModel.getInstance();
            int explodeX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int explodeY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            gameModel.addObject(new Explode(explodeX,explodeY,gameModel));
            return true;
        }
        return false;
    }
}
