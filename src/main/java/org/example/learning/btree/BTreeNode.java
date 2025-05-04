package org.example.learning.btree;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BTreeNode<T extends Comparable<T>> {
    private List<T> keyList;
    private List<BTreeNode<T>> childNodeList;
    private int minimumDegree;
    private boolean isLeaf;

    public BTreeNode(int minimumDegree, boolean isLeaf) {
        this.minimumDegree = minimumDegree;
        this.isLeaf = isLeaf;
        this.keyList = new ArrayList<>();
        this.childNodeList = new ArrayList<>();
    }

    public BTreeNode<T> search(T searchKey) {
        int index = 0;

        while (index < keyList.size() && searchKey.compareTo(keyList.get(index)) > 0) {
            index++;
        }

        if (index < keyList.size() && searchKey.compareTo(keyList.get(index)) == 0) {
            return this;
        }

        if (isLeaf) {
            return null;
        }

        return childNodeList.get(index).search(searchKey);
    }

    public void splitChildNode(int childIndex) {
        BTreeNode<T> fullChild = childNodeList.get(childIndex);
        BTreeNode<T> newSibling = new BTreeNode<>(fullChild.minimumDegree, fullChild.isLeaf);

        for (int i = 0; i < minimumDegree - 1; i++) {
            newSibling.keyList.add(fullChild.keyList.remove(minimumDegree));
        }

        if (!fullChild.isLeaf) {
            for (int i = 0; i < minimumDegree; i++) {
                newSibling.childNodeList.add(fullChild.childNodeList.remove(minimumDegree));
            }
        }

        childNodeList.add(childIndex + 1, newSibling);
        keyList.add(childIndex, fullChild.keyList.remove(minimumDegree - 1));
    }

    public void insertNonFull(T newKey) {
        int keyInsertionIndex = keyList.size() - 1;

        if (isLeaf) {
            keyList.add(null);

            while (keyInsertionIndex >= 0 && newKey.compareTo(keyList.get(keyInsertionIndex)) < 0) {
                keyList.set(keyInsertionIndex + 1, keyList.get(keyInsertionIndex));
                keyInsertionIndex--;
            }

            keyList.set(keyInsertionIndex + 1, newKey);
        } else {
            while (keyInsertionIndex >= 0 && newKey.compareTo(keyList.get(keyInsertionIndex)) < 0) {
                keyInsertionIndex--;
            }

            keyInsertionIndex++;

            BTreeNode<T> targetChild = childNodeList.get((keyInsertionIndex));

            if (targetChild.keyList.size() == 2 * minimumDegree - 1) { // max child size
                splitChildNode(keyInsertionIndex);

                if (newKey.compareTo(keyList.get(keyInsertionIndex)) > 0) {
                    keyInsertionIndex++;
                }

                childNodeList.get(keyInsertionIndex).insertNonFull(newKey);
            }
        }
    }

    public void deleteKey(T keyToDelete) {
        int keyIndex = 0;

        while (keyIndex < keyList.size() && keyToDelete.compareTo(keyList.get(keyIndex)) > 0) {
            keyIndex++;
        }

        if (keyIndex < keyList.size() && keyToDelete.compareTo(keyList.get(keyIndex)) == 0) {
            if (isLeaf) {
                removeFromLeaf(keyIndex);
            } else {
                removeFromNonLeaf(keyIndex);
            }
        } else {
            if (isLeaf) {
                return;
            }
        }

        boolean lastChildFlag = (keyIndex == keyList.size());
        BTreeNode<T> childNode = childNodeList.get(keyIndex);
        if (childNode.keyList.size() < minimumDegree) {
            fillChildNode(keyIndex);
        }

        if (lastChildFlag && keyIndex > keyList.size()) {
            childNodeList.get(keyIndex - 1).deleteKey(keyToDelete);
        } else {
            childNodeList.get(keyIndex).deleteKey(keyToDelete);
        }
    }

    private void removeFromLeaf(int keyIndex) {
        keyList.remove(keyIndex);
    }

    public void removeFromNonLeaf(int keyIndex) {
        T deletedKey = keyList.get(keyIndex);
        BTreeNode<T> leftChild = childNodeList.get(keyIndex);
        BTreeNode<T> rightChild = childNodeList.get(keyIndex + 1);

        if (leftChild.keyList.size() >= minimumDegree) {
            T predecessorKey = getPredecessorKey(keyIndex);
            keyList.set(keyIndex, predecessorKey);
            leftChild.deleteKey(predecessorKey);
        } else if (rightChild.keyList.size() >= minimumDegree) {
            T successorKey = getSuccessorKey(keyIndex);
            keyList.set(keyIndex, successorKey);
            rightChild.deleteKey(successorKey);
        } else {
            mergeChildNodes(keyIndex);
            leftChild.deleteKey(deletedKey);
        }
    }

    private T getPredecessorKey(int keyIndex) {
        BTreeNode<T> currentNode = childNodeList.get(keyIndex);
        while (!currentNode.isLeaf) {
            currentNode = currentNode.childNodeList.get(currentNode.keyList.size());
        }

        return currentNode.keyList.get(currentNode.keyList.size() - 1);
    }

    private T getSuccessorKey(int keyIndex) {
        BTreeNode<T> currentNode = childNodeList.get(keyIndex + 1);
        while (!currentNode.isLeaf) {
            currentNode = currentNode.childNodeList.get(0);
        }

        return currentNode.keyList.get(0);
    }

    private void fillChildNode(int childIndex) {
        BTreeNode<T> childNode = childNodeList.get(childIndex);

        if (childIndex > 0 && childNodeList.get(childIndex - 1).keyList.size() >= minimumDegree) {
            borrowFromPreviousSibling(childIndex);
        } else if (childIndex < keyList.size() && childNodeList.get(childIndex + 1).keyList.size() >= minimumDegree) {
            borrowFromNextSibling(childIndex);
        } else {
            if (childIndex < keyList.size()) {
                mergeChildNodes(childIndex);
            } else {
                mergeChildNodes(childIndex - 1);
            }
        }
    }

    private void borrowFromPreviousSibling(int childIndex) {
        BTreeNode<T> childNode = childNodeList.get(childIndex);
        BTreeNode<T> leftSibling = childNodeList.get(childIndex - 1);

        childNode.keyList.add(0, keyList.get(childIndex - 1));

        if (!leftSibling.isLeaf) {
            childNode.childNodeList.add(0, leftSibling.childNodeList.remove(leftSibling.childNodeList.size() - 1));
        }

        keyList.set(childIndex - 1, leftSibling.keyList.remove(leftSibling.keyList.size() - 1));
    }

    private void borrowFromNextSibling(int childIndex) {
        BTreeNode<T> childNode = childNodeList.get(childIndex);
        BTreeNode<T> rightSibling = childNodeList.get(childIndex + 1);

        childNode.keyList.add(keyList.get(childIndex));

        if (!rightSibling.isLeaf) {
            childNode.childNodeList.add(rightSibling.childNodeList.remove(0));
        }

        keyList.set(childIndex, rightSibling.keyList.remove(0));
    }

    private void mergeChildNodes(int childIndex) {
        BTreeNode<T> targetChild = childNodeList.get(childIndex);
        BTreeNode<T> siblingChild = childNodeList.get(childIndex + 1);

        targetChild.keyList.add(keyList.remove(childIndex));
        if (!siblingChild.isLeaf) {
            targetChild.childNodeList.addAll(siblingChild.childNodeList);
        }

        childNodeList.remove(childIndex + 1);
    }
}
