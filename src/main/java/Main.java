import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supermarket supermarket = new Supermarket();
        String userEmail;
        String userPassword;
        Buyer buyer = new Buyer ();
        SalesRep salesRep = new SalesRep();
        Owner owner = new Owner();

        System.out.println("Email: ");
        userEmail = scanner.nextLine();

        System.out.println("Password: ");
        userPassword = scanner.nextLine();

        if (userEmail.equals(salesRep.getUserEmail()) && userPassword.equals(salesRep.getUserPassword())) {
            while (true) {
                System.out.println("Sales Representative Menu");
                System.out.println("1. Add product");
                System.out.println("2.Exit");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Product name: ");
                    String productName = scanner.nextLine();

                    System.out.println("Product price: ");
                    double productPrice = scanner.nextDouble();

                    System.out.println("Product quantity: ");
                    int productQuantity = scanner.nextInt();

                    scanner.nextLine();

                    Products product = new Products(productName, productPrice, productQuantity);
                    supermarket.addProducts(product);
                    System.out.println("Product added successfully");

                } else if (choice == 2) {
                    break;

                } else {
                    System.out.println("Invalid choice");
                }
            }

        } else if (userEmail.equals(owner.getUserEmail()) && userPassword.equals(owner.getUserPassword())) {
            while (true) {
                System.out.println("Owner Menu");
                System.out.println("1. Add product");
                System.out.println("2.Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    System.out.println("Product name: ");
                    String productName = scanner.nextLine();

                    System.out.println("Product price: ");
                    double productPrice = scanner.nextDouble();

                    System.out.println("Product quantity: ");
                    int productQuantity = scanner.nextInt();

                    scanner.nextLine();

                    Products product = new Products(productName, productPrice, productQuantity);
                    supermarket.addProducts(product);
                    System.out.println("Product added successfully");

                } else if (choice == 2) {
                    break;

                } else {
                    System.out.println("Invalid choice");
                }
            }
        } else {
            System.out.println("Invalid email or password");
        }
        scanner.close();

    }


}
