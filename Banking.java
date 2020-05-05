import java.util.Random;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONArray;

public class Banking {

    // method to create new account

    public static void createNewAcc(){

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

        JSONArray array = new JSONArray();
        array.put(name);
        array.put(accountNumber);
        array.put(balanace);

        //Storing in JsonObject

        JSONObject customerData;
        customerData = new JSONObject();
        customerData.put(username, array);

        System.out.println(customerData);




    }

    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String name = sc.nextLine();

        createNewAcc();



    }

}


