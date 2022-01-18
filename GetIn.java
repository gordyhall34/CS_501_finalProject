import java.util.Scanner;
public class GetIn{
    Scanner keyboard = new Scanner(System.in);

public double getDouble(){

    double retVal; 
    while(true){
        try{
            retVal = keyboard.nextDouble(); 
            break;
        }
        catch(Exception e){
            System.out.println("Please enter a value that is a double");
            keyboard.next();
        }
    }
    return retVal;
    
}

public String getInputString(){
    String retVal; 

    while(true){
        try{
            retVal = keyboard.next(); 
            break;
        }
        catch(Exception e){
            System.out.println("Please enter a variable keyword");
            
        }
    }
    return retVal;
}
}