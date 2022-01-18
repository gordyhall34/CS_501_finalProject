public class ThermoTester{
    public static void main(String[]args){
        //creates two testers for each kind of constructor
        Thermo jav = new Thermo(); 
        Thermo rap = new Thermo(5,4,3,2,"Missing");
         //sets values for the blank constructor 
        jav.setMoles(5.5);
        jav.setPress(1.1);
        jav.setTemp(9.9);
        jav.setX("P");

        //prints out the set in values for jav
        System.out.println(jav.getMoles());
        System.out.println(jav.getPress());
        System.out.println(jav.getTemp());
        System.out.println(jav.getVol());
        System.out.println(jav.getMiss());
        
        //prints out the values for rap established above
        System.out.println(rap.getMoles());
        System.out.println(rap.getPress());
        System.out.println(rap.getTemp());
        System.out.println(rap.getVol());
        System.out.println(rap.getMiss());

        //tests the toString method 
        System.out.println(jav);
        System.out.println(rap);
    }
}