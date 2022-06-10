package Java作业.第八次作业.ATM取款机.工具类;

import Java作业.第八次作业.ATM取款机.用户和管理员对象.NameText;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;

/*
        TODO:  自定义工具类   可能多次使用
 */
public class Util_Class {
  private Util_Class() {
  }  // 私有构造

  // TODO:  对应的修改密码   接收  账号 和 修改的密码
  public static void password(String zhangHao, String pw, ArrayList<NameText> nameTexts) {
    nameTexts.forEach(i -> {
      if (zhangHao.trim().equals(i.zhanghao.trim())) {  // 找到匹配的账号
        i.setNewPW(pw);  // 修改对应集合对象中的密码
      }
    });
    // 把集合中的内容重新渲染到 account.txt 文档中
    try {
      // 清除文档内容
      BufferedWriter el = new BufferedWriter(new FileWriter("src/Java作业/第八次作业/ATM取款机/account.txt"));
      el.write("");

      // 通过字符流修改文档中的内容
      BufferedWriter bw = new BufferedWriter(new FileWriter("src/Java作业/第八次作业/ATM取款机/account.txt", true));
      nameTexts.forEach(i -> {
        try {
          bw.write(i.wd());  // 添加数据
          bw.newLine();   // 换行
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      bw.flush(); // 刷新流
      bw.close(); // 关闭流
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // TODO: 更新数据
  public static void flushed(AbstractList<NameText> nameTexts) {
    try {
      // 清除文档内容
      BufferedWriter el = new BufferedWriter(new FileWriter("src/Java作业/第八次作业/ATM取款机/account.txt"));
      el.write("");

      // 通过字符流修改文档中的内容
      BufferedWriter bw = new BufferedWriter(new FileWriter("src/Java作业/第八次作业/ATM取款机/account.txt", true));
      nameTexts.forEach(i -> {
        try {
          bw.write(i.wd());  // 添加数据
          bw.newLine();   // 换行
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
      bw.flush(); // 刷新流
      bw.close(); // 关闭流
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

//  // TODO: 返回  除了自己和管理员对象
//  public static ArrayList<NameText> noX(AbstractList<NameText> nameTexts, String zh) {
//    ArrayList<NameText> nameTexts1 = new ArrayList<NameText>();
//    nameTexts.forEach(i -> {
//      if ("0".equals(i.id.trim()) && zh != i.zhanghao) {
//        nameTexts.add(i);
//      }
//    });
//    return nameTexts1;
//  }
//
//  // TODO: 返回  自己和管理员对象
//  public static ArrayList<NameText> noY(ArrayList<NameText> nameTexts, String zh) {
//    ArrayList<NameText> nameTexts1 = new ArrayList<NameText>();
//    nameTexts.forEach(i -> {
//      if ("1".equals(i.id.trim()) || zh == i.zhanghao) {
//        nameTexts.add(i);
//      }
//    });
//    return nameTexts1;
//  }

//  // TODO: 返回  自己对象
//  public static ArrayList<NameText> ziJi(AbstractList<NameText> nameTexts, String zh) {
//    ArrayList<NameText> nameTexts1 = new ArrayList<NameText>();
//    nameTexts.forEach(i -> {
//      if (zh == i.zhanghao) {
//        nameTexts.add(i);
//      }
//    });
//    return nameTexts1;
//  }
}
