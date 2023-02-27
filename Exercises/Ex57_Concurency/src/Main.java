public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000, "acNum");

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300);
                account.withdraw(50);
                System.out.println("from 1: " + account.getBalance());

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100);
                System.out.println("from 2: " + account.getBalance());
            }
        }).start();

        System.out.println("at the end :" + account.getBalance());


    }
}