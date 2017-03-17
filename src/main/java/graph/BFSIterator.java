package graph;

import java.util.*;

public class BFSIterator extends GraphIterator {

    Queue<Node> queue;

    public BFSIterator(IGraph graph, Node nodeStart) {
        super(graph, nodeStart);
        this.queue =  new LinkedList();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Node next() {
        return null;
    }

    public boolean isEmpty() {
        return (this.queue.size() == 0);
    }

    @Override
    public void addNode(Node n) {
        this.queue.add(n);
    }

    @Override
    public Node removeNode() {
        if (this.queue.size() != 0) {
            Node n = this.queue.remove();
            return n;
        }
        else
            return null;
    }
}
