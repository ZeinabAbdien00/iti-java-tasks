public class Withdraw extends Transaction implements Rollback {
    public double amount;
    @Override
    public double execute(Account account) {
        transactionId = 2;

        return account.getBalance() - amount;
    }

    @Override
    public double cancelTransaction(Account account) {
        return account.getBalance() + amount;
    }
}
