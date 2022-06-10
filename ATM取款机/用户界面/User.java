package Java作业.第八次作业.ATM取款机.用户界面;

import Java作业.第八次作业.ATM取款机.开始界面.View;
import Java作业.第八次作业.ATM取款机.用户和管理员对象.NameText;
import Java作业.第八次作业.ATM取款机.用户界面.实现用户的功能.Deposit;
import Java作业.第八次作业.ATM取款机.用户界面.实现用户的功能.NewWD;
import Java作业.第八次作业.ATM取款机.用户界面.实现用户的功能.Transfer;
import Java作业.第八次作业.ATM取款机.用户界面.实现用户的功能.Withdraw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
        TODO: 用户界面
 */
public class User {
  JFrame jf ;
  JLabel jl = new JLabel("请选择您要的操作: ");
  JButton btn1 = new JButton("转账");
  JButton btn2 = new JButton("取钱");
  JButton btn3 = new JButton("存款");
  JButton btn4 = new JButton("退出");
  JButton btn5 = new JButton("修改密码");

  // 用户界面组装
  public void init (ArrayList<NameText> nameText, String zh) {
    jf = new JFrame("账号名为: " + zh + "------ 用户账户");   // 用户标题

    // 点击事件
    btn1.addActionListener(i -> {  // 转账
      new Transfer().init(nameText, zh);  // 打开转账视图
    });
    btn2.addActionListener(i -> {  // 取钱
      new Withdraw().init(nameText, zh);
    });
    btn3.addActionListener(i -> {  // 存款
      new Deposit().init(nameText, zh, "谢谢您的信任！ ^_^");
    });
    btn4.addActionListener(i -> {  // 退出
      System.exit(0);  // 退出 JVW (java虚拟机)
    });
    btn5.addActionListener(i -> {  // 修改密码
      new NewWD().init(nameText, zh);
    });

    // 组装视图
    Box bv1 = Box.createVerticalBox();
    bv1.add(btn1);
    bv1.add(btn2);

    Box bv2 = Box.createVerticalBox();
    bv2.add(btn3);
    bv2.add(btn4);

    jf.add(jl, BorderLayout.NORTH);
    jf.add(bv1, BorderLayout.WEST);
    jf.add(bv2, BorderLayout.EAST);
    jf.add(btn5, BorderLayout.SOUTH);
    jf.setBounds(new View().x(400), new View().y(150), 400, 150);  // 界面位置 大小
    jf.setVisible(true);  // 显示页面
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 可关闭
  }
}
