// 代理模式
// 抽象主题
interface Subject {
    void request();
}

// 真实主题
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject handling request");
    }
}

// 代理
class Proxy implements Subject {
    private RealSubject realSubject;
    
    @Override
    public void request() {
        // 在调用真实主题前的预处理
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        
        preRequest();
        realSubject.request();
        postRequest();
    }
    
    private void preRequest() {
        System.out.println("Proxy pre-processing");
    }
    
    private void postRequest() {
        System.out.println("Proxy post-processing");
    }
}

// 使用代理模式
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.request();
    }
}
