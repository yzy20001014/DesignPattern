// 桥接模式
// 实现接口
interface Implementor {
    void operationImpl();
}

// 具体实现A
class ConcreteImplementorA implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorA operation");
    }
}

// 具体实现B
class ConcreteImplementorB implements Implementor {
    @Override
    public void operationImpl() {
        System.out.println("ConcreteImplementorB operation");
    }
}

// 抽象类
abstract class Abstraction {
    protected Implementor implementor;
    
    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }
    
    public abstract void operation();
}

// 扩展抽象类
class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }
    
    @Override
    public void operation() {
        implementor.operationImpl();
    }
}

// 使用桥接模式
public class BridgePatternDemo {
    public static void main(String[] args) {
        Implementor implA = new ConcreteImplementorA();
        Abstraction abstractionA = new RefinedAbstraction(implA);
        abstractionA.operation();
        
        Implementor implB = new ConcreteImplementorB();
        Abstraction abstractionB = new RefinedAbstraction(implB);
        abstractionB.operation();
    }
}
