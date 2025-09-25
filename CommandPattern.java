// 命令模式
// 命令接口
interface Command {
    void execute();
}

// 接收者
class Receiver {
    public void action() {
        System.out.println("Receiver action");
    }
}

// 具体命令
class ConcreteCommand implements Command {
    private Receiver receiver;
    
    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }
    
    @Override
    public void execute() {
        receiver.action();
    }
}

// 调用者
class Invoker {
    private Command command;
    
    public void setCommand(Command command) {
        this.command = command;
    }
    
    public void executeCommand() {
        command.execute();
    }
}

// 使用命令模式
public class CommandPatternDemo {
    public static void main(String[] args) {
        // 创建接收者
        Receiver receiver = new Receiver();
        
        // 创建命令，并设置接收者
        Command command = new ConcreteCommand(receiver);
        
        // 创建调用者，设置命令
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        
        // 执行命令
        invoker.executeCommand();
    }
}
