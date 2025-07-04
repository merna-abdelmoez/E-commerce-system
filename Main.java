import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Products
        ExpiringProduct cheese = new ExpiringProduct("Cheese", 100, 5, false, 400);
        ExpiringProduct biscuits = new ExpiringProduct("Biscuits", 150, 3, false, 700);
        NonExpiringProduct tv = new NonExpiringProduct("TV", 3000, 2, 8000);
        Product scratchCard = new Product("Scratch Card", 50, 10) {}; // not shippable or expirable

        // Customer
        Customer customer = new Customer("Merna", 10000);

        // Cart
        Cart cart = new Cart();
        try {
            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding to cart: " + e.getMessage());
            return;
        }

        checkout(customer, cart);
    }

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product instanceof Expirable) {
                if (((Expirable) product).isExpired()) {
                    System.out.println("Error: Product expired - " + product.getName());
                    return;
                }
            }

            if (product.getQuantity() < item.getQuantity()) {
                System.out.println("Error: Insufficient stock for - " + product.getName());
                return;
            }
        }

        double subtotal = cart.getSubtotal();
        List<Shippable> toShip = cart.getShippableItems();
        double shippingFee = ShippingService.calculateShippingFee(toShip);
        double total = subtotal + shippingFee;

        if (!customer.canPay(total)) {
            System.out.println("Error: Customer balance is insufficient.");
            return;
        }

        // Shipping
        if (!toShip.isEmpty()) ShippingService.ship(toShip);

        // Payment
        customer.pay(total);
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Receipt
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName());
            System.out.println((int)item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal\n" + (int)subtotal);
        System.out.println("Shipping\n" + (int)shippingFee);
        System.out.println("Amount\n" + (int)total);
        System.out.println("END.");
        System.out.printf("Remaining Balance: %.2f%n", customer.getBalance());
    }
}
