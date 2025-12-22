package DesignPatterns.DecoratorPattern;

/**
 * This is a pattern we use to provide additional runtime functionalities to our object dynamically. Decorator wraps an object and adds behaviour while keeping the same interface.
 * It leads to add infinite behaviours to core object.
 *-
 *Decorator combines inheritance (to preserve interface compatibility) and composition (to delegate and extend behavior)
 * so that responsibilities can be added dynamically and combinatorially at runtime.
 */

interface Coffee{
    double cost();
}

class SimpleCoffee implements Coffee{
    public double cost(){
        return 10;
    }
}

class MilkCoffee implements Coffee{
    private final Coffee coffee;
    MilkCoffee(Coffee coffee){
        this.coffee = coffee;
    }
    public double cost(){
        return coffee.cost() + 20;
    }
}

class SugarCoffee implements Coffee{
    private final Coffee coffee;
    SugarCoffee(Coffee coffee){
        this.coffee = coffee;
    }
    public double cost(){
        return coffee.cost() + 30;
    }
}
public class DecoratorPattern {
    public static void main(String[] args){
        Coffee cd= new SugarCoffee(new MilkCoffee(new SimpleCoffee()));
        System.out.println(cd.cost());
    }
}
