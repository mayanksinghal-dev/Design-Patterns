package DesignPatterns.CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite Design Pattern is a structural pattern that lets you treat individual objects (leaves) and groups of objects (composites) uniformly by organizing them
 * into a tree-like structure. It defines a common interface so clients can work with single objects and compositions in the same way.
 * <p>
 * Quick Understanding
 * Think of it like a file system:
 * A file is a single object
 * A folder can contain files and other folders
 * You can perform the same operation (like open, delete, or get size) on both
 * <p>
 * In Composite:
 * Component: common interface (e.g., draw(), calculateCost())
 * Leaf: individual object that does the actual work
 * Composite: holds children and forwards operations to them
 * <p>
 * Why it’s useful
 * Simplifies client code (no need to check if it’s a single object or a group)
 * Makes hierarchical structures easy to manage
 * Follows the Open/Closed Principle
 * <p>
 * In one line:
 * Composite lets you treat a single object and a collection of objects the same way.
 */

abstract class FileSystem {
    String name;
    int size;

    abstract int getSize();

    abstract String getName();

    abstract void open();
}

class File extends FileSystem {
    File(String name) {
        this.name = name;
        this.size = 1024;
    }

    int getSize() {
        return this.size;
    }

    String getName() {
        return this.name;
    }

    void open() {
        System.out.println("Open " + this.name);
    }
}

class Folder extends FileSystem {
    List<FileSystem> list = new ArrayList<>();
    Folder(String name) {
        this.name = name;
        this.size = 1024;
    }
    void add(FileSystem fs){
        list.add(fs);
    }
    int getSize() {
        return this.size;
    }

    String getName() {
        return this.name;
    }

    void open() {
        System.out.println("Open " + this.name);
        for(FileSystem fs : list){
            fs.open();
        }
    }
}

public class CompositePattern {
    public static void main(String[] args){
        Folder root = new Folder("root");
        Folder l1 = new Folder("l1");
        Folder l2 = new Folder("l2");
        root.add(l1);
        root.add(new File("l1 file"));
        l1.add(l2);
        l1.add(new File("l2 file"));
        l2.add(new File("l3 file"));

//        root.open();
        l1.open();
    }
}
