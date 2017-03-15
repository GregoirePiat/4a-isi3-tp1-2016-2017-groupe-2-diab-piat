package graph;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UndirectedGraph implements IUndirectedGraph {
    private Graph g;

    public UndirectedGraph() {
        g = new Graph();
    }

    @Override
    public void addNode(Node _node) {
        g.addNode(_node);
    }

    @Override
    public Set<Node> getAllNodes() {
        return g.getAllNodes();
    }

    @Override
    public int getNbNodes() {
        return g.getNbNodes();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        return g.getAdjNodes(_n);
    }

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return g.creerBFSIterator(n);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
        return g.creerDFSIterator(n);
    }

    /**
     * Ajoute une arrete au graph entre deux noeuds
     *
     */
    @Override
    public void addEdge(Node _node1, Node _node2) {
        if (!hasEdge(_node1, _node2))
        {
            g.addArc(new Arc(_node1,_node2, null));
            g.addArc(new Arc(_node2,_node1, null));
        }
    }

    /**
     *  @return vrai si le graph possede une arrete entre les noeuds _n1 et _n2
     *
     */
    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return g.hasArc(_node1, _node2);
    }
}
