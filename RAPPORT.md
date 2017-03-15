**Nom/Prénom Etudiant 1 : DIAB Nicolas**

**Nom/Prénom Etudiant 2 : PIAT Grégoire**

# Rapport TP1

## Question 1
*Expliquer le code ajouté*

## Question 2
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*
CODE :
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
![Graph dia](http://i.imgur.com/QqD9F5q.png)

## Question 3
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*

## Question 4
*Expliquer le code ajouté et insérer un schéma du patron de conception mis en place*
