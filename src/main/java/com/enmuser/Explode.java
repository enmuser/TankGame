package com.enmuser;


import com.enmuser.facade.GameModel;
import com.enmuser.mediator.GameObject;

import java.awt.*;

public class Explode extends GameObject {

    public static int WIDTH = LoadResource.explodes[0].getWidth();
    public static int HEIGHT = LoadResource.explodes[0].getHeight();

    private int step = 0;
    public Explode(int x, int y, GameModel gameModel) {
        this.x = x;
        this.y = y;
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g){
        g.drawImage(LoadResource.explodes[step++],x,y,null);
        if (step >= LoadResource.explodes.length) GameModel.getInstance().removeObject(this);
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
