

import java.util.ArrayList;

public class Bank {
    private String name;
    private  ArrayList <Brench> bankBrench;

    public Bank(String name) {
        this.name = name;
        this.bankBrench = new ArrayList<Brench>();
    }
    public  static Brench addBrench (String newbrench) {

        return new Brench(newbrench);
    }


    public Boolean addb (String brench){ bankBrench.add(addBrench(brench));
        return true;
    }
    public void DeleteBrench (String name){
        bankBrench.remove(FindBrench(name));
    }

    public void move (String name, Brench tomove) {
        for (int i = 0; i < bankBrench.size(); i++) {
            if (bankBrench.get(i).fidncustomer(name) == true) {
                Customer temp = bankBrench.get(i).findContactString(name);
                tomove.addmoveC(temp);
                bankBrench.get(i).deletecustomer(name);
            }
        }
        if (tomove.finc(name)){
            System.out.println("Customer " + name + " was successfully moved");
        }
    }
    public Customer returnCustomer (String name) {
        for (int i = 0; i < bankBrench.size(); i++) {
            if (bankBrench.get(i).finc(name)) {
                Customer c =  bankBrench.get(i).findContactString(name);
                return c;
            }
            else
            {
                System.out.println("Customer not found");
                return null;
            }
        }
        return null;
    }
    public Brench returnBranch (Customer customer) {
        for (int i = 0; i < bankBrench.size(); i++) {
            bankBrench.get(i).finc(name);
            Brench b = bankBrench.get(i);
            return b;
        }
        return null;

    }


    public boolean globalsearch (String name) {
        for (int i = 0; i < bankBrench.size(); i++) {
            if (bankBrench.get(i).fidncustomer(name)) {
                return true;
            }
        }
        System.out.println("Customer not found");
        return false;

    }




    public void  viewBrenches1() {
        System.out.println("Branches");
        for (int i = 0; i < this.bankBrench.size(); i++) {
            System.out.println((i + 1) + "." + bankBrench.get(i).getBrenchname());
        }
    }


    public int FindBrench (String brenchfind) {
        for (int i = 0; i < this.bankBrench.size(); i++) {
            Brench brench = bankBrench.get(i);
            if (brench.getBrenchname().equals(brenchfind)) {
                return i;
            }
        }
        return -1;
    }

    public Brench FindBranchString (String brenchfind)
    {
        for (int i = 0; i < this.bankBrench.size(); i++) {
            Brench brench = bankBrench.get(i);
            if (brench.getBrenchname().equals(brenchfind)) {
                return brench;
            }
        }
        return null;
    }

    public ArrayList<Brench> getBankBrench() {
        return bankBrench;
    }

}
