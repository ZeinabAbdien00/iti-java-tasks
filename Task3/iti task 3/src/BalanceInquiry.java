public class BalanceInquiry extends Transaction {
    @Override
    public double execute(Account account) {
        transactionId = 1;
        return account.getBalance();
    }

    public String currencyType(Account account) {
        return "Usd";
    }
}
