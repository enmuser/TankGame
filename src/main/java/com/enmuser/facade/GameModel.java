package com.enmuser.facade;

import com.enmuser.*;

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

    public java.util.List<Bullet> bullets = new ArrayList<>();
    public java.util.List<Tank> enemyTanks = new ArrayList<>();
    public List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int initEnemyNums = Integer.parseInt(TankProperties.getProperty("enemy_init_nums"));

        for (int i = 0; i < initEnemyNums; i++){
            enemyTanks.add(new Tank(i*100+100,100,Direction.DOWN,this,Group.BAD,true));
        }
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("当前子弹的数量:"+bullets.size(),10,60);
        g.drawString("当前敌人的数量:"+enemyTanks.size(),10,80);
        g.drawString("当前爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(color);
        myTank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        for (int i = 0; i < enemyTanks.size();i++){
            enemyTanks.get(i).paint(g);
        }

        for(int i = 0; i < explodes.size(); i++){
            explodes.get(i).paint(g);
        }
        for (int i = 0; i < bullets.size(); i++){
            for (int j = 0; j < enemyTanks.size(); j++){
                bullets.get(i).collideWith(enemyTanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return myTank;
    }
}
