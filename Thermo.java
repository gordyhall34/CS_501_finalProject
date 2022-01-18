import java.util.ArrayList;

public class Thermo{   

private double n; 
private Double P; 
private Double V; 
private Double T; 
private String X; 

public static ArrayList<Thermo> getUserInput(ArrayList<Thermo> dataThermo, GetIn inputHelp){ 
    String X = "";
    String Punits = " Pascals";
    String Vunits = " m^3";
    String Tunits = " Kelvin";
    double R = 8.314463; // Joule x Kelvin-1 x mole (Universal gas constant)

    double n = 0.0; // This is the amount of moles of gas, there is in the container, typically known
    double P = 0.0; // Pressure
    double V = 0.0; // Volume
    double T = 0.0; // Temperature



        while (!X.equalsIgnoreCase("DONE")){

            System.out.println("Please enter the letter of the missing variable value, P (Pressure, Pascals), V (Volume, m^3), T (Temperature, Kelvin) or DONE to finish: ");
            X = inputHelp.getInputString();
            if (X.equalsIgnoreCase("P")) //This executes if pressure is the null variable
            {
                System.out.println("Please enter the given n value: ");
                n = inputHelp.getDouble();
    
                System.out.println("Please enter the V value: ");
                V = inputHelp.getDouble();
    
                System.out.println("Please input the T value: ");
                T = inputHelp.getDouble();
    
                P = (n*R*T)/V; //Calculates Pressure
                System.out.println(P);
    
                System.out.printf("The pressure is: %g%s\n", P, Punits); //Prints out the value of pressure combined with the units
            }   
            else if (X.equalsIgnoreCase( "V")) {  //This executes if Volume is the null variable
                System.out.println("Please enter the given n value: ");
                n = inputHelp.getDouble();
    
                System.out.println("Please enter the P value: ");
                P = inputHelp.getDouble();
            
                System.out.println("Please input the T value: ");
                T = inputHelp.getDouble();
            
                V = (n*R*T)/P;
                System.out.println(V);
            
                System.out.printf("The volume is: %g%s\n", V, Vunits);
            }
            else if (X.equalsIgnoreCase("T")) { // This executes if Temperature is the null value
                System.out.println("Please enter the given n value: ");
                n = inputHelp.getDouble();
    
                System.out.println("Please enter the P value: ");
                P = inputHelp.getDouble();
            
                System.out.println("Please input the V value: ");
                V = inputHelp.getDouble();
            
                T=(P*V)/(n*R);
    
                System.out.println(T);
            
                System.out.printf("The Temperature is: %g%s\n", T, Tunits);
            }
            else if (!X.equalsIgnoreCase("P")||(!X.equalsIgnoreCase("T"))||!X.equalsIgnoreCase("V")){
                System.out.println("Please enter P, T, or V");  
                continue;            
            }
            
            if (!X.equalsIgnoreCase("DONE")){
                dataThermo.add(new Thermo(n, P, V, T, X));
                
            } 
        }

        return dataThermo;
        
}

public Thermo(){
n = 5.0; // This is the amount of moles of gas, there is in the container, typically known
P = 4.0; // Pressure
V = 22.0; // Volume
T = 35.0; // Temperature
X = "P"; /* This stores the missing variable as a string, and is used in the if statement to know which equation to
        for finding the missing value */
}
// Intiliazes constructor for user input
    public Thermo(double moles, double press, double vol, double temp, String s){
        n = moles;
        P = press;
        V = vol;
        T = temp;
        X = s;
    }
    public void setMoles(Double ml){
        n = ml;
    }
    public void setPress(Double pr){
        P = pr;
    }
    public void setVol(Double vl){
        V = vl;
    }
    public void setTemp(Double tp){
        T = tp;
    }
    public void setX(String xs){
        X = xs;
    }
    public double getMoles(){
        return n;
    }
    public double getPress(){
        return P;
    }
    public double getVol(){
        return V;
    }
    public double getTemp(){
        return T;
    }
    public String getMiss(){
        return X;
    }
    public String toString(){
        String nm = String.format("%.3f Moles | %.3f Pascals | %.3f Meters cubed | %.3f Kelvin | Solved for %s", n,P,V,T,X.toUpperCase());
        return nm;
        
    }
}
    

