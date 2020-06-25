package com.enmuser.observer;

import com.enmuser.Tank;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 18:23
 */
public class TankFireEvent {

    Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

    public Tank getSource(){
        return tank;
    }

}
