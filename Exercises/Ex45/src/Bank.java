import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initTransaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }
        return branch.newCustomer(customerName, initTransaction);

    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transactionAmount) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        return branch.addCustomerTransaction(customerName,transactionAmount);

    }

    private Branch findBranch(String branchName) {
        Branch branch = null;
        for (Branch value : branches) {
            if (value.getName().equals(branchName)) {
                branch = value;
                break;
            }
        }
        return branch;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            return false;
        }

        ArrayList<Customer> customers = branch.getCustomers();
        System.out.println("Customer details for branch " + branchName);
        for (int i = 0; i < customers.size(); i++) {
            ArrayList<Double> transactions = customers.get(i).getTransactions();
            System.out.println("Customer: " + customers.get(i).getName() + "[" + (i + 1) + "]");
            if(printTransactions) {
                System.out.println("Transactions");
                for (int y = 0; y < transactions.size(); y++) {
                    System.out.println("[" + (y + 1) + "]  Amount " + transactions.get(y));
                }
            }
        }

        return true;
    }
}
