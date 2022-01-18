import java.util.ArrayList;

public class Heat{   

    String choice = "";
    String q ="";
    String fluxUnits = "W*m^2";
    String rateUnits = "W";
    //constants
    Double p_Dens = 4500.00; // density of titanium at 300 k
    Double k = 21.9; //thermal conductivity of titanium at 300 k;
    //variables
    Double flux = 0.0; // conduction heat flux
    Double rate = 0.0; // conduction heat rate 
    Double wallR = 0.0; //thermal resistance of a wall of specified material
    Double T = 0.0; // thermal gradient
    Double Ac = 0.0; // Cross sectional area of plate
    Double L = 0.0; // length of plate
    Double A = 0.0; //Area of wall     


    private String X; 
    public static ArrayList<Heat> getUserInput(ArrayList<Heat> dataHeat, GetIn inputHelp){ 
        //Strings for units and choices
        String X = "";
        String fluxUnits = "W*m^2";
        String rateUnits = "W";

        //constants
        Double k = 21.9; //thermal conductivity of titanium at 300 k;
        //variables
        Double flux = 0.0; // conduction heat flux
        Double rate = 0.0; // conduction heat rate 
        Double wallR = 0.0; //thermal resistance of a wall of specified material
        Double T = 0.0; // thermal gradient
        Double Ac = 0.0; // Cross sectional area of plate
        Double L = 0.0; // length of plate
        Double A = 0.0; //Area of wall
    

    
    
            while (!X.equalsIgnoreCase("DONE")){
    
                System.out.println("Please enter if you would like to solve for the heat FLUX, RATE, or the thermal resistance of a WALL or DONE to leave: ");
                X = inputHelp.getInputString();
        
                if (X.equalsIgnoreCase("FLUX")) //This executes if pressure is the null variable
                {
                    System.out.println("Please enter the thermal gradient: ");
                    T = inputHelp.getDouble();
        
                    flux = -k*T; //Calculates Stress
                    System.out.println(flux);
        
                    System.out.printf("The Heat FLux is: %g%s\n", flux, fluxUnits); //Prints out the value of pressure combined with the units
                }   
                else if (X.equalsIgnoreCase( "RATE")) {  //This executes if Volume is the null variable
                    System.out.println("Please enter the heat flux: ");
                    flux = inputHelp.getDouble();

                    System.out.println("Please enter the cross sectional area of the plate: ");
                    Ac = inputHelp.getDouble();
                
                    rate = flux*Ac;
                    System.out.println(rate);
                
                    System.out.printf("The Heat Rate is : %g%s\n", rate, rateUnits);
                }
                else if (X.equalsIgnoreCase("WALL")) { // This executes if Temperature is the null value
                    System.out.println("Please input the Length of the wall: ");
                    L = inputHelp.getDouble();

                    System.out.println("Please input the Area of the wall: ");
                    A = inputHelp.getDouble();

                    wallR = L/(k*A);
                    System.out.print(wallR);

                    System.out.printf("The thermal Resistance of the Wall is : %g\n", wallR);
                }
                else if (!X.equalsIgnoreCase("FLUX")||(!X.equalsIgnoreCase("RATE"))||!X.equalsIgnoreCase("WALL")){
                    System.out.println("Please enter FLUX, RATE, or WALL");  
                    continue;
                }
                if (!X.equalsIgnoreCase("DONE")){
                    dataHeat.add(new Heat(flux, rate, wallR, X));
                    
                } 
            }
            return dataHeat;
    }
    
    
    public Heat(){
        flux = 4.0; // conduction heat flux
        rate = 23.0; // conduction heat rate 
        wallR = 11.0; //thermal resistance of a wall of specified material
        X = "flux"; /* This stores the missing variable as a string, and is used in the if statement to know which equation to
            for finding the missing value */
    }
    // Intiliazes constructor for user input
        public Heat(double q, double qBar, double r, String s){
            flux = q;
            rate = qBar;
            wallR = r;
            X = s;
        }
        public void setFlux(Double fl){
            flux=fl;
        }
        public void setRate(Double rt){
            rate = rt;
        }
        public void setWall(Double wll){
            wallR=wll;
        }
        public void setX(String xs){
            X = xs;
        }
        public double getFlux(){
            return flux;
        }
        public double getRate(){
        return rate;
        }
        public double getWall(){
            return wallR;
        }
        public String getMiss(){
            return X;
        }
        public String toString(){
            String nm = String.format("%.3f W*m^2 | %.3f W | %.3f | Solved for %s", flux,rate,wallR,X.toUpperCase());
            return nm;
            
        }
    }
        
    
    