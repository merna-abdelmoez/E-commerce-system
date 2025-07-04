import java.util.*;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough stock for: " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public List<Shippable> getShippableItems() {
        List<Shippable> list = new ArrayList<>();
        for (CartItem item : items) {
            Product p = item.getProduct();
            if (p instanceof Shippable) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    list.add((Shippable) p);
                }
            }
        }
        return list;
    }
}
