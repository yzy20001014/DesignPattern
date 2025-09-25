// 装饰器模式
// 抽象构件
interface Component {
    void operation();
}

// 具体构件
class ConcreteComponent implements Component {
    @Override
    public void operation() {
        System.out.println("ConcreteComponent operation");
    }
}

// 装饰类
abstract class Decorator implements Component {
    protected Component component;
    
    public Decorator(Component component) {
        this.component = component;
    }
    
    @Override
    public void operation() {
        component.operation();
    }
}

// 具体装饰类A
class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    
    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }
    
    private void addBehavior() {
        System.out.println("ConcreteDecoratorA added behavior");
    }
}

// 具体装饰类B
class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }
    
    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }
    
    private void addBehavior() {
        System.out.println("ConcreteDecoratorB added behavior");
    }
}

// 使用装饰器模式
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        
        // 装饰组件
        Component decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operation();
        
        // 多层装饰
        Component decoratorB = new ConcreteDecoratorB(decoratorA);
        decoratorB.operation();
    }
}
