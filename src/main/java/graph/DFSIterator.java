package graph;

import java.util.*;

public class DFSIterator extends GraphIterator {

    Stack<Node> stack;

    public DFSIterator(IGraph graph, Node nodeStart) {
        super(graph, nodeStart);
    }
}
