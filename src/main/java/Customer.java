

import java.util.ArrayList;

public class Customer {
    private String customername;
    private ArrayList<Double> transaction;

    public Customer(String customername) {
        this.customername = customername;
        this.transaction = new ArrayList<Double> ();
    }
    public Double addtransaction (double transactioninput) {
        transaction.add(transactioninput);
        return transactioninput;
    }
    public static Customer createCustomer (String name){
        return new Customer(name);
    }
    public String getCustomername() {
        return customername;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }



}