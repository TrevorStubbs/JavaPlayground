package org.example.learning.btree;

import java.util.List;

public class BTree<T extends Comparable<T>> {
    private BTreeNode<T> rootNode;
    private int minimumDegree;

    public BTree(int minimumDegree) {
        this.minimumDegree = minimumDegree;
        this.rootNode = new BTreeNode<>(minimumDegree, true);
    }

    public BTreeNode<T> search(T searchKey) {
        if (rootNode == null) {
            return null;
        }

        return rootNode.search(searchKey);
    }

    public void insert(T newKey) {
        BTreeNode<T> currentRoot = rootNode;

        if (currentRoot.getKeyList().size() == 2 * minimumDegree - 1) {
            BTreeNode<T> newRoot = new BTreeNode<>(minimumDegree, false);
            newRoot.getChildNodeList().add(currentRoot);
            newRoot.splitChildNode(0);

            int insertionIndex = newRoot.getKeyList().get(0).compareTo(newKey) < 0 ? 1 : 0;
            newRoot.getChildNodeList().get(insertionIndex).insertNonFull(newKey);
            rootNode = newRoot;
        } else {
            currentRoot.insertNonFull(newKey);
        }
    }

    public void traverseInOrder(BTreeNode<T> node, List<T> result) {
        int numberOfKeysInNode = node.getKeyList().size();
        for (int i = 0; i < numberOfKeysInNode; i++) {
            if (!node.isLeaf()) {
                traverseInOrder(node.getChildNodeList().get(i), result);
            }
            result.add(node.getKeyList().get(i));

            if (!node.isLeaf()) {
                traverseInOrder(node.getChildNodeList().get(numberOfKeysInNode), result);
            }
        }
    }

    private void delete(T keyToDelete) {
        if (rootNode == null) {
            return;
        }

        rootNode.deleteKey(keyToDelete);

        if (rootNode.getKeyList().isEmpty()) {
            if (rootNode.isLeaf()) {
                rootNode = null;
            } else {
                rootNode = rootNode.getChildNodeList().get(0);
            }
        }
    }
}
