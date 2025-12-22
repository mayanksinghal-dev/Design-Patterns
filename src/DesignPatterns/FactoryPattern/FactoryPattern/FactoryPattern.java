package DesignPatterns.FactoryPattern.FactoryPattern;

/**
 * Factory Method Pattern
 * A GoF creational pattern where a base class declares a method for creating a product, and subclasses override that method to instantiate specific concrete products.

 * The client relies only on the abstract product type and interacts with the factory instead of constructing products directly.
 * This isolates product creation so product variations or changes affect only the factory code, not the client code.
 */
abstract class Food{
    abstract void prepare();
}
class Burger extends Food{
    @Override
    void prepare(){
        System.out.println("Burger preparing");
    }
}

class Pizza extends Food{
    @Override
    void prepare(){
        System.out.println("Pizza preparing");
    }
}

//New food item
class Paneer extends Food{
    @Override
    void prepare(){
        System.out.println("Paneer Preparing");
    }
}

abstract class FoodFactory{
    abstract Food create();
}

class BurgerFactory extends FoodFactory{
    @Override
    Food create(){
        return new Burger();
    }
}

class PizzaFactory extends FoodFactory{
    @Override
    Food create(){
        return new Pizza();
    }
}

//Create factory of new food i.e. Paneer
class PaneerFactory extends FoodFactory{
    @Override
    Food create(){
        return new Paneer();
    }
}

class Factories{
    protected FoodFactory hungry(String type){
            return switch (type){
                case "pizza" -> new PizzaFactory();
                case "burger" -> new BurgerFactory();
                case "paneer" -> new PaneerFactory();
                default -> null;
            };
    }
}
public class FactoryPattern {
    public static void main(String[] args){
        Factories fact = new Factories();
        FoodFactory f1 = fact.hungry("pizza");
        FoodFactory f2 = fact.hungry("paneer");
        FoodFactory f3 = fact.hungry("chicken");
        if(f1 != null){
            f1.create().prepare();
        }
        if(f2 != null){
            f2.create().prepare();
        }
        if(f3 != null){
            f3.create().prepare();
        }
    }
}
