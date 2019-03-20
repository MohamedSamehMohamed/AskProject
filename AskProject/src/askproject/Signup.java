package askproject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner ; 
public class Signup {
   private  String FirstName ; 
   private  String LastName ; 
   private  String City ; 
   private  String UserName ; 
   private  String Password ; 
   private  int Age ;
    Signup()
    {
        FirstName = LastName = City = UserName = Password = ""; 
    }
    void GetData ()
    {
        Scanner in = new Scanner (System.in); 
        System.out.println("Enter Your Data");
        
        System.out.println("FirstName?");
        FirstName = in.next();
        in.nextLine(); 
        
        System.out.println("LasttName?");
        LastName = in.next();
        in.nextLine(); 
       
        System.out.println("City?");
        City = in.next();
        in.nextLine(); 
        
        System.out.println("Age?");
        while (true){
        try {
        Age = in.nextInt();
        in.nextLine(); 
        }catch (InputMismatchException ex )
        {
            System.out.println("Wrong Input Numbers only,Try again");
            in.nextLine();
            continue ; 
        }
        break; 
        }
        System.out.println("UserName");
        UserName = in.next(); 
        try {
        while (!UserExist())
        {
            UserName = in.next(); 
            in.nextLine();
        }
        }catch (FileNotFoundException ex )
        {
            // Nothing Its ok If no File Exist , and Loop Ends Here 
        }
        System.out.println("Password");
        Password = in.next();
        in.nextLine(); 
        try {
            StoreDateInFile ();
        } catch (FileNotFoundException ex) {
            // This Wont Happen 
        }
        
        
        
    }
    private void StoreDateInFile ()throws FileNotFoundException 
    {
        File file = new File ("Users.txt");
        ArrayList<String> UsersData = new ArrayList<> (); 
        if (file.exists()){
        try (Scanner Read = new Scanner (file)){ 
        while (Read.hasNext())
        {
            UsersData.add(Read.nextLine()); 
        }
        }
        }
        UsersData.add(UserName + " " + Password); 
        
        try (PrintWriter WriteToFile = new PrintWriter (file))
        {
            for (int i =0 ; i < UsersData.size() ;i++)
            WriteToFile.println (UsersData.get(i)); 
        }
        
        String FileName = "UsersData/" + UserName + "/" ;
        file = new File (FileName); 
        if (!file.exists())
        {
            file.mkdirs(); 
        }
        FileName +="Information.txt";
        file = new File (FileName); 
        if (file.exists())
        {
            // How This Happen ! ofcourse its the user who done that 
            // if the file exist , its not mine , so i will overwrite on it (Delete and store my data )
        }
        try (PrintWriter WriteToFile = new PrintWriter (file) )
        {
            WriteToFile.println (FirstName + " " + LastName +" " + City + " " + Age + " " + UserName + " " + Password); 
        }
        System.out.println("Done!\nWelcome " + FirstName + " To ask ");
        
    }
    boolean UserExist () throws FileNotFoundException 
    {
        File file = new File ("Users.txt"); 
        if (!file.exists())
        {
            return true ;
        }
        String CurrentUser ; 
        
        try ( Scanner Read = new Scanner (file) ){ 
        while (Read.hasNext())
        {
            CurrentUser = Read.next() ;
            if (CurrentUser.equals(UserName))
            {
                System.out.println("User Name Exist,Try different one");
                return false; 
            }
            Read.nextLine(); 
            
        }
        return true ; 
        }
    }
}
