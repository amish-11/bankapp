import java.util.UUID;

public class HDFCAccount implements BankAccountInterface{

    private String name;
    private String accountNo;
    private String password;
    private double balance;
    final String IFSCCode = "HDFC374873";
    final double rateOfInterest = 7.1;
    //default constructor
    public HDFCAccount() {
    }
    //parametrized constructor
    public HDFCAccount(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    @Override
    public String fetchBalance(String password) {

        if(this.password.equals(password))
            return "Your balance is: "+this.balance;
        return "Incorrect password!!";
    }

    @Override
    public String addMoney(double amount) {

        this.balance += amount;
        return "Amount added successfully. New balance is : "+this.balance;
    }

    @Override
    public String withdrawMoney(double amount, String password) {

        if(this.password.equals(password)) {
            if(this.balance < amount){
                return "Insufficient Balance!!";
            }
            this.balance -= amount;
            return "Amount deducted successfully. New balance : "+this.balance;
        }
            return "Incorrect Password!!";
    }

    @Override
    public String changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)){
            this.password = newPassword;
            return "Password changed successfully.";
        }
        return "Incorrect Password!!";
    }



    @Override
    public double calculateInterest(int year) {
        return (this.balance*year*rateOfInterest)/100.0;
    }

    @Override
    public String toString() {
        return "HDFCAccount{" +
                "name='" + name + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", IFSCCode='" + IFSCCode + '\'' +
                ", rateOfInterest=" + rateOfInterest +
                '}';
    }
}
