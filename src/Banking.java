import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.logging.Handler;
import java.io.FileReader;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.gson.Gson;


public class Banking {

    // method to create new account

    public static void createNewAcc() {

        Scanner scan = new Scanner(System.in);
        double balanace = 0;

        // Getting user legal name
        String name;
        System.out.println("Enter your first and last name with a space in-between: ");
        name = scan.nextLine();

        // Getting customer username
        String username;
        System.out.println("Kindly enter a username: ");
        username = scan.nextLine();

        //Generating user account number (It's highly improbable that the same number is generated each time so I'm not storing them for now)
        int accountNumber = 100000000 + new Random().nextInt(900000000);

        //Getting user deposit
        double deposit;
        System.out.println("Kindly enter your deposit amount to open your account: ");
        deposit = scan.nextDouble();
        balanace = balanace + deposit;

        //Storing in JSONArray [Full Name, AccountNumber, Balance]

        //JSONArray array = new JSONArray();
        //array.put(name);
        //array.put(accountNumber);
        //array.put(balanace);

        //Storing in JsonObject

        JSONObject customerData;
        customerData = new JSONObject();
        customerData.put("username", username);
        customerData.put("fullName", name);
        customerData.put("accNumber", accountNumber);
        customerData.put("balance", deposit);


        System.out.println(customerData);



        //Writing the Json to file

        FileWriter file = null;
        try {


            file = new FileWriter("/Users/baidench/Documents/Github/BankingProject/banking.txt", true);
            file.write(customerData.toString() + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {

            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }


    public static void depositAmount(){

        // Searching for user data
        String searchUser;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username: ");
        searchUser = sc.nextLine();

        int deposit;

        StringBuilder sb = new StringBuilder();


        //Searching data for username and getting the deposit
        try
        {
            FileInputStream file = new FileInputStream("/Users/baidench/Documents/Github/Banking/banking.txt");
            Scanner scan = new Scanner(file);


            while(scan.hasNextLine())
            {
                final String line = scan.nextLine();
                if(line.contains(searchUser)){
                    JSONObject customer = new JSONObject(line);

                    int balance =  customer.getInt("balance");
                    String name = customer.getString("fullName");
                    System.out.println(name + ", your current balance is: " + balance);
                    System.out.println("How much do you want to deposit? : ");
                    deposit = sc.nextInt();


                    customer.remove("balance");
                    customer.put("balance", balance + deposit);
                    JSONObject newCustomerData = customer;
                    //String newLine = line.replace(customer.toString(), newCustomerData.toString());
                    //line.

                    //sb.append(newCustomer);

                    System.out.println(line);


                    //scan.close();

                    //FileWriter filetoWrite = new FileWriter("/Users/baidench/Documents/Github/Banking/data.txt", true);
                    //filetoWrite.write(sb + System.lineSeparator());

                }


            }

            scan.close();


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }

    public static void withdrawAmount(){
        System.out.println("C");
    }

    public static void checkBalance(){
        System.out.println("B");
    }

    public static void deleteAccount(){
        System.out.println("D");
    }


    // MAIN METHOD FOR APPLICATION

    public static void main(String[] args) {
        System.out.println("Welcome to Baiden Bank!");
        System.out.println("");

        System.out.println("Choose one of the following services:");
        System.out.println("");

        System.out.println("1. Create new account");
        System.out.println("2. Deposit money to existing account");
        System.out.println("3. Withdraw money from account");
        System.out.println("4. Check account balance");
        System.out.println("5. Close account");
        System.out.println("");




        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();

        switch (userChoice)
        {
            case 1:
                createNewAcc();
                break;
            case 2:
                depositAmount();
                break;
            case 3:
                withdrawAmount();
                break;
            case 4:
                checkBalance();
                break;
            case 5:
                deleteAccount();
                break;

        }





    }

}
