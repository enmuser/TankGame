package com.enmuser.observer;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 18:22
 */
public interface TankFireObserver {

    void actionOnFire(TankFireEvent fireEvent);
}
