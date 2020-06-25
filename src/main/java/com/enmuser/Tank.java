package com.enmuser;

import com.enmuser.facade.GameModel;
import com.enmuser.mediator.GameObject;
import com.enmuser.observer.TankFireEvent;
import com.enmuser.observer.TankFireHandler;
import com.enmuser.observer.TankFireObserver;
import com.enmuser.strategy.DefaultFireStrategy;
import com.enmuser.strategy.FireStrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tank extends GameObject {
    private int prex;
    private int prey;
    public static final int WIDTH = LoadResource.goodTankD.getWidth();
    public static final int HEIGHT = LoadResource.goodTankD.getHeight();
    private static final int SPEED = 15;
    private Direction direction = Direction.DOWN;
    private Group group;
    private boolean isMoving = true;
    private boolean isLive = true;
    private Random random = new Random();
    public Rectangle rectangle = new Rectangle();
    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Tank(int x, int y, Direction direction,Group group, boolean isMoving) {
        this.x = x;
        this.y = y;
        this.prex = x;
        this.prex = y;
        this.direction = direction;
        this.group = group;
        this.isMoving = isMoving;
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

    public int getPrex() {
        return prex;
    }

    public void setPrex(int prex) {
        this.prex = prex;
    }

    public int getPrey() {
        return prey;
    }

    public void setPrey(int prey) {
        this.prey = prey;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
//        Color color = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x,y,30,30);
//        g.setColor(color);
        if(!isLive){
            GameModel.getInstance().removeObject(this);
            return;
        }
        switch (direction){
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? LoadResource.goodTankL : LoadResource.badTankL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? LoadResource.goodTankU : LoadResource.badTankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? LoadResource.goodTankR : LoadResource.badTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? LoadResource.goodTankD : LoadResource.badTankD,x,y,null);
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
        if(!isMoving) return;

        this.prex = this.x;
        this.prey = this.y;
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

        if(random.nextInt(100) > 95 && this.group == Group.BAD) this.fire(DefaultFireStrategy.getInstance());

        if(random.nextInt(100) > 95 &&this.group == Group.BAD) randomChangeDirection();

//        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) {
//            isLive = false;
//        }

        boundCheck();
        //update rectangle x,y
        rectangle.x = this.x;
        rectangle.y = this.y;

    }

    private void boundCheck() {

        if(this.x < 2) this.x = 2;
        if(this.y < 28) this.y = 28;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) this.y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
        if(this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) this.x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;

    }

    private void randomChangeDirection() {
        this.direction = Direction.values()[random.nextInt(4)];
    }

    public void fire(FireStrategy fireStrategy) {
        fireStrategy.fire(this);

//        int bulletX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
//        int bulletY = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
//        switch (direction){
//            case LEFT:
//                tankFrame.bullets.add(new Bullet(bulletX,bulletY+4,this.direction,tankFrame,group));
//                break;
//            case UP:
//                tankFrame.bullets.add(new Bullet(bulletX,bulletY,this.direction,tankFrame,group));
//                break;
//            case RIGHT:
//                tankFrame.bullets.add(new Bullet(bulletX,bulletY+4,this.direction,tankFrame,group));
//                break;
//            case DOWN:
//                tankFrame.bullets.add(new Bullet(bulletX,bulletY,this.direction,tankFrame,group));
//                break;
//        }

        /**********************************************************************************************************/
        //发射炮弹的声音
//        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();


//        int bulletX = this.x + 20;
//        int bulletY = this.y + 22;
//
//        switch (direction){
//            case LEFT:
//                tankFrame.bullets.add(new Bullet(bulletX-20,bulletY,this.direction,tankFrame,group));
//                break;
//            case UP:
//                tankFrame.bullets.add(new Bullet(bulletX,bulletY-20,this.direction,tankFrame,group));
//                break;
//            case RIGHT:
//                tankFrame.bullets.add(new Bullet(bulletX+20,bulletY+1,this.direction,tankFrame,group));
//                break;
//            case DOWN:
//                tankFrame.bullets.add(new Bullet(bulletX-2,bulletY+20,this.direction,tankFrame,group));
//                break;
//        }
    }

    public void die() {
        isLive = false;
    }

    public void stop(){
        isMoving = false;
    }

    public void backStep(){
        this.x = this.prex;
        this.y = this.prey;
    }

    public Direction changDirection(Direction direction){
        if(direction.equals(Direction.UP)){
            return direction = Direction.DOWN;
        }
        if (direction.equals(Direction.DOWN)){
            return direction = Direction.UP;
        }
        if (direction.equals(Direction.LEFT)){
            return direction = Direction.RIGHT;
        }
        if (direction.equals(Direction.RIGHT)){
            return  direction = Direction.LEFT;
        }
        return direction = Direction.DOWN;
    }
    //为了实现Observer模式，新增
    private List<TankFireObserver> fireObserverList = Arrays.asList(new TankFireHandler());

    public void handleFireKey(){
        TankFireEvent fireEvent = new TankFireEvent(this);
        for(TankFireObserver fireObserver : fireObserverList){
            fireObserver.actionOnFire(fireEvent);
        }
    }
}
