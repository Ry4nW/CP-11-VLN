import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    // Getters and setters.

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    // Requires: Nothing
    // Modifies: this
    // Effects: Prints out an instance of our {Withdraw} class in our intended format.
    public String toString(){
        return "Withdrawal of: " + amount + " | Date: " + date + " | From account: " + account;
    }
}
