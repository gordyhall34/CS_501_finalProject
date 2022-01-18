public class HeatTester{
    public static void main(String[]args){
        //creates two testers for each kind of constructor
        Heat jav = new Heat(); 
        Heat rap = new Heat(5,4,3,"Missing");
         //sets values for the blank constructor 
        jav.setFlux(5.5);
        jav.setRate(1.1);
        jav.setWall(9.9);
        jav.setX("Flux");

        //prints out the set in values for jav
        System.out.println(jav.getFlux());
        System.out.println(jav.getRate());
        System.out.println(jav.getWall());
        System.out.println(jav.getMiss());
        
        //prints out the values for rap established above
        System.out.println(rap.getFlux());
        System.out.println(rap.getRate());
        System.out.println(rap.getWall());
        System.out.println(rap.getMiss());

        //tests the toString method 
        System.out.println(jav);
        System.out.println(rap);
    }
}