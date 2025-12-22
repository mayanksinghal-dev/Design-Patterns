package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer pattern defines one to many relations between subject and observers. One state of subject changes, all its observers gets notified.
 * Use it when:
 *      Many objects depend on one object
 *      State changes must trigger updates
 *      You want loose coupling
 * 📌 Examples:
 *      Event listeners (button click)
 *      Stock price updates
 *      News feed
 *      Chat notifications
 */

interface Observer{
    void notifyUser(String title);
}

class User implements Observer{
    String name;

    User(String name){
        this.name = name;
    }

    public void notifyUser(String title){
        System.out.println("Hey "+ name + " checkout new video "+title);
    }
}

interface Observable{
    void subscribe(Observer ob);
    void unsubscribe(Observer ob);
    void addNewVideo(String title);
}

class Subject implements Observable{
    private List<Observer> observers = new ArrayList<>();
    private String latestVideo;
    private String channelName;
    Subject(String channelName){
        this.channelName = channelName;
    }
    public void subscribe(Observer ob){
        observers.add(ob);
    }
    public void unsubscribe(Observer ob){
        observers.remove(ob);
    }
    public void addNewVideo(String title){
        this.latestVideo = title;
        notify(title);
    }
    void notify(String title){
        for(Observer ob : observers){
            ob.notifyUser(title);
        }
    }
}
public class ObserverPattern {
    public static void main(String[] args){
        Observable sub = new Subject("NEW CHANNEL");
        User user1 = new User("Mayank");
        User user2 = new User("abc");

        sub.subscribe(user1);
        sub.subscribe(user2);
        sub.addNewVideo("Observer Pattern Explained");
    }
}
