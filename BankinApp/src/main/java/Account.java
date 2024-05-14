import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerID;
    private int pinCode;
    private double checkingsBalance = 0;
    private double savingsBalance = 0;

    private Scanner input = new Scanner(System.in);
    private final DecimalFormat moneyFormat = new DecimalFormat("'€'###,##0.00");

    // Constructor
    public Account(int customerID, int pinCode) {
        this.customerID = customerID;
        this.pinCode = pinCode;
    }

    /// Setters
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public double getCheckingsBalance() {
        return checkingsBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    // Method to process checking deposit
    public void processCheckingsDeposit() {
        System.out.println("Enter the amount you want to deposit into Checkings:");
        double amount = input.nextDouble();
        if (amount >= 0) {
            checkingsBalance += amount;
            System.out.println("Deposit into Checkings successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to process checking withdrawal
    public void processCheckingsWithdrawal() {
        System.out.println("Enter the amount you want to withdraw from Checkings:");
        double amount = input.nextDouble();
        if (checkingsBalance >= amount && amount >= 0) {
            checkingsBalance -= amount;
            System.out.println("Withdrawal from Checkings successful!");
        } else {
            System.out.println("Insufficient funds or invalid amount in Checkings.");
        }
    }

    // Method to process savings deposit
    public void processSavingsDeposit() {
        System.out.println("Enter the amount you want to deposit into Savings:");
        double amount = input.nextDouble();
        if (amount >= 0) {
            savingsBalance += amount;
            System.out.println("Deposit into Savings successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to process savings withdrawal
    public void processSavingsWithdrawal() {
        System.out.println("Enter the amount you want to withdraw from Savings:");
        double amount = input.nextDouble();
        if (savingsBalance >= amount && amount >= 0) {
            savingsBalance -= amount;
            System.out.println("Withdrawal from Savings successful!");
        } else {
            System.out.println("Insufficient funds or invalid amount in Savings.");
            applyForLoan(); // Prompt for loan application
        }
    }

    // Method to transfer funds from Checkings to Savings
    public void transferFromCheckingsToSavings() {
        System.out.println("Please enter the amount you want to transfer");
        double amount = input.nextDouble();
        if (checkingsBalance >= amount && amount >= 0) {
            checkingsBalance -= amount;
            savingsBalance += amount;
            System.out.println("Transfer from Checkings to Savings successful!");
        } else {
            System.out.println("Insufficient funds or invalid amount for transfer.");
        }
    }

    // Protected method for loan application (accessible within subclasses)
    protected void applyForLoan() {
        System.out.println("Apply for a loan?");
        System.out.println("Select 1 - Yes or 2 - No:");
        int option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("Loan application form:");
                getLoanForm(); // Accessible within the same class or subclasses
                break;
            case 2:
                System.out.println("No worries, bye!");
                break;
            default:
                System.out.println("Invalid option, please try again.");
                applyForLoan(); // Retry loan application prompt
                break;
        }
    }

    // Public method to display loan application form (accessible outside the class)
    public void getLoanForm() {
        System.out.println("Welcome to JDBanking Loan Services");

        System.out.print("Loan Amount: ");
        double loanAmount = input.nextDouble();

        // Validate loan amount
        if (loanAmount < 100 || loanAmount > 100000) {
            System.out.println("Loan amount must be between €100 and €100,000.");
            return; // Exit method if loan amount is invalid
        }

        input.nextLine(); // Consume newline
        System.out.print("Purpose of Loan: ");
        String loanPurpose = input.nextLine();

        System.out.print("Income Details: ");
        String incomeDetails = input.nextLine();

        // Display submitted loan application details
        System.out.println("\nLoan Application Details:");
        System.out.println("Loan Amount: " + moneyFormat.format(loanAmount));
        System.out.println("Purpose of Loan: " + loanPurpose);
        System.out.println("Income Details: " + incomeDetails);
        System.out.println("Thank you for applying!");

        // Additional logic to process the loan application can be added here
    }

    // Static method for handling e-transfer
    public static void getETransfer() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to JDBanking E-Transfer Services");

        System.out.println("Select from the options below for type of transfer:");
        System.out.println("1. Internal Transfer (Within accounts or registered family)");
        System.out.println("2. Local Transfer (Different bank)");
        System.out.println("3. International Transfer");

        int option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("Internal Transfer: Please specify");
                break;
            case 2:
                System.out.println("Local Transfer: Please specify");
                break;
            case 3:
                System.out.println("International Transfer: Please specify");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                getETransfer(); // Retry e-transfer option
                break;
        }
    }
}
