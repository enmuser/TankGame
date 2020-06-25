package com.enmuser.decorator;

import com.enmuser.facade.GameModel;
import com.enmuser.mediator.GameObject;

import java.awt.*;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 10:29
 */
public abstract class AbstractDecorator extends GameObject {

    protected GameObject gameObject;

    public AbstractDecorator(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void paint(Graphics g) {
        gameObject.paint(g);
    }
}
