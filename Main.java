package Isg.examen;

import java.util.Locale;

public class Main {

    public static void main(String [] argv){
        Locale.setDefault(new Locale("en", "US"));
        Led led1 = new Led(8),led2 = new Led(20);
       // led2.turnOn();
        Bulb bulb1 = new Bulb(45), bulb2 = new Bulb(100), bulb3 = new Bulb(30);

        Room  salon = new Room("Bureau", 20, 6);
        salon.addLight(led1);
        salon.addLight(bulb1);
        salon.addLight(led2);
        salon.addLight(bulb2);
        salon.addLight(bulb3);
        salon.show();

        System.out.println();
        salon.removeLight(2);
        System.out.println();
        salon.show();

        System.out.println();
        salon.removeLight(2);
        System.out.println();
       // salon.show();

        System.out.println();
        salon.removeLight(28);
        /*led1.turnOn();
        led2.turnOn();
        bulb1.turnOn();
        bulb3.turnOn();*/
        System.out.println();
        salon.setAmbiance(Ambiance.RELAX);
        salon.show();




    }
}
