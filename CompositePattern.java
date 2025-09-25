// 组合模式
import java.util.ArrayList;
import java.util.List;

// 抽象构件
interface Component {
    void operation();
    void add(Component component);
    void remove(Component component);
    Component getChild(int index);
}

// 叶子构件
class Leaf implements Component {
    private String name;
    
    public Leaf(String name) {
        this.name = name;
    }
    
    @Override
    public void operation() {
        System.out.println("Leaf " + name + " operation");
    }
    
    @Override
    public void add(Component component) {
        // 叶子节点不能添加子节点
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void remove(Component component) {
        // 叶子节点没有子节点可以移除
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Component getChild(int index) {
        // 叶子节点没有子节点
        throw new UnsupportedOperationException();
    }
}

// 容器构件
class Composite implements Component {
    private String name;
    private List<Component> children = new ArrayList<>();
    
    public Composite(String name) {
        this.name = name;
    }
    
    @Override
    public void operation() {
        System.out.println("Composite " + name + " operation");
        // 递归调用子构件的操作
        for (Component child : children) {
            child.operation();
        }
    }
    
    @Override
    public void add(Component component) {
        children.add(component);
    }
    
    @Override
    public void remove(Component component) {
        children.remove(component);
    }
    
    @Override
    public Component getChild(int index) {
        return children.get(index);
    }
}

// 使用组合模式
public class CompositePatternDemo {
    public static void main(String[] args) {
        // 创建叶子节点
        Component leaf1 = new Leaf("1");
        Component leaf2 = new Leaf("2");
        Component leaf3 = new Leaf("3");
        
        // 创建容器节点
        Composite composite1 = new Composite("1");
        Composite composite2 = new Composite("2");
        
        // 构建树形结构
        composite1.add(leaf1);
        composite1.add(leaf2);
        
        composite2.add(composite1);
        composite2.add(leaf3);
        
        // 调用根节点的操作
        composite2.operation();
    }
}
