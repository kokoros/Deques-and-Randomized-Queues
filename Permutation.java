

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        int num = Integer.parseInt(args[0]);
        
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            randomizedQueue.enqueue(item);
            
        }
        
        while (randomizedQueue.size() - num > 0) {
            randomizedQueue.dequeue();
        }
        
        for (int i = 0; i < num; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
        

        
    }
    

}
