import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class List {
    static Scanner scanner = new Scanner(System.in);
    static int choice;
    static String choices;

    @SuppressWarnings("unchecked")
    private static Map<String, Double>[] categories = new HashMap[10];
    static int quantity;
    static String selectedItem;
    static double price;

    static {
        for (int i = 0; i < 10; i++) {
            categories[i] = new HashMap<>();
        }
        categories[0].put("Rice", 2.99);
        categories[0].put("Pasta", 1.99);
        categories[0].put("Quinoa", 4.99);
        categories[0].put("Lentils", 3.49);
        categories[0].put("Canned beans", 1.79);

        categories[1].put("Oats", 2.35);
        categories[1].put("Breakfast cereals", 5.22);
        categories[1].put("Flous", 3.66);
        categories[1].put("Bread", 9.30);
        categories[1].put("Crackers", 2.45);

        categories[2].put("Sugar", 5.21);
        categories[2].put("Brown sugar", 3.65);
        categories[2].put("Baking soda", 4.62);
        categories[2].put("Vanilla extract", 0.22);
        categories[2].put("Baking powder", 7.12);

        categories[3].put("Salt", 4.62);
        categories[3].put("Pepper", 8.56);
        categories[3].put("Cumin", 8.36);
        categories[3].put("Paprika", 2.35);
        categories[3].put("Oregano", 7.31);

        categories[4].put("Olive oil", 0.33);
        categories[4].put("Balsamic vinegar", 4.61);
        categories[4].put("Apple cider vinegar", 1.09);
        categories[4].put("Soya sauce", 9.55);

        categories[5].put("Tomatoes", 5.66);
        categories[5].put("Tuna", 6.91);
        categories[5].put("Soup", 2.03);
        categories[5].put("Vegetables", 4.36);
        categories[5].put("Coconut Milk", 8.56);

        categories[6].put("Milk", 3.57);
        categories[6].put("Butter", 1.59);
        categories[6].put("Eggs", 0.36);
        categories[6].put("Cheese", 0.77);
        categories[6].put("Yogurt", 2.63);

        categories[7].put("Nuts", 2.68);
        categories[7].put("Chips", 3.66);
        categories[7].put("Popcorn", 7.02);
        categories[7].put("Crackers", 9.03);
        categories[7].put("Dried fruits", 2.05);

        categories[8].put("Coffee", 4.30);
        categories[8].put("Tea", 5.32);
        categories[8].put("Juice", 7.51);
        categories[8].put("Soda", 9.12);
        categories[8].put("Bottled water", 4.31);

        categories[9].put("Honey", 2.99);
        categories[9].put("Maple syrup", 3.99);
        categories[9].put("Agave nectar", 4.69);

    }

    public static void list() {
        while (true) {
            System.out.println("\n-----------LIST OF ITEMS-----------\n");
            System.out.println("1. Pantry Staples:");
            System.out.println("2. Grains & Cereals:");
            System.out.println("3. Baking Ingredients:");
            System.out.println("4. Herbs & Spices:");
            System.out.println("5. Oil & Vinegars:");
            System.out.println("6. Canned Goods:");
            System.out.println("7. Dairy & Refrigerated Items:");
            System.out.println("8. Snacks:");
            System.out.println("9. Bevarages:");
            System.out.println("10. Sweeteners:");
            System.out.println("11. Exit");
            System.out.print("\nEnter number to open sub-list: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 10) {
                displayCategoryItems(choice);
            } else if (choice == 11) {
                Shopping.commandMenu();
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public static void displayCategoryItems(int category) {
        System.out.println("\nItem in category " + category + ":-\n");
        Map<String, Double> itemsWithPrices = categories[category - 1];

        if (itemsWithPrices.isEmpty()) {
            System.out.println("No items available in this category.");
            return;
        }

        int i = 1;
        for (Map.Entry<String, Double> entry : itemsWithPrices.entrySet()) {
            System.out.println(i + ". " + entry.getKey() + " - $" + entry.getValue());
            i++;
        }

        System.out.print("\nEnter item to add in cart: ");
        int itemChoice = scanner.nextInt();
        System.out.print("Quantity to be add:  ");
        quantity = scanner.nextInt();

        if (itemChoice >= 1 && itemChoice <= itemsWithPrices.size()) {

            ArrayList<String> items = new ArrayList<>(itemsWithPrices.keySet());
            selectedItem = items.get(itemChoice - 1);

            price = itemsWithPrices.get(selectedItem);
            price *= quantity;

            addToCart(selectedItem, quantity, price);
        } else if (itemChoice == 0) {
            System.out.println("No item added.");
            System.out.print("Would you like to add item again? (Y/N): ");
            scanner.nextLine();
            choices = scanner.nextLine();

            if (choices.equals("y")) {
                list();
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    private static void addToCart(String selectedItem, int quantity, double price) {
        System.out.println(selectedItem + " " + quantity + " packets added to cart!\nTotal cost: $" + price);
        Cart.addItemToCart(selectedItem, quantity, price);
    }
}