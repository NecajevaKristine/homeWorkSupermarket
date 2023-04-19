import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Supermarket {
    private Integer id;
    public String users;
    public String products;

    // Keep track of products, users, and transactions
    private ArrayList<Products> product;
    private ArrayList<Users> user;
    private ArrayList<Transactions> transaction;

    public Supermarket() {
        this.product = new ArrayList<Products>();
        this.user = new ArrayList<Users>();
        this.transaction = new ArrayList<Transactions>();
    }



    public void addProduct(Products product) {
        // Add a new product to the list of products
        this.product.add(product);
    }

    public void registerUser(Users user) {
        // Register a new user by adding them to the list of users
        this.user.add(user);
    }

    public void buyProduct(Users user, Products product) {
        // Check if the user has enough money to buy the product
        if (user.getBalance() >= product.getPrice()) {
            // Deduct the price of the product from the user's balance
            user.setBalance(user.getBalance() - product.getPrice());
            // Add a new transaction to the list of transactions
            Transactions transaction = new Transactions();
            this.transaction.add(transaction);
            System.out.println("Transaction successful!");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void generateReports() {
        // Print a report of all transactions
        for (Transactions transaction : this.transaction) {
            System.out.println(transaction);
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Show menu options
            System.out.println("Welcome to the Supermarket!");
            System.out.println("1. Register as a new user");
            System.out.println("2. Buy a product");
            System.out.println("3. Generate a report");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            // Handle user input
            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    System.out.print("Enter your balance: ");
                    double balance = scanner.nextDouble();
                    String userEmail;
                    String userPassword;
                    Users user = new Users(name, balance);
                    this.registerUser(user);
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    name = scanner.next();
                    System.out.print("Enter the name of the product: ");
                    String productName = scanner.next();
                    // Find the user and product objects
                    user = null;
                    for (Users u : this.user) {
                        if (u.getUserName().equals(name)) {
                            user = u;
                            break;
                        }
                    }
                    Products product = null;
                    for (Products p : this.product) {
                        if (p.getProductName().equals(productName)) {
                            product = p;
                            break;
                        }
                    }
                    // Buy the product if both user and product exist
                    if (user != null && product != null) {
                        this.buyProduct(user, product);
                    } else {
                        System.out.println("User or product not found!");
                    }
                    break;
                case 3:
                    this.generateReports();
                    break;
                case 4:
                    System.out.println("Thank you for using the Supermarket!");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            scanner.close();
        }

    }


    public void addProducts(Products product) {
    }

    public void addUsers() {
    }


    private class Transactions {
    }

}