package Java作业.第八次作业.ATM取款机.用户和管理员对象;

/*
    TODO: 用户和管理员信息
 */
public class NameText {
  public String name;   // 名称
  public String zhanghao;  // 账号
  private int j;   // 金额
  private String pw;  // 密码
  public String id;  // 权限

  public NameText(String name, String zhanghao, int j, String pw, String id) {  // 初始化构造
    this.name = name;
    this.zhanghao = zhanghao;
    this.j = j;
    this.pw = pw;
    this.id = id;
  }

  // 返回金额
  public int getJ () {
    return this.j;
  }

  // 修改金额
  public void setJ(int j) {
    this.j = j;
  }

  // 修改密码的方法
  public void setNewPW(String pw) {
    this.pw = pw;
  }

  // 获取密码的方法
  public String getPW() {
    return this.pw;
  }

  // 返回拼接好的字符串
  public String s() {
    return "名称: " + this.name + "，账号: " + this.zhanghao + "，金额: " + j + "，密码: "
            + this.pw + "，权限" + this.id;
  }

  // 放回文档的格式的字符串
  public String wd() {
    return this.name + "," + this.zhanghao + "," + this.j + "," + this.pw + "," + this.id;
  }
}
