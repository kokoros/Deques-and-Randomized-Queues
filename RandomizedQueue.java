
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] queue;
    
    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
        n = 0;
    }
    
    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }
    
    // return the number of items on the randomized queue
    public int size() {
        return n;
    }
    
    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        
        if (n == queue.length) {
            resize(2 * queue.length);
        }
        queue[n++] = item;
        
        
        
    }
    
    private void resize(int maxLength) {
        Item[] newQueue = (Item[]) new Object[maxLength];
//        System.out.println("queue.length:" + queue.length);
//        System.out.println("n:" + n);
        for (int i = 0; i < n; i++) {
            newQueue[i] = queue[i];

            
        }
        queue = newQueue;
//        System.out.println("queue:" + queue[0]);
    }
    
    // remove and return a random item
    public Item dequeue() {
        if (n == 0) throw new NoSuchElementException();
        
        Item randomItem;
        int randomIndex;
        
        if (n > 0 && n == queue.length / 4) {
            resize(queue.length / 2);
        }
        
//        System.out.println("old queue:" + queue[0] + queue[1] + queue[2] + queue[3] + queue[4]);

        randomIndex = StdRandom.uniform(n);
        randomItem = queue[randomIndex];
        if (randomIndex == (n - 1)) {
            queue[randomIndex] = null;
        } else {
            queue[randomIndex] = queue[n-1];
            queue[n-1] = null;
        }


//        System.out.println("new queue:" + queue[0] + queue[1] + queue[2] + queue[3] + queue[4]);
        
        n--;
        return randomItem;
        
    }
    
    // return a random item (but do not remove it)
    public Item sample() {
        if (n == 0) throw new NoSuchElementException();
        
        int randomIndex = StdRandom.uniform(n);
        Item randomItem = queue[randomIndex];
        
        
        return randomItem;
    }
    
    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new RandomDequeIterator();
    }
    
    private class RandomDequeIterator implements Iterator<Item> {
        private int m;
        final Item[] iterq;
        
        private RandomDequeIterator() {
            iterq = (Item[]) new Object[n];
            for (int i = 0; i < n; i++) {
                iterq[i] = queue[i];
            }
            StdRandom.shuffle(iterq);
        }

        public boolean hasNext() {
            return m < n;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if (m >= n) throw new NoSuchElementException();
            Item temp = iterq[m++];
            return temp;
        }
        
        
        
    }
    
    // unit testing (required)
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        
        randomizedQueue.enqueue(args[0]);
        randomizedQueue.enqueue(args[1]);
        randomizedQueue.enqueue(args[2]);
        randomizedQueue.enqueue(args[3]);
        randomizedQueue.enqueue(args[4]);
        
        System.out.println("is empty:" + randomizedQueue.isEmpty());
        System.out.println("Size:" + randomizedQueue.size());
        
        String randomItem = randomizedQueue.dequeue();
        System.out.println("dequeue:" + randomItem);
        
        System.out.println("Size:" + randomizedQueue.size());
        
        String sample = randomizedQueue.sample();
        System.out.println("sample:" + sample);
        
        System.out.println("Size:" + randomizedQueue.size());
        
        Iterator<String> it = randomizedQueue.iterator();
        
        while (it.hasNext()) {
            System.out.println("Iterator:" + it.next());
        }
        
        
        
        
        
        

    }

}
