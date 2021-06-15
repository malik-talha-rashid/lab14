package lab14;

import java.io.*;
import java.util.Scanner;

public class Runner implements Serializable{
    public static void main(String[] args) {
        Account[] accountArray = new Account[10];
        ObjectOutputStream oos = null;

        try{
            oos = new ObjectOutputStream(new FileOutputStream("accountInfo"));
            accountArray[0] = new Account("Customer1", 123456, 43000);
            accountArray[1] = new Account("Customer2", 234567, 22400);
            accountArray[2] = new Account("Customer3", 313276, 120530);
            accountArray[3] = new Account("Customer4", 408532, 45780);
            accountArray[4] = new Account("Customer5", 559351, 98900);
            accountArray[5] = new Account("Customer6", 608452, 145000);
            accountArray[6] = new Account("Customer7", 716740, 67400);
            accountArray[7] = new Account("Customer8", 812538, 150000);
            accountArray[8] = new Account("Customer9", 903541, 35000);
            accountArray[9] = new Account("Customer10", 147942, 50000);

            oos.writeObject(accountArray);
        }catch (IOException e1){
            e1.printStackTrace();
        }

        finally {
            try {
                if(oos != null){
                    oos.close();
                }
            }catch (IOException e2){
                e2.printStackTrace();
            }
        }
        withdraw(4000,accountArray);
        deposit(4000,accountArray);
        transfer(4000,accountArray);
        balanceinquiry(accountArray);

    }

    public static int whichAccount(Account[] array){
        Scanner input = new Scanner(System.in);
        int i = -1,j;
        System.out.println("Enter the account number: ");
        int accNoToFind = input.nextInt();
        try{
            for(i = 0; i < array.length; i++){
                j = array[i].getAccountNo();
                if (j == accNoToFind){
                    break;
                }
            }
            return i;
        }catch (Exception e5){
            e5.printStackTrace();
        }
        return i;
    }

    public static void writeToFile(Account[] array){
        ObjectOutputStream oos2 = null;
        try{
            oos2 = new ObjectOutputStream(new FileOutputStream("accountInfo"));
            oos2.writeObject(array);
        }catch (IOException e3){
            e3.printStackTrace();
        }
        finally {
            try {
                if(oos2 != null){
                    oos2.close();
                }
            }catch (IOException e4){
                e4.printStackTrace();
            }
        }
    }

    public static void withdraw(double withdrawAmount, Account[] array){
        int accNo = whichAccount(array);
        double bal = array[accNo].getBalance();
        bal = bal - withdrawAmount;
        array[accNo].setBalance(bal);
        System.out.println(withdrawAmount + " withdrawn from " + array[accNo].getAccountOwner() + "'s account. Account no: " + array[accNo].getAccountNo());
        writeToFile(array);
    }
    public static void deposit(double depositAmount, Account[] array){
        int accNo = whichAccount(array);
        double bal = array[accNo].getBalance();
        bal = bal + depositAmount;
        array[accNo].setBalance(bal);
        System.out.println(depositAmount + " deposited to " + array[accNo].getAccountOwner() + "'s account. Account no: " + array[accNo].getAccountNo());
        writeToFile(array);
    }
    public static void transfer(double transferAmount, Account[] array){
        int i = -1,j;
        int fromAcc = whichAccount(array);
        double bal1 = array[fromAcc].getBalance();
        bal1 = bal1 - transferAmount;
        array[fromAcc].setBalance(bal1);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the account number to which money is to be transferred: ");
        int toAcc = input.nextInt();
        try{
            for(i = 0; i < array.length; i++){
                j = array[i].getAccountNo();
                if (j == toAcc){
                    break;
                }
            }
        }catch (Exception e5){
            e5.printStackTrace();
        }
        double bal2 = array[i].getBalance();
        bal2 = bal2 + transferAmount;
        array[i].setBalance(bal2);
        System.out.println(transferAmount + " transferred from " + array[fromAcc].getAccountOwner() + "'s account. Account no: " + array[fromAcc].getAccountNo() + " to " + array[i].getAccountOwner() + "'s account. Account no: "+ array[i].getAccountNo());
        writeToFile(array);
    }
    public static void balanceinquiry(Account[] array){
        int accNo = whichAccount(array);
        double bal = array[accNo].getBalance();
        System.out.println("Current balance is: " + bal);
    }
}