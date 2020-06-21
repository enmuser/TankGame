package com.enmuser.abstractfactory.specifybase;

import com.enmuser.Audio;
import com.enmuser.LoadResource;
import com.enmuser.TankFrame;
import com.enmuser.abstractfactory.BaseExplode;

import java.awt.*;

public class RectangleExplode extends BaseExplode {

    private int x;

    private int y;

    private TankFrame tankFrame;

    public static int WIDTH = LoadResource.explodes[0].getWidth();
    public static int HEIGHT = LoadResource.explodes[0].getHeight();

    private int step = 0;
    public RectangleExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(LoadResource.explodes[step++],x,y,null);
//        if (step >= LoadResource.explodes.length) tankFrame.explodes.remove(this);

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(this.x+20,this.y+20,step*10,step*10);
        step++;
        if(step >= 5) tankFrame.explodes.remove(this);
        g.setColor(color);

    }
}
