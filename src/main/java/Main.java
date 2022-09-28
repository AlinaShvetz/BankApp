import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bankinEurope = new Bank("Deutche Bank");

    public static void main(String[] args) {
        boolean quite = false;
        startBankApp();
        printActions();

        while (!quite) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.out.println("\nShutting down...");
                    quite = true;
                    break;
                case 1:
                    bankinEurope.viewBrenches1();
                    break;
                case 2:
                    GlobalSearchContact();
                    break;
                case 3:
                    UpdateBranche();
                    break;

                case 4:
                    UpdateContact();
                    break;
                case 5:
                    printActions();

            }
            System.out.println("Enter an action:");

        }


    }
    public static void startBankApp(){
        System.out.println("BankApp running...");

    }

    public static void printActions (){
        System.out.println("\n Available actions  ");
        System.out.println("\t 0 - Shut down");
        System.out.println("\t 1 - View available bank Branches");
        System.out.println("\t 2 - Global search contact");
        System.out.println("\t 3 - Update Branch");
        System.out.println("\t 4 - Update Contact");
        System.out.println("\t 5 - Print a list o available actions");

    }

    public static void UpdateBranche () {
        System.out.println("\n Available actions  ");
        System.out.println("\t 1 - Add a branch");
        System.out.println("\t 2 - Delete a branch");
        System.out.println("\t 3 - Find a branch");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addBrench();
                break;
            case 2:
                DeleteBrench();
                break;
            case 3:
                findBranch();
                break;
        }
    }
    public static void addBrench () {
        System.out.println("Enter Branch name: ");
        String newbrench = scanner.next();
        Brench newb = bankinEurope.addBrench(newbrench);
        bankinEurope.addb(newbrench);
        Brench bran= bankinEurope.FindBranchString(newbrench);
        System.out.println("Brench " + newb.getBrenchname() + " has been added");
        System.out.println("Do you want to add a customer to this branch?");
        System.out.println("\t 1 - Yes");
        System.out.println("\t 2 - Main menu");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter customer name: ");
                String cutstomer = scanner.next();
                System.out.println("Enter customer transaction");
                double monye = scanner.nextDouble();
                bran.addcoustomer(cutstomer, monye);
                break;
            case 2:
                printActions();
                break;
        }
    }
    public static void DeleteBrench() {
        System.out.println("Input the branch that you want to delete");
        String delBranch =scanner.next();
        if (bankinEurope.FindBrench(delBranch)<-1){
            System.out.println("No branch found");
        } else {
            bankinEurope.DeleteBrench(delBranch);
            System.out.println("The branch " + delBranch + " was succesfully deleted.");
        }
    }

    public static void findBranch (){
        System.out.println("Enter the branch name: ");
        String delBranch =scanner.next();
        if (bankinEurope.FindBrench(delBranch)==-1){
            System.out.println("No branch found");
        } else {
            System.out.println("The branch " + delBranch + " was found.");
        }

    }
    public static void UpdateContact () {
        System.out.println("\n Available actions  ");
        System.out.println("\t 1 - Add a customer");
        System.out.println("\t 2 - Add a transaction to an existing customer");
        System.out.println("\t 3 - View all list of transaction of an existing customer");
        System.out.println("\t 4 - Update a customer's name");
        System.out.println("\t 5 - View a list of customers");
        System.out.println("\t 6 - Move a customer from one branch to the other");
        System.out.println("\t 7 - Delete a customer");


        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addcustomer();
                break;
            case 2:
                addtransaction();
                break;
            case 3:
                viewtransactions ();
                break;
            case 4:
                updatecustomer();
                break;
            case 5:
                listofCustomersperBranch();
                break;
            case 6:
                moveContactoAnotherBrench();
                break;
            case 7 :
                delecustomer();
                break;
        }
    }
    public static void addcustomer (){
        System.out.println("Enter customer name: ");
        String cutstomer = scanner.next();
        System.out.println("Enter customer transaction");
        double monye = scanner.nextDouble();
        System.out.println("Enter a branch name under which the customer will be added");
        String branchname = scanner.next();
        Brench newb = bankinEurope.FindBranchString(branchname);
        newb.addcoustomer(cutstomer, monye);
    }

    public static void addtransaction (){
        System.out.println("Enter customer's name: ");
        String cutstomer = scanner.next();
        if (bankinEurope.globalsearch(cutstomer)){
            System.out.println("Enter the amount you want to add ");
            double amount = scanner.nextDouble();
            bankinEurope.returnCustomer(cutstomer).addtransaction(amount);
            System.out.println(amount + " has been added to " + cutstomer + " account.");

        } else {
            System.out.println("Customer not found");
        }

    }
    public static void viewtransactions (){
        System.out.println("Enter customer's name: ");
        String cutstomer = scanner.next();
        if (bankinEurope.globalsearch(cutstomer)){
            Customer c = bankinEurope.returnCustomer(cutstomer);
            Brench br =   bankinEurope.returnBranch(c);
            br.viewListTrnasaction(cutstomer);

        }
    }
    public static void updatecustomer () {
        System.out.println("Enter customer's name: ");
        String cutstomer = scanner.next();
        System.out.println("Enter the new name: ");
        String newname = scanner.next();
        if (bankinEurope.globalsearch(cutstomer)) {
            Customer c = bankinEurope.returnCustomer(cutstomer);
            Customer newc = Customer.createCustomer(newname);
            Brench br = bankinEurope.returnBranch(c);
            br.updatecustomer(cutstomer,newc);
            System.out.println(cutstomer + " was updated with " + newc.getCustomername());
        }
    }

    public static void MoveCustomerToAnotherBranch (){

    }
    public static void GlobalSearchContact(){
        System.out.println("Enter customer's name: ");
        String cutstomer = scanner.next();
        bankinEurope.globalsearch(cutstomer);
    }

    public static void listofCustomersperBranch (){
        System.out.println("Enter Branch name: ");
        String branch = scanner.next();
        if (bankinEurope.FindBrench(branch)==-1){
            System.out.println("No branch found");
        } else {
            Brench br = bankinEurope.FindBranchString(branch);
            System.out.println("The branch " + branch + " was found.");
            br.viewlistCUstomers();
        }

    }

    public static void moveContactoAnotherBrench () {
        System.out.println("Enter Branch name where you want to more the customer ");
        String branch = scanner.next();
        System.out.println("Enter customer's name: ");
        String cutstomer = scanner.next();
        Brench br = bankinEurope.FindBranchString(branch);
        bankinEurope.move(cutstomer,br);
    }
    public static void delecustomer () {
        System.out.println("Enter customer's name: ");
        String cutstomer = scanner.next();
        if (bankinEurope.globalsearch(cutstomer)){
            Customer c = bankinEurope.returnCustomer(cutstomer);
            Brench br =   bankinEurope.returnBranch(c);
            br.deletecustomer(cutstomer);

        }


    }
}
