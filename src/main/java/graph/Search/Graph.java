package graph.Search;

import graph.Iterator.BFSIterator;
import graph.Iterator.DFSIterator;
import graph.Search.IDirectedGraph;
import graph.Structure.Arc;
import graph.Structure.Node;

import java.util.*;
import java.util.stream.Collectors;


public class Graph implements IDirectedGraph {

	/**
	 * A chaque cle=noeud est associe la liste des arcs sortants de ce noeud
	 */
	private Map<Node,List<Arc>> adjacence;
	
	public Graph(){
		
		adjacence = new HashMap<Node,List<Arc>>();
		
		
	
	}
	/**
	 * 
	 * @param _n1
	 * @param _n2
	 * @return vrai si graph possede arc de src _n1 et destination _n2
	 */
	public boolean hasArc(Node _n1, Node _n2){
		List<Arc> arretesAdj = adjacence.get(_n1);
		for (Arc _a : arretesAdj){
			if (_n1.equals(_a.getSource()) && _n2.equals(_a.getDestination()))
				return true;
		}
		return false;
	}
	
	public void addNode(Node _node){
		adjacence.put(_node, new ArrayList<Arc>());

	}
	
	public void addArc(Arc _edge){
	
		if (!hasArc(_edge.getSource(),_edge.getDestination()))
			adjacence.get(_edge.getSource()).add(_edge);
	
	}

    public Set<Node> getAllNodes(){

        return this.adjacence.keySet();
    }
	
	public int getNbNodes(){
		//A COMPLETER

		return this.getAllNodes().size();
	}
	
	/**
	 * 
	 * @param _n
	 * @return tous les arcs de source _n
	 */
	public List<Arc> getArc(Node _n){
		
		return adjacence.get(_n);
	}

	/**
	 * renvoie tous les noeuds qui sont destination d'un arc dont la source est _n
	 */
	public List<Node> getAdjNodes(Node _n){
		List<Arc> arcs = this.getArc(_n);
		return arcs.stream()
				.map(Arc::getDestination)
				.collect(Collectors.toList());
	}

    @Override
    public Iterator<Node> creerBFSIterator(Node n) {
        return new BFSIterator(this, n);
    }

    @Override
    public Iterator<Node> creerDFSIterator(Node n) {
		return new DFSIterator(this, n);
    }


    @Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Graph \n");

		for (Map.Entry<Node, List<Arc>> entry : this.adjacence.entrySet()) {
			sb.append("[noeud=");
			Node nodeItem = entry.getKey();
			List<Arc> arcs = entry.getValue();
			/* Append node label */
			sb.append(nodeItem.toString());
			sb.append(" :");

			if (arcs.size() == 0)
				sb.append(" [] ");
			else {
				/* Append arcs description */
				for (Arc arc : arcs){
					sb.append(" [");
					sb.append(arc.toString());
					sb.append(" ");
				}

			}
			sb.append("\n");
		}

		return sb.toString();
	}
}
