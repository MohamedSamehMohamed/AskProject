package askproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    String UserName;
    String Password;

    Login() {
        UserName = Password = "";
    }

    boolean login() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Date ");
        int T = 3 ; 
        while (T!=0){
        T--; 
        System.out.println("UserName?");
        UserName = in.next();
        in.nextLine();
        System.out.println("Password?");
        Password = in.next();
        in.nextLine();
        try {
        if (CorrectData())
        {
            System.out.println("Welcome " + UserName  );
            return true ; 
        }
        }catch (FileNotFoundException ex )
        {
            
            System.out.println("No Data Saved ");
            return false   ;
        }
        if (T!=0)
        System.out.println("Wrong Data,Try again");
        }
        System.out.println("You Exceed The limit");
        return false ; 

    }

    boolean CorrectData() throws FileNotFoundException {
        File file = new File("Users.txt");
        if (!file.exists()) {
            return false;
        }
        String CurrentUser;
        String CurrentPassword ; 
        try (Scanner Read = new Scanner(file)) {
            while (Read.hasNext()) {
                CurrentUser = Read.next();
                CurrentPassword = Read.next(); 
                if (CurrentUser.equals(UserName) && CurrentPassword.equals(Password)) {
                    
                    return true;
                }
                Read.nextLine();

            }
            return false ;
        }
    }
}
