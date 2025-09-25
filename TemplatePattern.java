// 模板方法模式
// 抽象类
abstract class AbstractClass {
    // 模板方法
    public final void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        concreteOperation();
        hook();
    }
    
    // 抽象方法1
    protected abstract void primitiveOperation1();
    
    // 抽象方法2
    protected abstract void primitiveOperation2();
    
    // 具体方法
    private void concreteOperation() {
        System.out.println("AbstractClass's concrete operation");
    }
    
    // 钩子方法
    protected void hook() {}
}

// 具体子类1
class ConcreteClass1 extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClass1's operation1");
    }
    
    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClass1's operation2");
    }
}

// 具体子类2
class ConcreteClass2 extends AbstractClass {
    @Override
    protected void primitiveOperation1() {
        System.out.println("ConcreteClass2's operation1");
    }
    
    @Override
    protected void primitiveOperation2() {
        System.out.println("ConcreteClass2's operation2");
    }
    
    @Override
    protected void hook() {
        System.out.println("ConcreteClass2's hook");
    }
}

// 使用模板方法模式
public class TemplatePatternDemo {
    public static void main(String[] args) {
        AbstractClass class1 = new ConcreteClass1();
        class1.templateMethod();
        
        System.out.println();
        
        AbstractClass class2 = new ConcreteClass2();
        class2.templateMethod();
    }
}
