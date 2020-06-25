package com.enmuser.chain_of_responsible;

import com.enmuser.mediator.GameObject;

/**
 * @description: 碰撞器，模拟Comparator
 * @author: enmuser
 * @time: 2020/6/24 19:34
 */
public interface Collider {

    boolean collide(GameObject o1,GameObject o2);
}
