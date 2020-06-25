package com.enmuser.decorator;

import com.enmuser.mediator.GameObject;

import java.awt.*;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 11:28
 */
public class TailDecorator extends AbstractDecorator{


    public TailDecorator(GameObject gameObject) {
        super(gameObject);
    }


    @Override
    public void paint(Graphics g) {
        this.x = gameObject.getX();
        this.y = gameObject.getY();
        gameObject.paint(g);
        Color color = g.getColor();
        g.setColor(Color.GREEN);
        g.drawLine(gameObject.getX(),gameObject.getY(),gameObject.getX()+getWidth(),gameObject.getY()+getHeight());
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
