// 外观模式
// 子系统1
class SubSystemOne {
    public void methodOne() {
        System.out.println("SubSystemOne method");
    }
}

// 子系统2
class SubSystemTwo {
    public void methodTwo() {
        System.out.println("SubSystemTwo method");
    }
}

// 子系统3
class SubSystemThree {
    public void methodThree() {
        System.out.println("SubSystemThree method");
    }
}

// 外观类
class Facade {
    private SubSystemOne one;
    private SubSystemTwo two;
    private SubSystemThree three;
    
    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
    }
    
    public void methodA() {
        System.out.println("MethodA:");
        one.methodOne();
        two.methodTwo();
    }
    
    public void methodB() {
        System.out.println("MethodB:");
        two.methodTwo();
        three.methodThree();
    }
}

// 使用外观模式
public class FacadePatternDemo {
    public static void main(String[] args) {
        Facade facade = new Facade();
        
        facade.methodA();
        facade.methodB();
    }
}
