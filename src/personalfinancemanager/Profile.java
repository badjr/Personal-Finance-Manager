package personalfinancemanager;

import java.util.List;

/**
 *
 * @author Geek Squad
 */

/**
 * The Profile is an instance of a logged in user with a unique user ID, user
 * name, and Lists of transactions, bills, and debts.
 */
public class Profile {
    private int userID;
    private String userName;
    private List transactions;
    private List bills;
    private List debts;
//    private TransactionsDB tdb;
//    private BudgetDB bdb;
    
//    //Constructors
//    public Profile(long UserID, TransactionDB tdb, BudgetDB bdb) {}
    public Profile(int userID, String userName, List transactions
            /*, List bills, List debts*/
            ) {
        this.userID = userID;
        this.userName = userName;
        this.transactions = transactions;
//        this.bill = Bill;
//        this.debt = Debt;
    }
    
    public Profile(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
//        this.bill = Bill;
//        this.debt = Debt;
    }
//    
//    public long getUserID() {}
//    public TransactionsDB getTransactionsDB() {}
//    public BudgetDB getBudgetDB() {} 
    
    public int getUserID() {
        return userID;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public List getTransactions() {
        return transactions;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public void setTransactions(List transactions) {
        this.transactions = transactions;
    }
    
    public void setBillsList(List bills) {
        this.bills = bills;
    }
    
    public void setDebtsList(List debts) {
        this.debts = debts;
    }
    
}
