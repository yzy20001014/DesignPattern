// 访问者模式
import java.util.ArrayList;
import java.util.List;

// 抽象元素
interface Element {
    void accept(Visitor visitor);
}

// 具体元素1
class ConcreteElement1 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public String operation1() {
        return "ConcreteElement1";
    }
}

// 具体元素2
class ConcreteElement2 implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
    public String operation2() {
        return "ConcreteElement2";
    }
}

// 抽象访问者
interface Visitor {
    void visit(ConcreteElement1 element);
    void visit(ConcreteElement2 element);
}

// 具体访问者1
class ConcreteVisitor1 implements Visitor {
    @Override
    public void visit(ConcreteElement1 element) {
        System.out.println("ConcreteVisitor1 processing " + element.operation1());
    }
    
    @Override
    public void visit(ConcreteElement2 element) {
        System.out.println("ConcreteVisitor1 processing " + element.operation2());
    }
}

// 具体访问者2
class ConcreteVisitor2 implements Visitor {
    @Override
    public void visit(ConcreteElement1 element) {
        System.out.println("ConcreteVisitor2 processing " + element.operation1());
    }
    
    @Override
    public void visit(ConcreteElement2 element) {
        System.out.println("ConcreteVisitor2 processing " + element.operation2());
    }
}

// 对象结构
class ObjectStructure {
    private List<Element> elements = new ArrayList<>();
    
    public void addElement(Element element) {
        elements.add(element);
    }
    
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}

// 使用访问者模式
public class VisitorPatternDemo {
    public static void main(String[] args) {
        ObjectStructure structure = new ObjectStructure();
        structure.addElement(new ConcreteElement1());
        structure.addElement(new ConcreteElement2());
        
        Visitor visitor1 = new ConcreteVisitor1();
        structure.accept(visitor1);
        
        Visitor visitor2 = new ConcreteVisitor2();
        structure.accept(visitor2);
    }
}
