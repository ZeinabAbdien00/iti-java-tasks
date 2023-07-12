public class Deposit extends Transaction implements Rollback {

    public double amount;

    @Override
    public double execute(Account account) {
        transactionId = 3;
        return account.getBalance() + amount;
    }

    @Override
    public double cancelTransaction(Account account) {
        return account.getBalance() - amount;
    }
}

