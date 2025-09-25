// 抽象工厂模式
// 抽象产品A
interface Color {
    void fill();
}

// 抽象产品B
interface Shape {
    void draw();
}

// 具体产品A1
class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with Red");
    }
}

// 具体产品A2
class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Filling with Blue");
    }
}

// 具体产品B1
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

// 具体产品B2
class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing Triangle");
    }
}

// 抽象工厂
interface AbstractFactory {
    Color getColor(String color);
    Shape getShape(String shape);
}

// 具体工厂1 - 生产形状
class ShapeFactory implements AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }
    
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
            return new Triangle();
        }
        return null;
    }
}

// 具体工厂2 - 生产颜色
class ColorFactory implements AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (color.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
    
    @Override
    public Shape getShape(String shape) {
        return null;
    }
}

// 工厂生产者
class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}

// 使用抽象工厂
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        // 获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        
        // 获取形状为Square的对象
        Shape shape1 = shapeFactory.getShape("SQUARE");
        shape1.draw();
        
        // 获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        
        // 获取颜色为Red的对象
        Color color1 = colorFactory.getColor("RED");
        color1.fill();
    }
}
