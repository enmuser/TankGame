package com.enmuser;


import com.enmuser.facade.GameModel;
import com.enmuser.mediator.GameObject;

import java.awt.*;

public class Bullet extends GameObject {

    public static final int WIDTH = LoadResource.bulletD.getWidth();
    public static final int HEIGHT = LoadResource.bulletD.getHeight();
    private static final int SPEED = 20;
    private Direction direction;
    private Group group;
    private boolean isLive = true;

    Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Direction direction,Group group) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.group = group;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        GameModel.getInstance().addObject(this);

    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g){
        if(!isLive){
            GameModel.getInstance().removeObject(this);
            return;
        }
//        Color color = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x,y,WIDTH,HIGHT);
//        g.setColor(color);
        switch (direction){
            case LEFT:
                g.drawImage(LoadResource.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(LoadResource.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(LoadResource.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(LoadResource.bulletD,x,y,null);
                break;
        }
        moving();
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private void moving() {
        switch (direction){
            case LEFT:
                x -=SPEED;
                break;
            case UP:
                y -=SPEED;
                break;
            case RIGHT:
                x +=SPEED;
                break;
            case DOWN:
                y +=SPEED;
                break;
        }
        //update rectangle x,y
        rectangle.x = this.x;
        rectangle.y = this.y;

        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) setLive(false);
    }

    public void die() {
        isLive = false;
    }
}
