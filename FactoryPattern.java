// 工厂模式
// 产品接口
interface Shape {
    void draw();
}

// 具体产品
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// 工厂类
class ShapeFactory {
    // 使用getShape方法获取形状类型的对象
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }
}

// 使用工厂
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        
        // 获取Circle的对象，并调用它的draw方法
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        
        // 获取Rectangle的对象，并调用它的draw方法
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();
    }
}
