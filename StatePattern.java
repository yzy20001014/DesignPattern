// 状态模式
// 状态接口
interface State {
    void handle(Context context);
}

// 具体状态1
class ConcreteState1 implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteState1 handling");
        context.setState(new ConcreteState2());
    }
}

// 具体状态2
class ConcreteState2 implements State {
    @Override
    public void handle(Context context) {
        System.out.println("ConcreteState2 handling");
        context.setState(new ConcreteState1());
    }
}

// 上下文
class Context {
    private State state;
    
    public Context() {
        state = new ConcreteState1();
    }
    
    public void setState(State state) {
        this.state = state;
    }
    
    public void request() {
        state.handle(this);
    }
}

// 使用状态模式
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        
        context.request(); // 处于状态1
        context.request(); // 转换到状态2
        context.request(); // 转换回状态1
    }
}
