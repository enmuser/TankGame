package com.enmuser;


import java.awt.*;

public class Explode{

    private int x;

    private int y;

    private TankFrame tankFrame;

    public static int WIDTH = LoadResource.explodes[0].getWidth();
    public static int HEIGHT = LoadResource.explodes[0].getHeight();

    private int step = 0;
    public Explode(int x, int y, TankFrame tankFrame) {
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

    public void paint(Graphics g){
        g.drawImage(LoadResource.explodes[step++],x,y,null);
        if (step >= LoadResource.explodes.length) tankFrame.explodes.remove(this);
    }
}
