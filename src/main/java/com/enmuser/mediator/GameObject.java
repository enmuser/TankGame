package com.enmuser.mediator;

import java.awt.*;

/**
 * @description: 游戏物体
 * @author: enmuser
 * @time: 2020/6/24 19:04
 */
public abstract class GameObject {

    protected int x;

    protected int y;

    public abstract void paint(Graphics g);
}
