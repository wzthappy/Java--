package Java作业.第八次作业.ATM取款机.用户界面.实现用户的功能;

import Java作业.第八次作业.ATM取款机.工具类.Util_Class;
import Java作业.第八次作业.ATM取款机.开始界面.View;
import Java作业.第八次作业.ATM取款机.用户和管理员对象.NameText;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/*
          TODO: 存钱界面
 */
public class Deposit {
  JFrame jf = new JFrame("存钱界面");
  JLabel jl = new JLabel("请输入存入的金额: ");
  JTextField jtf = new JTextField(5);
  JButton btn = new JButton("确定");

  // 组装视图
  public void init(ArrayList<NameText> nameTexts, String zh, String s) {
    btn.addActionListener(i -> {
      int i1 = Integer.parseInt(jtf.getText().trim());  // 获取要存入的数额
      nameTexts.forEach(a -> {
        if (zh.trim().equals(a.zhanghao.trim())) {   // 匹配对应的账号
          a.setJ(a.getJ() + i1);  // 修改对应的金额
          Util_Class.flushed(nameTexts);  // 更改数据
          JOptionPane.showMessageDialog(jf, s);
        }
      });
    });

    // 组装
    jf.add(jl, BorderLayout.NORTH);
    jf.add(jtf, BorderLayout.CENTER);
    jf.add(btn, BorderLayout.SOUTH);

    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.setBounds(new View().x(250), new View().y(100), 250, 100);
  }
}
