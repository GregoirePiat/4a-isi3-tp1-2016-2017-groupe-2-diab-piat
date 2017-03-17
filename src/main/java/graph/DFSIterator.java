package graph;

import java.util.*;

public class DFSIterator extends GraphIterator {

    Stack<Node> stack;

    public DFSIterator(IGraph graph, Node nodeStart) {
        super(graph, nodeStart);
        this.stack = new Stack<Node>();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Node next() {
        return null;
    }

    @Override
    public void addNode(Node n) {
        this.stack.push(n);
    }

    @Override
    public Node removeNode() {
        if (this.stack.size() != 0)
            return this.stack.pop();
        else
            return null;
    }
}
