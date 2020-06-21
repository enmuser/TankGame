package com.enmuser.abstractfactory;

import com.enmuser.Tank;

import java.awt.*;

public abstract class BaseBullet {

    public abstract void paint(Graphics graphics);

    public abstract  void collideWith(Tank tank);
}
