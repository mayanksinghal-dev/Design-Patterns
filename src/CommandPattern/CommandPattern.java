package CommandPattern;

import java.util.*;

/**
 * Definition - Decouple the invoker from the task by introducing a command abstraction.
 * -x
 * Explanation
 * I feel maintaining the queue and using undo is just a tweak in the core architecture.
 * Core arch of command pattern is it have an invoker and a task rather tightly coupling the task to invoker, we maintain a middleware i.e. command handler.
 * we call to methods of command handler like execute, undo, block/freeze or any other based on business and that command handler will
 * tightly couple to the task and have knowledge of how to execute it. that way, we can maintain n number of commands with tasks without modifying code in invoker or client,
 * we just maintain set method, which will set command to an index of list/array of commands.
 * -x
 * I can assume many of the features of text editor may work on this because each is task executed by a command handler, or we can have decorator also so we can maintain
 * multiple features like bold and italic and underline together at a text.
 */

interface Commands{
    void execute();
    void undo();
}
class Invoker{
    Map<String,Commands> commands = new HashMap<>();
    Stack<Commands> st = new Stack<>();

    public void run(String key){
        Commands cd = commands.get(key);
        if(cd!=null){
            st.add(cd);
            cd.execute();
        }
        else{
            System.out.println("Key does not exists");
        }
    }

    public void undo(){
        st.pop().undo();
    }

    public void setCommands(Commands c, String key){
        if(commands.get(key)!=null){
            System.out.println("Key already exists");
        }
        else {
            commands.put(key, c);
        }
    }
}

class LightCommand implements Commands{
    Light l = new Light();
    public void execute(){
        l.on();
    }
    public void undo(){
        l.off();
    }
}

class Light{
    public void on(){
        System.out.println("Light on");
    }
    public void off(){
        System.out.println("Light off");
    }
}

class FanCommand implements Commands{
    Fan l = new Fan();
    public void execute(){
        l.on();
    }
    public void undo(){
        l.off();
    }
}

class Fan{
    public void on(){
        System.out.println("Light on");
    }
    public void off(){
        System.out.println("Light off");
    }
}

public class CommandPattern {
}
