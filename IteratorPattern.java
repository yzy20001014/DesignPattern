// 迭代器模式
import java.util.ArrayList;
import java.util.List;

// 迭代器接口
interface Iterator {
    boolean hasNext();
    Object next();
}

// 聚合接口
interface Aggregate {
    Iterator createIterator();
}

// 具体迭代器
class ConcreteIterator implements Iterator {
    private List<Object> items;
    private int position = 0;
    
    public ConcreteIterator(List<Object> items) {
        this.items = items;
    }
    
    @Override
    public boolean hasNext() {
        return position < items.size();
    }
    
    @Override
    public Object next() {
        if (this.hasNext()) {
            return items.get(position++);
        }
        return null;
    }
}

// 具体聚合
class ConcreteAggregate implements Aggregate {
    private List<Object> items = new ArrayList<>();
    
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
    
    public void add(Object item) {
        items.add(item);
    }
}

// 使用迭代器模式
public class IteratorPatternDemo {
    public static void main(String[] args) {
        ConcreteAggregate aggregate = new ConcreteAggregate();
        aggregate.add("Item 1");
        aggregate.add("Item 2");
        aggregate.add("Item 3");
        
        Iterator iterator = aggregate.createIterator();
        
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
