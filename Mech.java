import java.util.ArrayList;

public class Mech{   

    Double E = 110.3; //youngs modulus for titanium
    Double p_Dens = 4500.00; // density of titanium at 300 k
    Double k = 21.9; //thermal conductivity of titanium at 300 k;        double n = 0.0; // This is the amount of moles of gas, there is in the container, typically known

    double f = 0.0; // force on bar
    double a = 0.0; // area of bar
    double sig = 0.0; // strain symbol is sigma
    double sig_giv = 0.0; // given stress value used for hooks law
    double stra_giv = 0.0; // given strain value for hooks law
    String stressUnits = "N/m^2";

    double lOrig = 0.0;
    double lNew = 0.0;
    double strain = 0.0;

    double hook = 0.0; // value given through hooks law 


    private String X; 
    public static ArrayList<Mech> getUserInput(ArrayList<Mech> dataMech, GetIn inputHelp){ 
        String X = "";
        String q ="";

        Double E = 110.3; //youngs modulus for titanium
    
        double f = 0.0; // force on bar
        double a = 0.0; // area of bar
        double sig = 0.0; // strain symbol is sigma
        double sig_giv = 0.0; // given stress value used for hooks law
        double stra_giv = 0.0; // given strain value for hooks law
        String stressUnits = "N/m^2";

        double lOrig = 0.0;
        double lNew = 0.0;
        double strain = 0.0;

        double hook = 0.0; // value given through hooks law 
    
    
            while (!X.equalsIgnoreCase("DONE")){
    
                System.out.println("Please enter if you would like to solve for STRESS, STRAIN, or HOOK law of a titanium bar or DONE to finish: ");
                X = inputHelp.getInputString();
        
                if (X.equalsIgnoreCase("STRESS")) //This executes if pressure is the null variable
                {
                    System.out.println("Please enter the Force on the bar: ");
                    f = inputHelp.getDouble();
        
                    System.out.println("Please enter the area of the bar: ");
                    a = inputHelp.getDouble();
        
                    sig = f/a; //Calculates Stress
                    System.out.println(sig);
        
                    System.out.printf("The Stress is: %g%s\n", sig, stressUnits); //Prints out the value of pressure combined with the units
                }   
                else if (X.equalsIgnoreCase( "Strain")) {  //This executes if Volume is the null variable
                    System.out.println("Please enter the orignal Length: ");
                    lOrig = inputHelp.getDouble();

                    System.out.println("Please enter the new length : ");
                    lNew = inputHelp.getDouble();
                
                    strain = (lNew-lOrig)/lOrig;
                    System.out.println(strain);
                
                    System.out.printf("The strain is (note strain is dimensionless): %g\n", strain);
                }
                else if (X.equalsIgnoreCase("HOOK")) { // This executes if Temperature is the null value
                    System.out.println("Please select if you have the value for STRESS or STRAIN: ");
                    q = inputHelp.getInputString();
                    if (q.equalsIgnoreCase("Stress")){
                        System.out.println("Please enter the given Stress value: ");
                        sig_giv = inputHelp.getDouble();

                        hook = sig_giv/E;
                        System.out.printf("The strain is : %g\n", hook);
                    }else if(q.equalsIgnoreCase("STRAIN")){
                        System.out.println("Please enter the given Strain value: ");
                        stra_giv = inputHelp.getDouble();

                        hook = E*stra_giv;
                        System.out.printf("The Stress is : %g\n", hook);
                    }
                }
                else if (!X.equalsIgnoreCase("STRESS")||(!X.equalsIgnoreCase("STRAIN"))||!X.equalsIgnoreCase("HOOK")){
                    System.out.println("Please enter STRESS, STRAIN, or HOOK");  
                    continue;               
                }
                
                if (!X.equalsIgnoreCase("DONE")){
                    dataMech.add(new Mech(sig, strain, hook, X));
                    
                } 
            }
            return dataMech;
    }
    
    
    public Mech(){
    sig = 5.0; // This is the amount of moles of gas, there is in the container, typically known
    strain = 4.0; // Pressure
    hook = 22.0; // Volume
    X = "Stress"; /* This stores the missing variable as a string, and is used in the if statement to know which equation to
            for finding the missing value */
    }
    // Intiliazes constructor for user input
        public Mech(double stress, double delta, double hooks, String s){
            sig = stress;
            strain = delta;
            hook = hooks;
            X = s;
        }
        public void setStress(Double st){
            sig=st;
        }
        public void setStrain(Double eps){
            strain=eps;
        }
        public void setHook(Double hk){
            hook=hk;
        }
        public void setX(String xs){
            X = xs;
        }
        public double getStress(){
            return sig;
        }
        public double getStrain(){
        return strain;
        }
        public double getHook(){
            return hook;
        }
        public String getMiss(){
            return X;
        }
        public String toString(){
            String nm = String.format("%.3f N/m^2 | %.3f | %.3f | Solved for %s", sig,strain,hook,X.toUpperCase());
            return nm;
            
        }
    }
        
    
    