
import java.util.ArrayList;

public class Brench {
    private String Brenchname;
    private ArrayList <Customer> customerlist;

    public Brench(String brenchname) {
        this.Brenchname = brenchname;
        this.customerlist = new ArrayList<Customer> ();
    }

    public Customer addcoustomer (String newcustomer, Double transaction) {
        Customer newcustomer1 = Customer.createCustomer(newcustomer);
        customerlist.add(newcustomer1);
        newcustomer1.addtransaction(transaction);
        System.out.println("Branch "+"<" + Brenchname + ">");
        System.out.println(newcustomer1.getCustomername() + " >> " + newcustomer1.getTransaction() );
        return newcustomer1;
    }

    public Customer addmoveC (Customer c){
        customerlist.add(c);
        return c;
    }


    public Double addtransaction (String name, Double extratransaction){
        System.out.println("Enter customer's name: ");
        if (findContact(name)==-1){
            System.out.println("There is no customer with such a name");
            return null;
        }
        else {
            System.out.println("Enter a transaction");
            findContactString(name).addtransaction(extratransaction);
            System.out.println(extratransaction + " has been added to " + name +" account.");
            return extratransaction;

        }


    }
    public Customer updatecustomer (String name, Customer newc){
        if (findContact(name)==-1) {
            System.out.println("There is no such customer in the list ");
        } else
            System.out.println(findContactString(name).getCustomername() + " was found");
        customerlist.set(findContact(name),newc);
        return newc;
    }
    public void viewlistCUstomers (){
        for (int i = 0; i<this.customerlist.size(); i++){
            Customer cust = customerlist.get(i);
            System.out.println(i+1 + "." + " " + cust.getCustomername ());
        }
    }

    public void viewListTrnasaction (String name)
    { if (findContact(name)==-1){
        System.out.println("There is no customer with such a name");
    }
    else  System.out.println("The transaction list: " + findContactString(name).getTransaction());

    }

    public boolean fidncustomer (String customer) {
        if (findContact(customer)==-1) {
            //System.out.println("There is no such customer in the list ");
            return false;
        } else
            System.out.println(findContactString(customer).getCustomername() + " was found");
        return true;
    }
    public boolean finc (String customer) {
        if (findContact(customer)==-1) {
            return false;
        } else

            return true;
    }


    public String fidncustomerBernch (String customer) {
        if (findContact(customer)==-1) {
            System.out.println("There is no such customer in the list ");

        } else
            System.out.println(findContactString(customer).getCustomername() + " was found");
        return getBrenchname();
    }
    public void deletecustomer (String name){
        if (findContact(name)==-1){
            System.out.println("There is no customer with such a name");

        } else { customerlist.remove(findContact(name));
            System.out.println(name+ " was deleted from customer list.");
        }
    }
    private int findContact(String contactN) {
        for (int i = 0; i < this.customerlist.size(); i++) {
            Customer cont = customerlist.get(i);
            if (cont.getCustomername().equals(contactN)) {
                return i;
            }
        }
        return -1;
    }
    public Customer findContactString(String contactN) {
        for (int i = 0; i < this.customerlist.size(); i++) {
            Customer cont = customerlist.get(i);
            if (cont.getCustomername().equals(contactN)) {
                return cont;
            }

        }
        return null;
    }

    public String getBrenchname() {
        return Brenchname;
    }

    public ArrayList<Customer> getCustomerlist() {
        return customerlist;
    }

}
