import java.util.Scanner;

public class Main {
    public static int transactionId = 0;
    static Withdraw withdraw = new Withdraw();;
    static Deposit   deposit = new Deposit();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Account Details");
        Account account = new Account();
        System.out.println("Enter Your Account Name");
        account.setOwnerName(scanner.nextLine());
        System.out.println("Enter Your Account Number");
        account.setAccountNumber(scanner.nextInt());
        System.out.println("Enter Your Balance");
        account.setBalance(scanner.nextInt());
        loops:
        while (true) {
            System.out.println("-Press 2 to deposit\n" +
                    "-Press 3 to withdraw\n" +
                    "-Press 4 to show current balance\n" +
                    "-Press 5 to cancel last transaction\n" +
                    "-Press 6 to exit");
            int number = scanner.nextInt();
            switch (number) {
                case 2:
                    deposit(scanner, account);
                    break;
                case 3:
                    withDraw(scanner, account);
                    break;
                case 4:
                    System.out.println("Your Current Balance" + account.getBalance());
                case 5:
                    cancel(account);
                    break;
                case 6:
                    break loops;

            }
        }
        System.out.println("You Are Welcome ...");
    }

    private static void cancel(Account account) {
        if (Withdraw.transactionId == transactionId) {
            System.out.println(withdraw.cancelTransaction(account));
        } else if (Deposit.transactionId ==transactionId) {
            System.out.println(deposit.cancelTransaction(account));
        }
        System.out.println();

    }

    private static void withDraw(Scanner scanner, Account account) {
        transactionId = 2;
        System.out.println("Enter Your Required Amount");
        withdraw.amount = scanner.nextInt();
        System.out.println("New Balance= " + withdraw.execute(account));
    }

    private static void deposit(Scanner scanner, Account account) {
        transactionId = 3;
        System.out.println("Enter Your Required Amount");
        deposit.amount = scanner.nextInt();
        System.out.println("New Balance= " + deposit.execute(account));

    }
}