package practice;

public class CardAccount extends BankAccount {
    public CardAccount() {}
    public CardAccount(double amount) {
        super(amount);
    }

    @Override
    public void take(double amountToTake) {
        double commission = 0.01;
        commission *= amountToTake;
        super.take(amountToTake + commission);
    }
}