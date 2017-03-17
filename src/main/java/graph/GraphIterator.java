package graph;

import java.util.*;

public abstract class GraphIterator implements Iterator<Node> {

    private IGraph graph;
    private Node nodeStart;
    private List<Node> markedNodes;

    public GraphIterator(IGraph graph, Node nodeStart) {
        this.setGraph(graph);
        this.setNodeStart(nodeStart);
        this.markedNodes = new ArrayList<>();
    }

    @Override
    public abstract boolean hasNext();

    @Override
    public Node next() {
        Node n = this.removeNode();
        for (Node child : this.getGraph().getAdjNodes(n)) {
            if(!isMarked(child)) {
                this.addNode(child);
            }
        }
        return n;
    }

    public abstract void addNode(Node n);
    public abstract Node removeNode();

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

    public boolean isMarked(Node n) {
        return this.markedNodes.contains(n);
    }

    public void markNode(Node n) {
        this.markedNodes.add(n);
    }
}
