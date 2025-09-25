// 单例模式 - 饿汉式
public class Singleton {
    // 私有静态实例，直接初始化
    private static final Singleton instance = new Singleton();
    
    // 私有构造方法，防止外部实例化
    private Singleton() {}
    
    // 公共静态方法，返回唯一实例
    public static Singleton getInstance() {
        return instance;
    }
    
    public void showMessage() {
        System.out.println("Hello, Singleton Pattern!");
    }
}
