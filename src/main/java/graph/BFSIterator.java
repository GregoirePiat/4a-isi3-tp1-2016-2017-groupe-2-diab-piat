package graph;

import java.util.*;

public class BFSIterator extends GraphIterator {

    Queue<Node> queue;

    public BFSIterator(IGraph graph, Node nodeStart) {
        super(graph, nodeStart);
        this.queue =  new LinkedList();
        this.addNode(nodeStart);
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public void addNode(Node n) {
        this.queue.add(n);
    }

    @Override
    public Node removeNode() {
        return this.queue.remove();
    }
}
