package graph;

import java.util.Iterator;

/**
 * Created by Nicolas on 15/03/2017.
 */
public abstract class GraphIterator implements Iterator<Node> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Node next() {
        return null;
    }
}
