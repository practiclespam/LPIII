package DAA3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double getRatio() {
        return (double) value / weight;
    }
}

public class FractionalKnapsack {

    public static double getMaxValue(int capacity, List<Item> items) {

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity >= item.weight && remainingCapacity > 0) {
            	
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else if(remainingCapacity > 0) {
                totalValue += item.getRatio() * remainingCapacity;
                break;  
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(18, 25));
        items.add(new Item(15, 24));
        items.add(new Item(10, 15));

        int knapsackCapacity = 20;

        double maxValueProfit = getMaxValue(knapsackCapacity, items);
        System.out.println("Maximum value considering profit: " + maxValueProfit);

        items.sort(Comparator.comparingInt(item -> item.weight));

        double maxValueWeight = getMaxValue(knapsackCapacity, items);
        System.out.println("Maximum value considering weight: " + maxValueWeight);

        items.sort(Comparator.comparingDouble(Item::getRatio).reversed());

        double maxValueRatio = getMaxValue(knapsackCapacity, items);
        System.out.println("Maximum value considering profit/weight ratio: " + maxValueRatio);
    }
}
