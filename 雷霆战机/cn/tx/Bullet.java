package Java.综合案例.雷霆战机.cn.tx;

import javax.swing.*;
import java.awt.*;

//  子弹
public class Bullet {
    //在面板上的坐标
    int x, y;
    int width = 50, height = 50;

    //定义子弹默认的速度
    int speed = 8;

    Image image = new ImageIcon("src/雷霆战机/img/雷霆战机+全民飞机大战+飞机大战全套素材-wsparticl_爱给网_aigei_com.png").getImage();

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }
}