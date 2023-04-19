import java.sql.Timestamp;
import java.util.UUID;

public class Users {
    private static String userName;
    private String userEmail;
    private String userPassword;
    private double balance;
    private Integer id;

    private Timestamp createdAt;
    private Timestamp updateAt;

    public Users(String userName, String userEmail, String userPassword, double balance) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.balance = balance;

    }

    public Users(String userEmail, String userPassword, double balance, Integer id, Timestamp createdAt, Timestamp updateAt) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.balance = balance;
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Users(String userName, double balance) {
        }

    public Users() {

    }


    public static String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        Users.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void addFunds (double amount){
        if (balance>=amount){
            balance-=amount;
            System.out.println("Purchase successful");
        }else{
            System.out.println("Not enough balance");
        }
    }


    @Override
    public String toString() {
        return "Users{" +
                "userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", balance=" + balance +
                ", id=" + id +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

class SalesRep extends Users{
    public SalesRep(String userName, String userEmail, String userPassword, double balance) {
        super(userName, userEmail, userPassword, balance);
    }

    public SalesRep() {
        super();
    }
}

class Owner extends Users {
    public Owner(String userName, String userEmail, String userPassword, double balance) {
        super(userName, userEmail, userPassword, balance);
    }

    public Owner() {
        super();
    }
}
class Buyer extends Users {
    public Buyer(String userName, String userEmail, String userPassword, double balance) {
        super(userName, userEmail, userPassword, balance);
    }

    public Buyer() {
        super();
    }
}
