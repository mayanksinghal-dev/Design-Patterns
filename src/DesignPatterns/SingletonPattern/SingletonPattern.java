package DesignPatterns.SingletonPattern;

/**
 * This is a creational design pattern used to restrict a class to instantiated only once in the project.
 * Used when we want only single instance of the class and whole project should use that instance only. For eg: Datasource, Logger.
 */

//Bill pugh design
public class SingletonPattern {
    private SingletonPattern(){};

    private static class Holder{
        private static final SingletonPattern INSTANCE = new SingletonPattern();
    }

    public static SingletonPattern get(){
        return Holder.INSTANCE;
    }
}
