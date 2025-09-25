// 备忘录模式
// 备忘录
class Memento {
    private String state;
    
    public Memento(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
}

// 发起人
class Originator {
    private String state;
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return state;
    }
    
    public Memento createMemento() {
        return new Memento(state);
    }
    
    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
    }
}

// 管理者
class Caretaker {
    private Memento memento;
    
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
    
    public Memento getMemento() {
        return memento;
    }
}

// 使用备忘录模式
public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        
        // 设置状态并保存
        originator.setState("State 1");
        System.out.println("Current State: " + originator.getState());
        caretaker.setMemento(originator.createMemento());
        
        // 改变状态
        originator.setState("State 2");
        System.out.println("Current State: " + originator.getState());
        
        // 恢复状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("Restored State: " + originator.getState());
    }
}
