package Java作业.第八次作业.ATM取款机;

import Java作业.第八次作业.ATM取款机.开始界面.View;

/*
        TODO: 入口
            重复代码很多不想处理了  ^_^
              * 此程序因有很多因素会影响金额的不安全   请到官网下载
 */
public class Test {
  public static void main(String[] args) {
    try {
      new View().init();
    } catch (Exception e) {
      System.out.println("程序报错了！ 请处理");
    }
  }
}
