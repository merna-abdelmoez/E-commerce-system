import java.util.List;

public class ShippingService {
    public static double calculateShippingFee(List<Shippable> items) {
        double totalWeight = items.stream().mapToDouble(Shippable::getWeight).sum(); // in grams
        return (totalWeight / 1000.0) * 30; // 30 EGP per kg
    }

    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.println(item.getName());
            System.out.println((int)item.getWeight() + "g");
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight / 1000.0);
    }
}
