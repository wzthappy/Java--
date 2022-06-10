package Java作业.第八次作业.ATM取款机.管理员界面;

import Java作业.第八次作业.ATM取款机.工具类.Util_Class;
import Java作业.第八次作业.ATM取款机.用户和管理员对象.NameText;
import Java作业.第八次作业.ATM取款机.开始界面.View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/*
    TODO: 管理员界面
            :这里面有一个 bug
                点击 修改用户密码 按钮， 后必须在点击 查看所有用户信息 按钮 ， 这个按钮的效果才能体现
            :bug + 1 : 提示 "请输入正确的账号！“  不会解决
 */
public class Manager {
  JFrame jf;
  JButton btn1 = new JButton("查看所有用户信息");
  JButton btn2 = new JButton("修改用户密码");
  JTextArea jla = new JTextArea(50, 20);

  JLabel jl = new JLabel("");
  JTextField jtf = new JTextField(18);
  JButton btn3 = new JButton("确定");

  public void init(ArrayList<NameText> nameText, String zh) {  // nameText 为的所有人的信息
    jf = new JFrame("账号名为: " + zh + "------ 管理员账户");  // 标题

    // 坐标
    int x = new View().x(700);  // 调用 View 中的坐标方法
    int y = new View().y(700);

    // 点击事件
    btn1.addActionListener(i -> {  // 在 jla 中显示查看所有用户信息
      jla.setText("");   // 防止多次点击时，多次追加
      nameText.forEach(t -> jla.append(t.s() + "\n\r"));  // 因为代码体只有一条数据(简写)
    });

    btn2.addActionListener(i -> {  // 修改用户密码
      Box h = Box.createHorizontalBox();   // 点击后添加对应的组件
      jl.setText("请输入您要修改密码的账号: ");
      h.add(jl);
      h.add(jtf);
      h.add(btn3);
      jf.add(h, BorderLayout.SOUTH);
    });

    btn3.addActionListener(i -> {  // 点击了修改用户密码按钮  在确定
      String text = jtf.getText();
      nameText.forEach(t -> {
        if ("0".equals(t.id.trim())) {  // 拿到用户消息  去掉左右空格
          if (text.trim().equals(t.zhanghao.trim())) {  // 用户的账号与管理员输入的账号对比  去且掉左右空格
            // 放回的是管理员修改对应用户的密码   56行会堵塞
            String s = JOptionPane.showInputDialog(jf, "请输入修改的密码: ", "");
            // 那到修改的密码  s 和 账号  传入指定义  修改密码的方法  和 所有用户信息 nameText
            Util_Class.password(t.zhanghao, s, nameText);
          }
        } else {
          JOptionPane.showMessageDialog(jf, "请输入正确的账号！");
        }
      });
    });

    // 组装视图
    Box bh1 = Box.createHorizontalBox();
    bh1.add(btn1);
    bh1.add(btn2);

    jf.add(bh1, BorderLayout.NORTH);
    jf.add(jla);

    jf.setVisible(true); // 显示
    jf.setBounds(x, y, 700, 400); // 界面
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 可关闭窗口
  }
}
