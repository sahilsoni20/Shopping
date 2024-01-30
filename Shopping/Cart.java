import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Cart extends List {
    static String filePath = "Shopping.txt";
    static ArrayList<String> cartItems = new ArrayList<>();
    static ArrayList<Integer> cartQuantities = new ArrayList<>();
    static ArrayList<Double> cartPrices = new ArrayList<>();

    public static void addItemToCart(String item, int quantity, double price) {
        cartItems.add(item);
        cartQuantities.add(quantity);
        cartPrices.add(price);
    }

    public static void cart(String fullName, String phoneNum) {
        System.out.println("\n-----------CART-----------\n");
        currentDateTime();
        System.out.println("Name: " + fullName);
        System.out.println("Phone Number: " + phoneNum);
        addCartItem();
    }

    public static void addCartItem() {
        double total = 0;
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println("\n" + (i + 1) + " " + cartItems.get(i) + "\n  Quantity: " + cartQuantities.get(i)
                    + "\t\t\t\tPrice: $" + cartPrices.get(i));
            total += cartPrices.get(i);
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            fileWriter.write("• " + "Items: " + cartItems);
            fileWriter.newLine();
            fileWriter.write("  Quantity: " + cartQuantities);
            fileWriter.newLine();
            fileWriter.write("  Price:    " + cartPrices);
            fileWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("\nTotal price: $" + total + "\n");
    }

    public static void currentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/HH/yyy  HH:mm:ss");
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
                "Saturday" };
        System.out.println(
                "Date: " + formatter.format(date) + "  " + days[calendar.get(Calendar.DAY_OF_WEEK) - 1] + "\n");
    }

}