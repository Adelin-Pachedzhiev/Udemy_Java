import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;
    private final Lock lock;

    public BankAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean status = false;
        try {
            if (lock.tryLock(100, TimeUnit.MICROSECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get lock");
            }

        } catch (InterruptedException e) {

        }
        System.out.println("Transaction status = " + status);

    }

    public void withdraw(double amount) {
        boolean status = false;

        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get lock");
            }
        }catch(InterruptedException e ){

        }
        System.out.println("Transaction status = " + status);


    }

    public double getBalance() {
        return balance;
    }

    public void printAccountNumber() {
        System.out.println("Account number: " + accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
