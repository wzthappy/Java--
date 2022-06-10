package Java作业.第八次作业.ATM取款机.用户界面.实现用户的功能;

import Java作业.第八次作业.ATM取款机.工具类.Util_Class;
import Java作业.第八次作业.ATM取款机.开始界面.View;
import Java作业.第八次作业.ATM取款机.用户和管理员对象.NameText;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
          TODO: 修改密码界面
 */
public class NewWD {
  JFrame jf = new JFrame("修改自己的密码");
  JLabel jl = new JLabel("请输入修改的密码: ");
  JTextField jtf = new JTextField(15);
  JButton btn = new JButton("确定");

  // 组装视图
  public void init (ArrayList<NameText> nameTexts, String zh) {
    btn.addActionListener(i -> {
      String pw = jtf.getText().trim();  // 获取修改的密码
      Util_Class.password(zh, pw, nameTexts);  // 调用自己封装的  修改密码的方法
      JOptionPane.showMessageDialog(jf, "修改成功！");
    });

    // 组装
    jf.add(jl, BorderLayout.NORTH);
    jf.add(jtf, BorderLayout.CENTER);
    jf.add(btn, BorderLayout.SOUTH);

    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setBounds(new View().x(200), new View().y(100), 200,100);
  }
}
