package com.enmuser;

import com.enmuser.abstractfactory.BaseBullet;

import java.awt.*;

public class Bullet extends BaseBullet {

    private int x;
    private int y;
    public static final int WIDTH = LoadResource.bulletD.getWidth();
    public static final int HEIGHT = LoadResource.bulletD.getHeight();
    private static final int SPEED = 20;
    private Direction direction;
    private TankFrame tankFrame;
    private Group group;
    private boolean isLive = true;

    Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Bullet(int x, int y, Direction direction, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
    }

    public Bullet(int x, int y, Direction direction, TankFrame tankFrame, Group group) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.tankFrame = tankFrame;
        this.group = group;
        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        tankFrame.bullets.add(this);

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

    @Override
    public void paint(Graphics g){
        if(!isLive){
            tankFrame.bullets.remove(this);
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


    @Override
    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;
        if(rectangle.intersects(tank.rectangle)){
            this.die();
            tank.die();
            int explodeX = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
            int explodeY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            //tankFrame.explodes.add(new Explode(explodeX,explodeY,tankFrame));
            tankFrame.explodes.add(tankFrame.gameFactory.createExplode(explodeX,explodeY,tankFrame));
        }
    }

    public void die() {
        isLive = false;
    }
}
