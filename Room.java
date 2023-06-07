package Isg.examen;

import java.util.Locale;
import Isg.examen.Ambiance;
import Isg.examen.Light;

public class Room {
    private String name;
    private float m2;
    private Light[] spots;

    public Room(String name, float m2, int nbSpots) {
        this.name = name;
        this.m2 = m2;
        this.spots = new Light[nbSpots];
    }

    public void addLight(Light light){
        for (int i = 0; i < spots.length; i++){
            if(spots[i] == null){
                spots[i] = light;
                return;
            }
        }
        System.err.println(" No available spots");
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f m2)",this.name, this.m2);
    }

    public int computeLumens(){
        int totalLumens = 0;
        for (int i = 0; i < spots.length; i++){
            if( spots[i] != null && spots[i].isOn()){
                totalLumens += spots[i].getLumens();
            }
        }
        return totalLumens;
    }

    public void show(){
        System.out.println(toString());
        String msg;
        for(int i = 0; i < spots.length; i++){
            msg =String.format("[%03d] : %s",i+1,spots[i]!=null ? spots[i].toString(): "Vide");
            System.out.println(msg);
        }
        int total = computeLumens();
        msg = String.format("Current Ambiance : %d lm | %d lx)",total, Ambiance.toLux(total,m2));
        System.out.println(msg);
    }

    /**
     * une methode qui permet de retirer
     * une lumiere qui se trouve à l'emplacement
     * @param spotNum
     */
    public void removeLight( int spotNum) {
        System.out.print("Removing spot n° " + spotNum + "->");

        if (spotNum <= 0 || spotNum > spots.length) {
            System.out.println(" DOES NOT EXIST");
            return;
        }

        spotNum--;
        if (spots[spotNum] == null) {
            System.out.println(" WAS EMPTY");
        } else {
            spots[spotNum] = null;
            System.out.println(" REMOVED ");
        }
    }

        public void setAmbiance(int lux){
            int totalLumens = Ambiance.toLumen(lux, m2);

            // Turn off all lights
            for (Light light : spots) {
                if (light != null && light.isOn()) {
                    light.turnOff();
                }
            }

            // Turn on lights based on available lumens
            int remainingLumens = totalLumens;
            for (Light light : spots) {
                if (light != null && remainingLumens > 0) {
                    int lightLumens = light.getLumens();
                    if (lightLumens <= remainingLumens) {
                        light.turnOn();
                        remainingLumens -= lightLumens;
                    }
                }
            }
        }


}
