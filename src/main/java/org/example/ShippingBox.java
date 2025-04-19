package org.example;

import java.util.ArrayList;
import java.util.List;

public class ShippingBox {
    private static final Integer maxItems = 10;
    private static final Integer maxWeight = 20;

    private List<Integer> items;

    public ShippingBox() {
        items = new ArrayList<>();
    }

    public boolean addItem(Integer weight) {
        if(items.size() < maxItems && getCurrentWeight() + weight <= maxWeight) {
            items.add(weight);
            return true;
        }
        return false;
    }

    public int getCurrentWeight() {
        return items.stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isFull() {
        return items.size() == maxItems;
    }

    public List<Integer> getItems() {
        return items;
    }

    private List<ShippingBox> packBoxes(int[] itemWeights) {
        List<ShippingBox> boxes = new ArrayList<>();
        ShippingBox currentBox = new ShippingBox();

        for (int weight : itemWeights) {
            if(!currentBox.addItem(weight)) {
                boxes.add(currentBox);
                currentBox = new ShippingBox();
                currentBox.addItem(weight);
            }
        }

        if(!currentBox.getItems().isEmpty()) {
            boxes.add(currentBox);
        }

        return boxes;
    }
}
