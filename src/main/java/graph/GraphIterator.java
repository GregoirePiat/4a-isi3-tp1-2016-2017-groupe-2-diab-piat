package graph;

import java.util.Iterator;

public abstract class GraphIterator implements Iterator<Node> {

    private IGraph graph;
    private Node nodeStart;

    public GraphIterator(IGraph graph, Node nodeStart) {
        this.setGraph(graph);
        this.setNodeStart(nodeStart);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Node next() {
        return null;
    }

    public IGraph getGraph() {
        return graph;
    }

    public void setGraph(IGraph graph) {
        this.graph = graph;
    }

    public Node getNodeStart() {
        return nodeStart;
    }

    public void setNodeStart(Node nodeStart) {
        this.nodeStart = nodeStart;
    }
}
