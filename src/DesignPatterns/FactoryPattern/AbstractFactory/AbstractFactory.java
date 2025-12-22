package DesignPatterns.FactoryPattern.AbstractFactory;

import java.util.Scanner;

/**
 * Abstract Factory Pattern
 * A creational design pattern that provides an interface for creating a family of related or dependent products without specifying their concrete classes.

 * A single concrete factory creates all the products belonging to one family, and each product does not require its own separate factory class.
 * The client works only with the factory interface, ensuring that product variants remain consistent and interchangeable.
 */

abstract class Button{
    abstract void button();
}

abstract class Cursor{
    abstract void cursor();
}

class MacButton extends Button{
    void button(){
        System.out.println("Mac Button created");
    }
}
class WindowsButton extends Button{
    void button(){
        System.out.println("Windows Button created");
    }
}
class MacCursor extends Cursor{
    void cursor(){
        System.out.println("Mac Cursor created");
    }
}
class WindowsCursor extends Cursor{
    void cursor(){
        System.out.println("Windows Cursor created");
    }
}

abstract class Laptop{
    void assemble(){
        this.createButton().button();
        this.createCursor().cursor();
        System.out.println("Laptop assembled");
    };
    abstract Button createButton();
    abstract Cursor createCursor();
}

class Window extends Laptop{

    Button createButton(){
        return new WindowsButton();
    }
    Cursor createCursor(){
        return new WindowsCursor();
    }
}
class Mac extends Laptop{
    Button createButton(){
        return new MacButton();
    }
    Cursor createCursor(){
        return new MacCursor();
    }
}
class LaptopFactory{
    protected Laptop createLaptop(String type){
        return switch (type){
            case "window" -> new Window();
            case "mac" -> new Mac();
            default -> null;
        };
    }
}
public class AbstractFactory {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you need laptop?");
        String laptop = sc.next();
        System.out.println("Which laptop?");
        String model = sc.next();
        if(laptop.equals("Yes")){
            LaptopFactory ft = new LaptopFactory();
            Laptop lappy = ft.createLaptop(model);
            System.out.println("Assembled?");
            String assembled = sc.next();
            if(lappy != null && assembled.equals("Yes")) {
                lappy.assemble();
            }
        }
    }
}
