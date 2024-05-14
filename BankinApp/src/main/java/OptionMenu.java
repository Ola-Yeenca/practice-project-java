import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu {

    private static final Scanner menuInput = new Scanner(System.in);
    private static final DecimalFormat moneyFormat = new DecimalFormat("'€'###,##0.00");

    private Account account;
    private static final HashMap<Integer, Integer> data = new HashMap<>();

    public OptionMenu(int customerID, int pinCode) {
        account = new Account(customerID, pinCode);
        initializeUserData(); // Initialize user data (customerID, pinCode)
    }

    private void initializeUserData() {
        // Sample user data (customerID, pinCode)
        data.put(952141, 191904);
        data.put(989947, 71976);
    }

    public void getLogin() {
        int attempts = 0;
        boolean authorized = false;

        do {
            System.out.println("Welcome to JDBanking ATM");
            System.out.print("Please enter your unique ID: ");
            int enteredCustomerID = menuInput.nextInt();

            System.out.print("Please enter your pin code: ");
            int enteredPinCode = menuInput.nextInt();

            if (data.containsKey(enteredCustomerID) && data.get(enteredCustomerID) == enteredPinCode) {
                authorized = true;
                account.setCustomerID(enteredCustomerID); // Set customer ID for the session
                account.setPinCode(enteredPinCode); // Set pin code for the session
                getAccountType(); // Display account type selection menu
            } else {
                System.out.println("Invalid credentials. Please try again.");
                attempts++;
            }
        } while (!authorized && attempts < 3);

        if (!authorized) {
            System.out.println("Too many failed login attempts. Exiting...");
        }
    }

    public void getAccountType() {
        int selection;

        do {
            System.out.println("Please select the Account you want to access: ");
            System.out.println("1. Checkings Account");
            System.out.println("2. Savings Account");
            System.out.println("3. Exit");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    showCheckingsMenu();
                    break;
                case 2:
                    showSavingsMenu();
                    break;
                case 3:
                    System.out.println("Thank you for choosing us. Bye!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (selection != 3);
    }

    private void showCheckingsMenu() {
        int selection;

        do {
            System.out.println("***** CHECKINGS ACCOUNT *****");
            System.out.println("1. View Checkings Balance");
            System.out.println("2. Make an internal transfer to  savings account");
            System.out.println("3. Make a Withdrawal");
            System.out.println("4. Make a Deposit");
            System.out.println("5. Exit");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Checkings Account Balance: " + moneyFormat.format(account.getCheckingsBalance()));
                    break;
                case 2:
                    account.transferFromCheckingsToSavings();
                    break;
                case 3:
                    account.processCheckingsWithdrawal();
                    break;
                case 4:
                    account.processCheckingsDeposit();
                    break;
                case 5:
                    System.out.println("Exiting Checkings Account menu.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (selection != 5);
    }

    private void showSavingsMenu() {
        int selection;

        do {
            System.out.println("***** SAVINGS ACCOUNT *****");
            System.out.println("1. View Savings Balance");
            System.out.println("2. Apply for a Loan");
            System.out.println("3. E-Transfer");
            System.out.println("4. Exit");

            selection = menuInput.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Savings Account Balance: " + moneyFormat.format(account.getSavingsBalance()));
                    break;
                case 2:
                    account.getLoanForm();
                    break;
                case 3:
                    System.out.println("E-Transfer service is not available.");
                    break;
                case 4:
                    System.out.println("Exiting Savings Account menu.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        } while (selection != 4);
    }
}
