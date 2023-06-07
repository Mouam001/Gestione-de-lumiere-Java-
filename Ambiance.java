package Isg.examen;

public class Ambiance {
    private int COSY = 50;
    public static int RELAX = 150;
    private int WORK = 250;

    public static int toLux(int lumens, float m2){
        return (int)(lumens/m2);
    }

    public static int toLumen(int lux, float m2){
        return (int)(lux * m2);
    }
}
