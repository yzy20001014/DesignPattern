// 解释器模式
import java.util.HashMap;
import java.util.Map;

// 抽象表达式
interface Expression {
    int interpret(Map<String, Integer> context);
}

// 终结符表达式 - 变量
class Variable implements Expression {
    private String name;
    
    public Variable(String name) {
        this.name = name;
    }
    
    @Override
    public int interpret(Map<String, Integer> context) {
        return context.get(name);
    }
}

// 终结符表达式 - 常量
class Constant implements Expression {
    private int value;
    
    public Constant(int value) {
        this.value = value;
    }
    
    @Override
    public int interpret(Map<String, Integer> context) {
        return value;
    }
}

// 非终结符表达式 - 加法
class Add implements Expression {
    private Expression left;
    private Expression right;
    
    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int interpret(Map<String, Integer> context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// 非终结符表达式 - 乘法
class Multiply implements Expression {
    private Expression left;
    private Expression right;
    
    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public int interpret(Map<String, Integer> context) {
        return left.interpret(context) * right.interpret(context);
    }
}

// 使用解释器模式
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        // 创建上下文
        Map<String, Integer> context = new HashMap<>();
        context.put("a", 5);
        context.put("b", 10);
        
        // 构建表达式: a + b * 2
        Expression expression = new Add(
            new Variable("a"),
            new Multiply(new Variable("b"), new Constant(2))
        );
        
        // 解释表达式
        int result = expression.interpret(context);
        System.out.println("Result: " + result); // 输出 25
    }
}
