package com.enmuser.mediator;

import java.awt.*;

/**
 * @description: 游戏物体
 * @author: enmuser
 * @time: 2020/6/24 19:04
 */
public abstract class GameObject {

    private int x;

    private int y;

    public abstract void paint(Graphics g);
}
