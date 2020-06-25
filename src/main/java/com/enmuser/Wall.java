package com.enmuser;

import com.enmuser.mediator.GameObject;

import java.awt.*;

/**
 * @description:
 * @author: enmuser
 * @time: 2020/6/25 8:46
 */
public class Wall extends GameObject {

    private int w;

    private int h;

    private Rectangle rectangle;

    public Wall(int x, int y,int w, int h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        this.rectangle = new Rectangle(x,y,w,h);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }
}
