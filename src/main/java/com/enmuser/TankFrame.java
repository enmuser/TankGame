package com.enmuser;



import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200,Direction.DOWN,this,Group.GOOD,false);

    public List<Bullet> bullets = new ArrayList<>();
    public List<Tank> enemyTanks = new ArrayList<>();
    public List<Explode> explodes = new ArrayList<>();

    public static final int GAME_WIDTH = 1024, GAME_HEIGHT = 650;

    public TankFrame() throws HeadlessException {
        //Frame f = new Frame();
        //设置大小
        setSize(GAME_WIDTH,GAME_HEIGHT);
        //设置是否可以自由改变大小
        setResizable(false);
        //添加标题
        setTitle("坦克大战");
        setVisible(true);

        //键盘监听事件
        addKeyListener(new MyKeyListener());

        //添加win关闭按钮事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });



    }

    //现在内存中图，再画到屏幕
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
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
//        explode.paint(g);
    }


    class MyKeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_SPACE:
                    //myTank.fire(DefaultFireStrategy.getInstance());
                    myTank.fire(TankUtils.getSpecifiedFireStrategy("DefaultStrategy"));
                    break;
                case KeyEvent.VK_Q:
                    //myTank.fire(FourDirectionFireStrategy.getInstance());
                    myTank.fire(TankUtils.getSpecifiedFireStrategy("FourDirectionFireStrategy"));
                    break;
                default:break;
            }
            setMainTankDirection();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:break;
            }

            setMainTankDirection();

        }

        private void setMainTankDirection() {
            if(!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
                if(bL) myTank.setDirection(Direction.LEFT);
                if(bU) myTank.setDirection(Direction.UP);
                if(bR) myTank.setDirection(Direction.RIGHT);
                if(bD) myTank.setDirection(Direction.DOWN);
            }

        }
    }


}
