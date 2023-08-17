public class Main {
    public static void main(String[] args) {

        HDFCAccount VivekAcc = new HDFCAccount("Vivek","vivek123",2000);
        System.out.println(VivekAcc); // printed the attributes via toString

        System.out.println(VivekAcc.fetchBalance("ransom"));
        System.out.println(VivekAcc.fetchBalance("vivek123"));

        //add money
        System.out.println(VivekAcc.addMoney(100000));

        //withdraw
        System.out.println(VivekAcc.withdrawMoney(200000,"vivek123"));
        System.out.println(VivekAcc.withdrawMoney(50000,"vivek123"));
        System.out.println(VivekAcc.withdrawMoney(50000,"vivek13"));

        //change password
        System.out.println(VivekAcc.changePassword("vivek123","vivek456"));
        System.out.println(VivekAcc.fetchBalance("vivek456"));

        //calculate interest
        System.out.println("Interest for 5 years on current balance will be "+VivekAcc.calculateInterest(5));
    }
}