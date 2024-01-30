import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Remove extends Cart {
    static BufferedWriter writer;

    public static void removeItemFromCart(String item, int quantity, double price) {
        cartItems.remove(item);
        cartQuantities.remove(quantity);
        cartPrices.remove(price);
    }

    public static void remove() {
        System.out.println("\n-----------REMOVE FROM CART-----------\n");
        addCartItem();
        System.out.print("Enter index number of item to remove: ");
        int itemIndex = scanner.nextInt();

        if (itemIndex >= 1 && itemIndex <= cartItems.size()) {
            String removedItem = cartItems.remove(itemIndex - 1);
            int removedQuantity = cartQuantities.remove(itemIndex - 1);
            double removedPrice = cartPrices.remove(itemIndex - 1);

            System.out.println("\n" + removedItem + " removed from the cart.");
            System.out.println("Quantity: " + removedQuantity + "\t\t\t\tPrice: $" + removedPrice);

            updateTotal();
        } else {
            System.out.println("Invalid item number!");
        }
    }

    public static void updateTotal() {
        double total = 0;
        for (Double price : cartPrices) {
            total += price;
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            fileWriter.newLine();
            fileWriter.write("• Removed item(s): " + cartItems);
            fileWriter.newLine();
            fileWriter.write("  Quantity: " + cartQuantities);
            fileWriter.newLine();
            fileWriter.write("  Price:    " + cartPrices);
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        total = Math.round(total * 100.0) / 100.0;
        System.out.println("\nUpdated total price after removal: $" + total + "\n");
    }
}