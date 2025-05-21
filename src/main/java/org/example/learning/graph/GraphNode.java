package org.example.learning.graph;

import java.util.HashSet;
import java.util.Set;

public class GraphNode<T> {
    private final T value;
    private final Set<GraphNode<T>> neighbors;

    public GraphNode(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    public T getValue() {
        return value;
    }

    public Set<GraphNode<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(GraphNode<T> neighbor) {
        neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
