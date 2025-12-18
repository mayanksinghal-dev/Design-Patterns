package BridgePattern;

/**
 * Bridge pattern decouples an abstraction(High level part) to its implementation (Low level part), so that both can vary independently.
 * Abstraction - High level part ( car)
 * Implementation - Low level part (engine)
 * -x-
 * Both are abstract class only, the only difference lies in developers perspective. 1 can be high level,which may contains different low level parts.
 */

abstract class Car{
    Engine engine;
    abstract void drive();
}
abstract class Engine{
    abstract void start();
}

class Sedan extends Car{
    Sedan(Engine engine){
        this.engine = engine;
    }
    void drive(){
        engine.start();
        System.out.println("sedan driving");
    }
}

class SUV extends Car{
    SUV(Engine engine){
        this.engine = engine;
    }
    void drive(){
        engine.start();
        System.out.println("Suv driving");
    }
}

class HatchBack extends Car{
    HatchBack(Engine engine){
        this.engine = engine;
    }
    void drive(){
        engine.start();
        System.out.println("HatchBack driving");
    }
}

class PetrolEngine extends Engine{
    void start(){
        System.out.println("Petrol engine start");
    }
}

class DieselEngine extends Engine{
    void start(){
        System.out.println("Diesel engine start");
    }
}

class ElectricEngine extends Engine{
    void start(){
        System.out.println("Electric engine start");
    }
}
public class BridgePattern {
    public static void main(String[] args){
        PetrolEngine petrolEngine = new PetrolEngine();
        DieselEngine dieselEngine = new DieselEngine();
        ElectricEngine electricEngine = new ElectricEngine();
        HatchBack hatchBack = new HatchBack(petrolEngine);
        HatchBack hatchBack2 = new HatchBack(dieselEngine);
        HatchBack hatchBack3 = new HatchBack(electricEngine);
        SUV suv = new SUV(petrolEngine);
        Sedan sedan = new Sedan(electricEngine);
        hatchBack.drive();
        hatchBack2.drive();
        hatchBack3.drive();
        suv.drive();
        sedan.drive();
    }
}
