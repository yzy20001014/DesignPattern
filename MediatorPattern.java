// 中介者模式
import java.util.ArrayList;
import java.util.List;

// 抽象中介者
interface Mediator {
    void register(Colleague colleague);
    void relay(Colleague colleague, String message);
}

// 抽象同事类
abstract class Colleague {
    protected Mediator mediator;
    
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
    
    public abstract void receive(String message);
    public abstract void send(String message);
}

// 具体中介者
class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();
    
    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
        }
    }
    
    @Override
    public void relay(Colleague colleague, String message) {
        for (Colleague c : colleagues) {
            if (!c.equals(colleague)) {
                c.receive(message);
            }
        }
    }
}

// 具体同事类1
class ConcreteColleague1 extends Colleague {
    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }
    
    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague1 received: " + message);
    }
    
    @Override
    public void send(String message) {
        System.out.println("ConcreteColleague1 sends: " + message);
        mediator.relay(this, message);
    }
}

// 具体同事类2
class ConcreteColleague2 extends Colleague {
    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }
    
    @Override
    public void receive(String message) {
        System.out.println("ConcreteColleague2 received: " + message);
    }
    
    @Override
    public void send(String message) {
        System.out.println("ConcreteColleague2 sends: " + message);
        mediator.relay(this, message);
    }
}

// 使用中介者模式
public class MediatorPatternDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        
        Colleague colleague1 = new ConcreteColleague1(mediator);
        Colleague colleague2 = new ConcreteColleague2(mediator);
        
        mediator.register(colleague1);
        mediator.register(colleague2);
        
        colleague1.send("Hello from Colleague 1");
        colleague2.send("Hi from Colleague 2");
    }
}
