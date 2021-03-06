package com.enmuser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoadResource {


    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;

//    public static BufferedImage tankL,tankU,tankR,tankD;
    public static BufferedImage bulletL,bulletU,bulletR,bulletD;
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            //第一版
//            tankL = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
//            tankU = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
//            tankR = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
//            tankD = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
//            tankU = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
//            tankL = ImageUtil.rotateImage(tankU, -90);
//            tankR = ImageUtil.rotateImage(tankU, 90);
//            tankD = ImageUtil.rotateImage(tankU, 180);
            goodTankU = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU, -90);
            goodTankR = ImageUtil.rotateImage(goodTankU, 90);
            goodTankD = ImageUtil.rotateImage(goodTankU, 180);

            badTankU = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU, -90);
            badTankR = ImageUtil.rotateImage(badTankU, 90);
            badTankD = ImageUtil.rotateImage(badTankU, 180);
            bulletL = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(LoadResource.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
