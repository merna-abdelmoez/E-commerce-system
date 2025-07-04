public class ExpiringProduct extends Product implements Expirable, Shippable {
    private boolean expired;
    private double weight;

    public ExpiringProduct(String name, double price, int quantity, boolean expired, double weight) {
        super(name, price, quantity);
        this.expired = expired;
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
