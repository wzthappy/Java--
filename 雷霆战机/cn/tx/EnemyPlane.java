package Java.综合案例.雷霆战机.cn.tx;

import javax.swing.*;
import java.awt.*;

public class EnemyPlane extends Thread {

    public GameFrame gf;
    //子弹的坐标，大小，速度
    public int x, y;
    public int width = 50;
    public int height = 50;
    public int speed = 2;

    public Image img = new ImageIcon("src/雷霆战机/img/雷霆战机+全民飞机大战+飞机大战全套素材-A4-2(a4-2_爱给网_aigei_com.png").getImage();

    public EnemyPlane(int x, int y, GameFrame gf) {
        this.gf = gf;
        this.x = x;
        this.y = y;
    }

    public EnemyPlane(int x, int y, int width, int height, GameFrame gf) {
        this.gf = gf;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //
    @Override
    public void run() {
        while (true) {
            //向左走
            //碰撞到了
            if (hit()) {
                this.speed = 0;
                this.img = new ImageIcon("src/雷霆战机/img/html5全民飞机大战游戏源码-2_爱给网_aigei_com.gif").getImage();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gf.enemys.remove(this);
                //被子弹击毁
                break;
            }

            if (this.y >= 760) {
                break;
            }

            try {
                this.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //检测碰撞
    public boolean hit() {
        Rectangle myrect = new Rectangle(this.x, this.y, this.width, this.height);

        Rectangle rect = null;

        for (int i = 0; i < gf.bullets.size(); i++) {
            Bullet bullet = gf.bullets.get(i);
            rect = new Rectangle(bullet.x, bullet.y - 1, bullet.width, bullet.height);
            //碰撞检测
            if (myrect.intersects(rect)) {
                return true;
            }
        }
        return false;
    }


}