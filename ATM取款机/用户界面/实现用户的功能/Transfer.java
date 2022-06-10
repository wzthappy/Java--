package Java作业.第八次作业.ATM取款机.用户界面.实现用户的功能;

import Java作业.第八次作业.ATM取款机.工具类.Util_Class;
import Java作业.第八次作业.ATM取款机.开始界面.View;
import Java作业.第八次作业.ATM取款机.用户和管理员对象.NameText;

import javax.swing.*;
import java.awt.*;
import java.util.AbstractList;

/*
        TODO:  转账 界面
 */
public class Transfer {
  JFrame jf = new JFrame("转账时请认真核对，对应的用户信息");
  JLabel jl1 = new JLabel("您要转账的名称为: ***");
  JLabel jl = new JLabel("请输入您要转账的账号: ");
  JTextField jtf1 = new JTextField(15);
  JLabel jl2 = new JLabel("您要转账的金额为: ");
  JTextField jtf2 = new JTextField(4);
  JButton btn1 = new JButton("点击我查看您要转账人的名称");

  JButton btn = new JButton("请认真核对后在点击此按钮！");

  AbstractList<NameText> nameTexts;

  // 组装视图
  public void init(AbstractList<NameText> nameTexts, String zh) {
    this.nameTexts = nameTexts;
    // 点击事件
    btn1.addActionListener(i -> {  // 查看转账人的名称
      String s = jtf1.getText().trim();  // 转账人的账号
      System.out.println("11");
      nameTexts.forEach(c -> {
        if (c.zhanghao.trim().equals(s)) {  // 匹配
          jl1.setText("您要转账的名称为: " + c.name);  // 提示用户信息
        }
      });
    });

    btn.addActionListener(i -> {  // 转账实现
      int i1 = Integer.parseInt(jtf2.getText().trim());// 获取转账金额
      String s = jtf1.getText().trim();  // 转账人的账号
      nameTexts.forEach(a -> {
        if (a.zhanghao.trim().equals(zh.trim())) { // 进入自己的账号
          if (i1 < a.getJ()) {  // 比较转账金额和自己的金额
            try {
              a.setJ(a.getJ() - i1);  // 修改自己的金额
              nameTexts.forEach(c -> {
                if (c.zhanghao.trim().equals(s)) {
                  c.setJ(c.getJ() + i1);  // 添加转账对象的金额
                  JOptionPane.showMessageDialog(jf, "转账成功了");
                  Util_Class.flushed(nameTexts); // 更改数据
                }
              });
            } catch (Exception e) {  // 当转账时有错误数据回到刚开始
              Util_Class.flushed(this.nameTexts);  // 刷新数据
            }
          } else {
            JOptionPane.showMessageDialog(jf, "您的金额小于要转账的金额！ 可先充值 ^_^");
          }
        }
      });
    });

    // 组装
    Box bh1 = Box.createHorizontalBox();
    bh1.add(jl);
    bh1.add(jtf1);
    Box bh2 = Box.createHorizontalBox();
    bh2.add(jl2);
    bh2.add(jtf2);
    Box bv = Box.createVerticalBox();
    bv.add(bh1);
    bv.add(bh2);

    Box bh3 = Box.createVerticalBox();
    bh3.add(btn1);
    bh3.add(btn);

    jf.add(jl1, BorderLayout.NORTH);
    jf.add(bv, BorderLayout.CENTER);
    jf.add(bh3, BorderLayout.SOUTH);

    jf.setBounds(new View().x(400), new View().y(400), 400, 400);  // 大小和位置
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
