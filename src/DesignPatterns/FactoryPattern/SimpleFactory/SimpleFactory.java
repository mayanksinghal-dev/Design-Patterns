package DesignPatterns.FactoryPattern.SimpleFactory;

//A factory class that decides which concrete class to instantiate
abstract class Burger{
    abstract void prepare();
}

class BasicBurger extends Burger{
    @Override
    void prepare(){
        System.out.println("Basic Burger");
    }
}

class StandardBurger extends Burger{
    @Override
    void prepare(){
        System.out.println("Standard Burger");
    }
}

class AmericanBurger extends Burger{
    @Override
    void prepare(){
        System.out.println("American Burger");
    }
}

class BurgerFactory{
    Burger createBurger(String type){
        return switch (type) {
            case "standard" -> new StandardBurger();
            case "american" -> new AmericanBurger();
            default -> new BasicBurger();
        };
    }
}
public class SimpleFactory {
    public static void main(String[] args){
        BurgerFactory bf = new BurgerFactory();
        bf.createBurger("standard").prepare();
        bf.createBurger("american").prepare();
    }
}
