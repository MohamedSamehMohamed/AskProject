package askproject;
import java.util.InputMismatchException;
import java.util.Scanner ; 
public class AskProject {
public static void main(String[] args) {
    int C; 
    Scanner in = new Scanner (System.in); 
    do {
    System.out.println("Welcom In Ask Project"); 
    System.out.println("1)Login.");
    System.out.println("2)Signup.");
    System.out.println("3)Exit.");
    while (true){
    try {
    C = in.nextInt(); 
    in.nextLine(); 
    }catch (InputMismatchException e)
    {
        System.out.println ("Wrong Input , Try again "); 
        // delete last input (Discard Input )
        in.nextLine() ;
        continue ; 
    }
    if (C <1 || C > 3 )
    {
        System.out.println("1:3 only");
        continue ; 
    }
    break; 
    }
    
    switch (C)
    {
        case 1 : 
        System.out.println ("Login");
        Login login = new Login(); 
        login.login();
        break;
        // Single Comment :D 
        case 2 :
        System.out.println ("Signup");
        Signup signup = new Signup(); 
        signup.GetData();
        
        break;
    }
    }while (C!=3);
    
    

    }
    
}
