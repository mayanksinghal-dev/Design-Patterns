//Defines a family of algorithm and put them into separate classes so that they can be changed at runtime
/**
 * Core difference between Factory and strategy pattern.
 * <p>
 * Factory Pattern - Some predefined classes are allocated to the factory class and you call to factory class and its method to create an object of a class
 * against the key you will provide and return the object.
 * Problem here is each class is pre-defined with some set of behaviours and you may need to introduce different class for different behaviours.
 * <p>
 * Solution is strategy pattern, which basically says that you create separate class of each behaviour.
 * Then make a simple class which just accepts all those behaviours in its constructor. So you just create an object of that class and provide all your required behaviour.
 * It is basically used when there's multiple behaviours of a class and behaviours are allotted to class at runtime.
 */

/**
 * In strategy, we take assumption that class will have constant number of operations like fly, Talk, walk but there behaviours may change like fly like jet, fly like bird.
 * If we have inconsistent number of operations, but behaviours will remain same then prefer visitor design pattern.
 */
package DesignPatterns.StrategyPattern;
//All behaviours are separated out in interfaces.
interface Walk{
    void walk();
}
interface Talk{
    void talk();
}
interface Fly{
    void fly();
}

class Robot{
    Walk w;
    Talk t;
    Fly f;

    Robot(Walk w, Talk t, Fly f) {
        this.w = w;
        this.t = t;
        this.f = f;
    }

    void act() {
        w.walk();
        t.talk();
        f.fly();
    }
}

class Walkable implements Walk{
    public void walk() {
        System.out.println("walking");
    }
}

class Talkable implements Talk{
    public void talk() {
        System.out.println("Talking");
    }
}

class Flyable implements Fly{
    public void fly() {
        System.out.println("Flying");
    }
}
class NoWalkable implements Walk{
    public void walk() {
        System.out.println("No walking");
    }
}

class NoTalkable implements Talk {
    public void talk() {
        System.out.println("No Talking");
    }
}

class NoFlyable implements Fly {
    public void fly() {
        System.out.println("No Flying");
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Robot r = new Robot(new NoWalkable(), new Talkable(), new NoFlyable());
        r.act();
    }
}
