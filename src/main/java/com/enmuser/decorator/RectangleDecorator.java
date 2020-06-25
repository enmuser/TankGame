package com.enmuser.decorator;

import com.enmuser.facade.GameModel;
import com.enmuser.mediator.GameObject;

import java.awt.*;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 10:30
 */
public class RectangleDecorator extends AbstractDecorator{

    public RectangleDecorator(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void paint(Graphics g) {
        this.x = gameObject.getX();
        this.y = gameObject.getY();
        gameObject.paint(g);
        Color color = g.getColor();
        g.setColor(Color.GREEN);
        g.drawRect(super.gameObject.getX(),super.gameObject.getY(),getWidth(),getHeight());
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.gameObject.getWidth();
    }

    @Override
    public int getHeight() {
        return super.gameObject.getHeight();
    }
}
