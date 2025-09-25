// 原型模式
import java.util.Hashtable;

// 原型接口
interface Prototype {
    Prototype clone();
    void show();
}

// 具体原型1
class ConcretePrototype1 implements Prototype {
    private String name;
    
    public ConcretePrototype1(String name) {
        this.name = name;
    }
    
    @Override
    public Prototype clone() {
        return new ConcretePrototype1(this.name);
    }
    
    @Override
    public void show() {
        System.out.println("ConcretePrototype1: " + name);
    }
}

// 具体原型2
class ConcretePrototype2 implements Prototype {
    private String id;
    
    public ConcretePrototype2(String id) {
        this.id = id;
    }
    
    @Override
    public Prototype clone() {
        return new ConcretePrototype2(this.id);
    }
    
    @Override
    public void show() {
        System.out.println("ConcretePrototype2: " + id);
    }
}

// 原型管理器
class PrototypeManager {
    private Hashtable<String, Prototype> prototypes = new Hashtable<>();
    
    public PrototypeManager() {
        prototypes.put("p1", new ConcretePrototype1("Prototype 1"));
        prototypes.put("p2", new ConcretePrototype2("Prototype 2"));
    }
    
    public void addPrototype(String key, Prototype prototype) {
        prototypes.put(key, prototype);
    }
    
    public Prototype getPrototype(String key) {
        return prototypes.get(key).clone();
    }
}

// 使用原型模式
public class PrototypePatternDemo {
    public static void main(String[] args) {
        PrototypeManager manager = new PrototypeManager();
        
        Prototype p1 = manager.getPrototype("p1");
        p1.show();
        
        Prototype p2 = manager.getPrototype("p2");
        p2.show();
    }
}
