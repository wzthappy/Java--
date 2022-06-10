package Java.综合案例.菜单;
//菜品
//提供有参的构造方法
public class Dish {
    //编号
    int id;
    //菜的名称
    String name;
    //价格
    double price;

    public Dish(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
