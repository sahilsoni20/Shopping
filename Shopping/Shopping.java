import java.util.*;

public class Shopping {

    static Scanner scanner = new Scanner(System.in);
    static int choice;
    static String choices;

    public static void main(String[] args) {

        System.out.println("\n\t~LuLu Mall~");
        System.out.println("  --World of Happiness--\n");

        int choice;

        while (true) {
            System.out.println("1. For new customer Sign-Up");
            System.out.println("2. For existing customer Sign-In");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                Sign.signUp();
            } else if (choice == 2) {
                if (Sign.signIn()) {
                    commandMenu();
                }
            } else {
                System.err.println("Invalid Choice.");
                System.exit(0);
                break;
            }
        }
    }

    public static void commandMenu() {
        while (true) {
            System.out.println("Command Menu\n");
            System.out.println("List:- Shows the list of the products");
            System.out.println("Cart:- Shows the item in cart");
            System.out.println("Add:- Add more items if you want");
            System.out.println("Rem:- Remove the item from the cart");
            System.out.println("Exit:- Exit from Command Menu");
            System.out.print("\nWrite your choice : ");
            choices = scanner.nextLine();

            switch (choices) {
                case "list":
                    List.list();
                    break;

                case "cart":
                    Cart.cart(Sign.fullName, Sign.phoneNum);
                    break;

                case "add":
                    Add.add();
                    break;

                case "rem":
                    // Cart.addCartItem();
                    Remove.remove();
                    break;

                case "exit":
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }
}