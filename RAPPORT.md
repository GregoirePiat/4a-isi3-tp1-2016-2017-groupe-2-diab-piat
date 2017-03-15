**Nom/Prénom Etudiant 1 : DIAB Nicolas**

**Nom/Prénom Etudiant 2 : PIAT Grégoire**

# Rapport TP1

## Question 1
*Expliquer le code ajouté*

```java
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
            for (Arc arc : arcs)
                sb.append(" [" + arc.toString() + "] ");
        }
        sb.append("\n");
    }

    return sb.toString();
}
```

## Question 2
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

Nous avons choisi le Pattern Adapter qui permet d'appeler les méthodes de IGraph déjà codées dans la classe Graph grâce à un attribut privé de type Graph.

***Schéma***

![Graph dia](http://i.imgur.com/QqD9F5q.png)

***Code***
```java
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
```

## Question 3
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

## Question 4
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*
