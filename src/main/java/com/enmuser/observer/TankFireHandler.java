package com.enmuser.observer;

import com.enmuser.Tank;
import com.enmuser.TankUtils;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 18:26
 */
public class TankFireHandler implements TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent fireEvent) {
        Tank source = fireEvent.getSource();
        source.fire(TankUtils.getSpecifiedFireStrategy("DefaultStrategy"));
    }
}
