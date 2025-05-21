package org.example.learning.graph;

import java.util.HashMap;
import java.util.Map;

public class Graph<T> {
    private final Map<T, GraphNode<T>> nodes = new HashMap<>();
    private final boolean isDirected;

    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public GraphNode<T> addNode(T value) {
        return nodes.computeIfAbsent(value, GraphNode::new);
    }

    public void addEdge(T from, T to) {
        GraphNode<T> fromNode = addNode(from);
        GraphNode<T> toNode = addNode(to);

        fromNode.addNeighbor(toNode);
        if(!isDirected) {
            toNode.addNeighbor(fromNode);
        }
    }

    public GraphNode<T> getNode(T value) {
        return nodes.get(value);
    }

    public Map<T, GraphNode<T>> getAllNodes() {
        return nodes;
    }

    public boolean isDirected() {
        return isDirected;
    }
}
