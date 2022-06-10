package Java作业.第八次作业.ATM取款机.开始界面;

import Java作业.第八次作业.ATM取款机.账号类型判断.Accout;

import javax.swing.*;
import java.awt.*;

/*
      TODO: 开始界面
 */
public class View {
    public JFrame jf = new JFrame("ATM取款机");
    JLabel jl1 = new JLabel("1: 管理员账号");
    JLabel jl2 = new JLabel("2: 用户账号");
    JTextField jf1 = new JTextField(2);
    JLabel jl3 = new JLabel("账号: ");
    JTextField jf2 = new JTextField(15);
    JLabel jl4 = new JLabel("密码: ");
    JTextField jf3 = new JTextField(15);
    JButton btn = new JButton("确定");
    JPanel jpanel = new JPanel();

    // x 轴的坐标
    public int x(int w) {
        return Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2;
    }

    // y 轴的坐标
    public int y(int h) {
        return Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
    }

    public void init() {
        // 点击事件
        btn.addActionListener(i -> {
            try {
                Accout a = new Accout();
                String s1 = this.jf1.getText();  // 账号类型
                String s2 = this.jf2.getText();  // 账号
                String s3 = this.jf3.getText(); // 密码
                if ("1".equals(s1)) {
                    a.manager("1" ,s2);  // 调用管理员的方法  账号 传入
                } else {
                    a.user("0", s2, s3);  // 调用用户的方法  账号 密码 传入
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }
        });

        // 绘制图片
        ImageIcon img_bg = new ImageIcon(new ImageIcon("src/ATM取款机/img/QJ7116979511.jpg")
                .getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT));
        JLabel label = new JLabel();  // 绘制到 JLabel 中
        label.setIcon(img_bg);
        jpanel.add(label);

        // 组装视图
        Box bh = Box.createVerticalBox();
        bh.add(jl1);
        bh.add(jl2);
        Box bh1 = Box.createHorizontalBox();
        bh1.add(bh);
        bh1.add(jf1);

        Box bh2 = Box.createHorizontalBox();
        bh2.add(jl3);
        bh2.add(jf2);
        Box bh3 = Box.createHorizontalBox();
        bh3.add(jl4);
        bh3.add(jf3);
        Box bv1 = Box.createVerticalBox();
        bv1.add(jpanel);
        bv1.add(bh2);
        bv1.add(bh3);

        jf.add(bh1, BorderLayout.NORTH);
        jf.add(bv1, BorderLayout.CENTER);
        jf.add(btn, BorderLayout.SOUTH);

        jf.setBounds(x(500), y(500), 500, 500);  // 设置试图位置和大小
        jf.setVisible(true);  // 显示试图
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 可以使用关闭按钮
    }
}