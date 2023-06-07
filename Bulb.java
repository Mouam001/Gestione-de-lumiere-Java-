package Isg.examen;

public class Bulb extends Light{
    private static final int LUMENS = 15;

    public Bulb(int watts){
        super(watts);
    }

    public int getLumens(){
        return LUMENS * getWatts();
    }

}
