// 享元模式
import java.util.HashMap;
import java.util.Map;

// 享元接口
interface Flyweight {
    void operation(String extrinsicState);
}

// 具体享元
class ConcreteFlyweight implements Flyweight {
    private String intrinsicState;
    
    public ConcreteFlyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }
    
    @Override
    public void operation(String extrinsicState) {
        System.out.println("Intrinsic State: " + intrinsicState + 
                           ", Extrinsic State: " + extrinsicState);
    }
}

// 享元工厂
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();
    
    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
    
    public int getFlyweightCount() {
        return flyweights.size();
    }
}

// 使用享元模式
public class FlyweightPatternDemo {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        
        Flyweight flyweight1 = factory.getFlyweight("A");
        flyweight1.operation("First");
        
        Flyweight flyweight2 = factory.getFlyweight("A");
        flyweight2.operation("Second");
        
        Flyweight flyweight3 = factory.getFlyweight("B");
        flyweight3.operation("Third");
        
        System.out.println("Total flyweights: " + factory.getFlyweightCount());
    }
}
