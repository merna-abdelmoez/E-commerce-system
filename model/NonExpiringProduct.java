package model;
import interfaces.Shippable;

public class NonExpiringProduct extends Product implements Shippable {
    private double weight;

    public NonExpiringProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
