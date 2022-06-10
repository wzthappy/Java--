package Java作业.第八次作业.ATM取款机.账号类型判断;

import Java作业.第八次作业.ATM取款机.开始界面.View;
import Java作业.第八次作业.ATM取款机.用户界面.User;
import Java作业.第八次作业.ATM取款机.管理员界面.Manager;
import Java作业.第八次作业.ATM取款机.用户和管理员对象.NameText;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/*
     TODO: 账号类型  登录
 */
public class Accout {
  // 进入类  保存所有用户和管理员数据到集合中
  static ArrayList<NameText> nameText = new ArrayList<NameText>();

  static {
    try {
      BufferedReader br = new BufferedReader(new FileReader("src/Java作业/第八次作业/ATM取款机/account.txt"));
      String s;
      while ((s = br.readLine()) != null) {  // 取出文档中所以内容 存入到集合中
        String[] split = s.split(",");
        NameText nt = new NameText(split[0], split[1], Integer.parseInt(split[2]), split[3], split[4]);  // 初始化信息对象
        nameText.add(nt);   // 存入到集合种
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 账号类型判断  和对应处理
  public void ifZhangHao(String id,String ...z) {  // z[0] 为账号信息      z[1] 为密码
    this.nameText.forEach(i -> {   // 拿到所以信息
      if ("1".equals(i.id) && "1".equals(id.trim())) {  // 只拿到信息为Id1的  管理员信息
        if (i.zhanghao.equals(z[0])) {  // 如果账号输入正确  就打开管理员视图
          new View().jf.setVisible(false);  // 关闭主页
          new Manager().init(nameText, z[0]);   // 打开管理员页面
        } else {
          JOptionPane.showMessageDialog(new View().jf, "账号输入错误，请重新输入！");
        }
      } else {  // 否则为用户账号
        if (z[0].trim().equals(i.zhanghao.trim()) && z[1].trim().equals(i.getPW().trim())) {  // 当账号和密码同时正确时 登录成功
          new View().jf.setVisible(false);  // 关闭主页
          new User().init(nameText, z[0]);   // 打开用户页面
        }
      }
    });
  }

  // 管理员账户
  public void manager(String id,String z) {
    ifZhangHao(id, z);  // 调用账号处理函数
  }

  // 用户账户
  public void user(String id,String z, String m) {
    ifZhangHao(id, z, m);  // 调用账号处理函数
  }
}
