// 观察者模式
import java.util.ArrayList;
import java.util.List;

// 抽象主题
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 抽象观察者
interface Observer {
    void update(String message);
}

// 具体主题
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String message;
    
    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// 具体观察者1
class ConcreteObserver1 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ConcreteObserver1 received: " + message);
    }
}

// 具体观察者2
class ConcreteObserver2 implements Observer {
    @Override
    public void update(String message) {
        System.out.println("ConcreteObserver2 received: " + message);
    }
}

// 使用观察者模式
public class ObserverPatternDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();
        
        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        
        subject.setMessage("Hello, Observers!");
        
        subject.removeObserver(observer1);
        subject.setMessage("Second message");
    }
}
