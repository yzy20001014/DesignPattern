// 适配器模式
// 目标接口
interface Target {
    void request();
}

// 适配者
class Adaptee {
    public void specificRequest() {
        System.out.println("Adaptee's specific request");
    }
}

// 类适配器
class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        specificRequest();
    }
}

// 对象适配器
class ObjectAdapter implements Target {
    private Adaptee adaptee;
    
    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// 使用适配器模式
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // 类适配器
        Target classAdapter = new ClassAdapter();
        classAdapter.request();
        
        // 对象适配器
        Adaptee adaptee = new Adaptee();
        Target objectAdapter = new ObjectAdapter(adaptee);
        objectAdapter.request();
    }
}
