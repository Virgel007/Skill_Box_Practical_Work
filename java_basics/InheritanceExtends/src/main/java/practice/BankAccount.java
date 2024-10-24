package practice;

public class BankAccount {
  protected double amount = 0;

  public BankAccount() {}
  public BankAccount(double amount) {
    this.amount = amount;
  }

  public void put(double amountToPut) {
    if (amountToPut > 0) {
      amount += amountToPut;
    } else {
      System.out.println("Error");
    }
  }

  public void take(double amountToTake) {
    if (amountToTake > 0 && amountToTake <= amount) {
      amount -= amountToTake;
    } else {
      System.out.println("Error");
    }
  }

  public double getAmount() {
    return amount;
  }
}