import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdrawals = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private final double savingRate = 0.1;
    private final String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";

    Customer() {
        this.name = "Demo";
        this.checkBalance = 100;
        this.savingBalance = 100;
        this.accountNumber = (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000);
    }

    Customer(String name, double checkDeposit, double savingDeposit) {
        this.name = name;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.accountNumber = (int) (Math.random() * (9000000 - 1000000 + 1) + 1000000);
    }

    // Requires: {double} Amount of money being deposited, {Date} Current date + time,
    // {String} CHECKING/SAVING account for this transaction.
    // Modifies: this and checkBalance/savingBalance.
    // Effects: Creates a new {Deposit} class for a CHECKING/SAVING account and adds deposited amount
    // into Customer's {checkBalance}/{savingBalance} and returns new balance. Else, returns -1 if
    // account type is invalid.
    public double deposit(double amt, Date date, String account) {

        if (account.equalsIgnoreCase("checking")){
            Deposit deposit = new Deposit(amt, date, CHECKING);
            checkBalance += amt;
            deposits.add(deposit);
            return checkBalance;
        } else if (account.equalsIgnoreCase("saving")) {
            Deposit deposit = new Deposit(amt, date, SAVING);
            savingBalance += amt;
            deposits.add(deposit);
            return savingBalance;
        } else {
            return -1;
        }

    }

    // Requires: {double} Amount of money being withdrawn, {Date} Current date + time, {String} CHECKING/SAVING
    // account for this transaction.
    // Modifies: this and checkBalance/savingBalance.
    // Effects: Creates a new {Withdraw} class for a CHECKING/SAVING account and withdraws amount of money from
    // the amount already there, returns new balance. Else, if withdrawal is an overdraft, cancels transaction and
    // returns original amount. Else, returns -1 if account type is invalid.
    public double withdraw(Customer customer, double amt, Date date, String account){

        if (account.equalsIgnoreCase("checking")) {

            Withdraw withdrawal = new Withdraw(amt, date, CHECKING);

            if (checkOverdraft(amt, CHECKING, customer)) {
                return checkBalance;
            }

            withdrawals.add(withdrawal);

            checkBalance -= amt;
            return checkBalance;

        } else if (account.equalsIgnoreCase("saving")) {

            Withdraw withdrawal = new Withdraw(amt, date, SAVING);

            if (checkOverdraft(amt, SAVING, customer)) {
                return savingBalance;
            }

            withdrawals.add(withdrawal);

            savingBalance -= amt;
            return savingBalance;

        } else {
            return -1;
        }

    }

    // Requires: {double} Amount being withdrawn, {account} CHECKING/SAVING account.
    // Modifies: this.
    // Effects: If withdrawal of amount from CHECKING/SAVING account is an overdraft, return true.
    // Else, return false.
    private static boolean checkOverdraft(double amt, String account, Customer customer){

        if (account.equalsIgnoreCase("checking")) {

            return (customer.checkBalance - amt) < 0;

        } else if (account.equalsIgnoreCase("saving")) {

            return (customer.savingBalance - amt) < 0;

        } else {
            return false;
        }

    }

    // Modifies: this
    // Effects: Prints out all {Deposit}s in ArrayList {deposits}.
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    // Modifies: this
    // Effects: Prints out all {Withdraw}als in ArrayList {withdraws}.
    public void displayWithdraws(){
        for(Withdraw w : withdrawals){
            System.out.println(w);
        }
    }

    // All setters/getters.

    public int getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdrawals;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double getSavingRate() {
        return savingRate;
    }

    public String getName() {
        return name;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setDeposit(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public void setWithdraws(ArrayList<Withdraw> withdraws) {
        this.withdrawals = withdraws;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public int getDepositsLength() { return deposits.size(); }

    public int getWithdrawalsLength() { return withdrawals.size(); }


    public static void main(String[] args) {

        Date date = new Date();
        Customer John = new Customer("John Smith", 150, 150);

        System.out.println(John.deposit(150, date, SAVING));
        System.out.println(John.deposit(150, date, SAVING));
        System.out.println(John.withdraw(John,150, date, SAVING));
        System.out.println(John.withdraw(John, 151, date, CHECKING));
        John.displayDeposits();
        John.displayWithdraws();

    }
}
