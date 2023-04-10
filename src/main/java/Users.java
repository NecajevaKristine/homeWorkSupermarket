public class Users {
    private static String userName;
    private String userEmail;
    private String userPassword;
    private double balance;

    public Users(String userName, String userEmail, String userPassword, double balance) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.balance = balance;

    }

    public Users(String userName, double balance) {
        this.userName = userName;
        this.balance = balance;
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
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", balance=" + balance +
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
