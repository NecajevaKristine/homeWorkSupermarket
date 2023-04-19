import java.sql.Timestamp;

public class Products {
    private Integer id;
    private String productName;
    private double productPrice;
    private double productWeight;
    private int productQuantity;
    private double cost;
    private int sold;

    private Timestamp createdAt;
    private Timestamp updateAt;


    public Products(String productName, double productPrice, double productWeight) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
        this.productQuantity = productQuantity;
        this.cost = cost;
        this.sold = sold;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Products(String productName, double productPrice, double productWeight, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productWeight = productWeight;
        this.productQuantity = productQuantity;
        this.cost = cost;
        this.sold=0;
    }

    public void buy (int productQuantity){
        if (productQuantity<=this.productQuantity){
            this.productQuantity-=productQuantity;
            this.sold+=productQuantity;
            System.out.println("Purchase " + productQuantity + "" +
                    this.productName + "(s) for EUR" +
                    productQuantity * this.productPrice);

        }else{
            System.out.println("Sorry, we don't have enough " + this.productName + "(s) in stock.");
        }
    }

    public boolean isSoldOut(){
        return this.productQuantity==0;
    }

    public void salesReport(){
        System.out.println("Sales report for " + this.productName + ":");
        System.out.println("Total sold: " + this.sold);
        System.out.println("Total revenue: EUR" + this.sold * this.productPrice);
        System.out.println("Total cost: EUR" + this.sold * this.cost);
        System.out.println("Total profit: EUR" + (this.sold * this.productPrice - this.sold * this.cost));
    }

    public double getPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getWeight() {
        return productWeight;
    }

    public int getQuantity() {
        return productQuantity;
    }
}
