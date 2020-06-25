package com.enmuser.facade;

import com.enmuser.*;
import com.enmuser.chain_of_responsible.BulletTankCollider;
import com.enmuser.chain_of_responsible.Collider;
import com.enmuser.chain_of_responsible.ColliderChain;
import com.enmuser.chain_of_responsible.TankTankCollider;
import com.enmuser.mediator.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:Facade门面模式
 * @author: enmuser
 * @time: 2020/6/24 18:24
 */
public class GameModel {

    Tank myTank = new Tank(200,200, Direction.DOWN,this, Group.GOOD,false);

//    public List<Bullet> bullets = new ArrayList<>();
//    public List<Tank> enemyTanks = new ArrayList<>();
//    public List<Explode> explodes = new ArrayList<>();

    ColliderChain colliderChain = new ColliderChain();
    List<GameObject> gameObjects = new ArrayList<>();
    private TankFrame tankFrame;
    public GameModel(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
        int initEnemyNums = Integer.parseInt(TankProperties.getProperty("enemy_init_nums"));
        for (int i = 0; i < initEnemyNums; i++){
            addObject(new Tank(i*100+100,100,Direction.DOWN,this,Group.BAD,true));
        }
    }

    public void addObject(GameObject object){
        gameObjects.add(object);
    }

    public void removeObject(GameObject object){
        gameObjects.remove(object);
    }

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("当前子弹的数量:"+bullets.size(),10,60);
//        g.drawString("当前敌人的数量:"+enemyTanks.size(),10,80);
//        g.drawString("当前爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(color);
        myTank.paint(g);

        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).paint(g);
        }

        for (int i = 0; i < gameObjects.size(); i++){
            for (int j = i+1; j < gameObjects.size(); j++){
                colliderChain.collide(gameObjects.get(i),gameObjects.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
