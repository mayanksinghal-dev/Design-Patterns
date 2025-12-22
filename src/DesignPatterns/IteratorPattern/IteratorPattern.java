package DesignPatterns.IteratorPattern;

import java.util.List;

/**
 * It is same iterator class of java. This design pattern teaches to separate the business logic and traversing logic seperate. So any change in business data structure wont
 * effect the traversing logic. Else with 1 change, we may need to change traversing logic at multiple places. Which breaks OCP in SOLID.
 */
record Node<T>(T value, Node<T> next){};
interface MyIterator<T>{
    boolean hasNext();
    T next();
}

class LinkedListIterator<T> implements MyIterator<T> {
    private Node<T> current;

    LinkedListIterator(Node<T> head) {
        this.current = head;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T value = current.value();
        current = current.next();
        return value;
    }
}

class ArrayIterator<T> implements MyIterator<T>{
    private final List<T> list;
    private int index = 0;

    ArrayIterator(List<T> list){
        this.list = list;
    }
    @Override
    public boolean hasNext(){
        return index < list.size();
    }

    @Override
    public T next() {
        T next = list.get(index);
        index++;
        return next;
    }
}

interface MyIterable<T> {
    MyIterator<T> iterator();
}

class LinkedList<T> implements MyIterable<T> {
    private final Node<T> head;

    LinkedList(Node<T> head) {
        this.head = head;
    }

    @Override
    public MyIterator<T> iterator() {
        return new LinkedListIterator<T>(head);
    }
}

class Array<T> implements MyIterable<T> {
    private final List<T> list;

    Array(List<T> list) {
        this.list = list;
    }

    @Override
    public MyIterator<T> iterator() {
        return new ArrayIterator<>(list);
    }
}


public class IteratorPattern {
    public static void main(String[] args) {

        Node<Integer> n3 = new Node<Integer>(3, null);
        Node<Integer> n2 = new Node<Integer>(2, n3);
        Node<Integer> n1 = new Node<Integer>(1, n2);

        MyIterable<Integer> linkedList = new LinkedList<Integer>(n1);
        MyIterator<Integer> it1 = linkedList.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        MyIterable<Integer> array = new Array<>(List.of(1, 2, 3, 4, 5));
        MyIterator<Integer> it2 = array.iterator();

        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}

