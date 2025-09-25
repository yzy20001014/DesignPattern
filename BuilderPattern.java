// 建造者模式
// 产品类
class Meal {
    private String food;
    private String drink;
    
    public void setFood(String food) {
        this.food = food;
    }
    
    public void setDrink(String drink) {
        this.drink = drink;
    }
    
    public String getFood() {
        return food;
    }
    
    public String getDrink() {
        return drink;
    }
}

// 抽象建造者
interface MealBuilder {
    void buildFood();
    void buildDrink();
    Meal getMeal();
}

// 具体建造者1
class BurgerMealBuilder implements MealBuilder {
    private Meal meal = new Meal();
    
    @Override
    public void buildFood() {
        meal.setFood("Burger");
    }
    
    @Override
    public void buildDrink() {
        meal.setDrink("Coke");
    }
    
    @Override
    public Meal getMeal() {
        return meal;
    }
}

// 具体建造者2
class PizzaMealBuilder implements MealBuilder {
    private Meal meal = new Meal();
    
    @Override
    public void buildFood() {
        meal.setFood("Pizza");
    }
    
    @Override
    public void buildDrink() {
        meal.setDrink("Juice");
    }
    
    @Override
    public Meal getMeal() {
        return meal;
    }
}

// 指挥者
class Waiter {
    private MealBuilder mealBuilder;
    
    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }
    
    public Meal getMeal() {
        return mealBuilder.getMeal();
    }
    
    public void constructMeal() {
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
    }
}

// 使用建造者模式
public class BuilderPatternDemo {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        
        MealBuilder burgerMealBuilder = new BurgerMealBuilder();
        waiter.setMealBuilder(burgerMealBuilder);
        waiter.constructMeal();
        
        Meal burgerMeal = waiter.getMeal();
        System.out.println("Burger Meal: " + burgerMeal.getFood() + " and " + burgerMeal.getDrink());
        
        MealBuilder pizzaMealBuilder = new PizzaMealBuilder();
        waiter.setMealBuilder(pizzaMealBuilder);
        waiter.constructMeal();
        
        Meal pizzaMeal = waiter.getMeal();
        System.out.println("Pizza Meal: " + pizzaMeal.getFood() + " and " + pizzaMeal.getDrink());
    }
}
