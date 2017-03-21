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

Nous traitons les question 3 et 4 à la fois.

***Schéma UML***
![Graph dia](http://imgur.com/a/T5x13)


Comme vous pouvez le voir sur le schéma ci-dessus, nous avons une classe abstraite GraphIterator qui implémente Iterator de Java. Cette classe possède donc les 2 méthodes cléf de l'Iterator, à savoir :
- hasNext() qui renvoie un booléen si l'itérateur possède un autre objet (concrètement, si la pile ou la file n'est pas vide)
- next() qui renvoie le node qui suit

On a ensuite 2 classes filles BFS et DFS qui héritent de GraphIterator. Ce sont ces 2 classes que l'on instanciera. Elles possèdent les méthodes :
- addNode(Node n) : ajoute un node à la pile/file
- removeNode() : enlève le premier node de la pile/file et le retourne
Ces deux classes diffèrent sur un point : leur structure de donnée. DFS possède une file et BFS une file.
