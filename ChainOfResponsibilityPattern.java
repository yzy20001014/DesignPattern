// 责任链模式
// 抽象处理者
abstract class Handler {
    protected Handler successor;
    
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    
    public abstract void handleRequest(int request);
}

// 具体处理者1
class ConcreteHandler1 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.println("ConcreteHandler1 handled request: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// 具体处理者2
class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("ConcreteHandler2 handled request: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// 具体处理者3
class ConcreteHandler3 extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.println("ConcreteHandler3 handled request: " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

// 使用责任链模式
public class ChainOfResponsibilityPatternDemo {
    public static void main(String[] args) {
        // 创建处理者
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        
        // 设置责任链
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        
        // 测试请求
        int[] requests = {5, 12, 25, 30};
        for (int request : requests) {
            handler1.handleRequest(request);
        }
    }
}
