

import java.util.Iterator;


public class Deque<Item> implements Iterable<Item> {
    private int n; // number of elements on queue
    private Node first, last; // beginning and end of queue
    
    private class Node {
        Item item;
        Node pre;
        Node next;
    }
        
    
    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }
    
    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }
    
    // return the number of items on the deque
    public int size() {
        return n;
    }
    
    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        
        Node oldfirst = first;
        
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        if (n == 0) {
            last = first;
        } else {
            oldfirst.pre = first;
        }
        n++;
        
    }
    
    // add item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        
        Node oldlast = last;
        
        last = new Node();
        last.item = item;
        last.pre = oldlast;
        if (n == 0) {
            first = last;
        } else {
            oldlast.next = last;
        }
        
        n++;
    }
    
    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        
        Node oldfirst = first;
        first = oldfirst.next;
        n--;
        if (n == 0) {
            last = null;
        } else {
            first.pre = null;
        }
        return oldfirst.item;
    }
    
    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        
        Node oldlast = last;
        last = oldlast.pre;
        n--;
        if (n == 0) {
            first = null;
        } else {
            last.next = null;
        }
        return oldlast.item;
    }
    

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        // Auto-generated method stub
        return new NextDequeIterator();
    }
    
    private class NextDequeIterator implements Iterator<Item> {
        private Node current = first;
        
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (current == null) throw new java.util.NoSuchElementException();
                
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<String>();
        
        deque.addFirst(args[0]);
        deque.addLast(args[1]);
        
        System.out.println("is empty:" + deque.isEmpty());
        System.out.println("Size:" + deque.size());
        
        Iterator<String> it = deque.iterator();
        
        while (it.hasNext()) {
            System.out.println("iterator:" + it.next());
        }
        
        System.out.println("remove first:" + deque.removeFirst());
        System.out.println("remove last:" + deque.removeLast());
        
        
    }

    
    
    
    
    
    

}
