package com.enmuser.chain_of_responsible;

import com.enmuser.mediator.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/24 23:57
 */
public class ColliderChain implements Collider {

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        addCollider(new BulletTankCollider());
        addCollider(new TankTankCollider());
        addCollider(new BulletWallCollider());
        addCollider(new TankWallCollider());
    }

    public void addCollider(Collider collider){
        colliders.add(collider);
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for(Collider collider : colliders){
            if(!collider.collide(o1,o2)) return false;
        }
        return true;
    }
}
