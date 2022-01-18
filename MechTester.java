public class MechTester{
    public static void main(String[]args){
        //creates two testers for each kind of constructor
        Mech jav = new Mech(); 
        Mech rap = new Mech(5,4,3,"Missing");
         //sets values for the blank constructor 
        jav.setStress(5.5);
        jav.setStrain(1.1);
        jav.setHook(9.9);
        jav.setX("Stress");

        //prints out the set in values for jav
        System.out.println(jav.getStress());
        System.out.println(jav.getStrain());
        System.out.println(jav.getHook());
        System.out.println(jav.getMiss());
        
        //prints out the values for rap established above
        System.out.println(rap.getStress());
        System.out.println(rap.getStrain());
        System.out.println(rap.getHook());
        System.out.println(rap.getMiss());

        //tests the toString method 
        System.out.println(jav);
        System.out.println(rap);
    }
}