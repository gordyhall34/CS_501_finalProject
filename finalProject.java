import java.util.ArrayList;

public class finalProject {



    public static void main(String args[]) {
        ArrayList<Thermo> dataThermo = new ArrayList<Thermo>(); //initializes data so it exists before the loop
        ArrayList<Mech> dataMech = new ArrayList<Mech>();
        ArrayList<Heat> dataHeat = new ArrayList<Heat>();
        GetIn inputHelp = new GetIn();
        String choice = "";

        System.out.println("This is a calculator for use in engineering, please enter the type of equation you need to solve, \n"
        + "THERMO, MECH, or HEAT, or DONE to get more options");
        choice = inputHelp.getInputString();

        if(choice.equalsIgnoreCase("THERMO")){
            dataThermo = Thermo.getUserInput(dataThermo, inputHelp);
            String y = "NULL";
            while (!y.equalsIgnoreCase("LEAVE")){
                System.out.println("You can now PRINT the list of data or ADD more values or LEAVE the program");
                y = inputHelp.getInputString();
                if (y.equalsIgnoreCase("PRINT")){
                    for (int i = 0; i < dataThermo.size(); i++){
                        System.out.println(i + ".) " + dataThermo.get(i));
                    }
                } else if(y.equalsIgnoreCase("ADD")){
                    dataThermo = Thermo.getUserInput(dataThermo, inputHelp);
                }
            }
        }else if(choice.equalsIgnoreCase("MECH")){
            dataMech = Mech.getUserInput(dataMech, inputHelp);
            String y = "NULL";
            while (!y.equalsIgnoreCase("LEAVE")){
                System.out.println("You can now PRINT the list of data or ADD more values or LEAVE the program");
                y = inputHelp.getInputString();
                if (y.equalsIgnoreCase("PRINT")){
                    for (int i = 0; i < dataMech.size(); i++){
                        System.out.println(i + ".) " + dataMech.get(i));
                    }
                } else if(y.equalsIgnoreCase("ADD")){
                    dataMech = Mech.getUserInput(dataMech, inputHelp);
                }
            }
        }else if(choice.equalsIgnoreCase("Heat")){
            dataHeat = Heat.getUserInput(dataHeat, inputHelp);
            String y = "NULL";
            while (!y.equalsIgnoreCase("LEAVE")){
                System.out.println("You can now PRINT the list of data or ADD more values or LEAVE the program");
                y = inputHelp.getInputString();
                if (y.equalsIgnoreCase("PRINT")){
                    for (int i = 0; i < dataHeat.size(); i++){
                        System.out.println(i + ".) " + dataHeat.get(i));
                    }
                } else if(y.equalsIgnoreCase("ADD")){
                    dataHeat = Heat.getUserInput(dataHeat, inputHelp);
                }
            }
        }
    }
    }

