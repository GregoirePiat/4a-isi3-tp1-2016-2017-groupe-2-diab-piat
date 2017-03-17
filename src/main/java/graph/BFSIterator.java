package graph;

import java.util.*;

public class BFSIterator extends GraphIterator {

    Queue<Node> queue;

    public BFSIterator(IGraph graph, Node nodeStart) {
        super(graph, nodeStart);
        this.queue =  new LinkedList();
    }

    public boolean isEmpty() {
        return (this.queue.size() == 0);
    }

    public void enqueue(Node n) {
        this.queue.add(n);
    }

    public Node dequeue() {
        //Node n = this.queue.get(1);
        //this.queue.remove(1);
        //return n;
        return null;
    }
}
