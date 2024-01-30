import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sign {
    static Scanner scanner = new Scanner(System.in);
    static String fullName;
    static String phoneNum;
    static String userName, password;
    static String filePath = "Shopping.txt";
    static String line;
    static BufferedReader reader;
    static BufferedWriter writer;

    public static boolean signUp() {
        try {
            scanner.nextLine();

            System.out.print("Enter your Username: ");
            userName = scanner.nextLine();

            System.out.print("Enter your Password: ");
            password = scanner.nextLine();

            userName = userName.trim();

            boolean userNameExists = false;

            try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = fileReader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2 && parts[0].trim().equals("Username")) {
                        String existingUserName = parts[1].trim();

                        existingUserName = existingUserName.trim();

                        if (existingUserName.equals(userName)) {
                            userNameExists = true;
                            break;
                        }
                    }
                }
            }

            if (userNameExists) {
                System.out.println("\nUsername already exists! Try something different.\n");
            } else {
                try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath, true))) {
                    fileWriter.write("Username: " + userName);
                    fileWriter.newLine();
                    fileWriter.write("Password: " + password);
                    fileWriter.newLine();
                    System.out.println("\nUser registered successfully!\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading user rmation: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public static boolean signIn() {
        scanner.nextLine();
        System.out.print("\nEnter your Full Name: ");
        fullName = scanner.nextLine();

        System.out.print("Enter your Phone Number: ");
        phoneNum = scanner.nextLine();

        System.out.print("Enter your Username: ");
        userName = scanner.nextLine();

        System.out.print("Enter your Password: ");
        password = scanner.nextLine();

        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2 && parts[0].trim().equals("Username") && parts[1].trim().equals(userName)) {
                    line = reader.readLine();
                    if (line != null && line.trim().equals("Password: " + password)) {
                        System.out.println("Log-In Successful\n");
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Invalid username or password!");
        return false;
    }
}