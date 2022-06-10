package Java.综合案例.雷霆战机.cn.tx;

import javax.swing.*;
import java.awt.*;

public class HeroPlane extends Thread {
    //英雄机在画板上的位置
    int x = 230, y = 600;

    int width = 50, heigth = 50;

    //飞机移动的速度
    int speed = 10;

    Image img = new ImageIcon("src/雷霆战机/img/飞机大战类游戏飞机素材-飞行物-神平面(GodPlane)_爱给网_aigei_com.png").getImage();

    //定义方向键的标志
    boolean up, down, left, right;


    public HeroPlane() {
    }

    public HeroPlane(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;
    }

    @Override
    public void run() {
        while (true) {
            if (up) {
                y -= speed;
                if (y < 15) {
                    y = 15;
                }
            }
            if (down) {
                y += speed;
                if (y > 710 - 45) {
                    y = 710 - 45;
                }
            }
            if (left) {
                x -= speed;
                if (x < 0) {
                    x = 0;
                }
            }
            if (right) {
                x += speed;
                if (x > 450) {
                    x = 450;
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
