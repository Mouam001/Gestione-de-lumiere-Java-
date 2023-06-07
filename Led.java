package Isg.examen;

public class Led extends Light{
    private static final int LUMENS = 90;

    /**
     * on de definis ce constructeur car la clase parent
     * est abstract et aussi n'a pas de constructeur par defaut
     * @param watts
     */
    public Led(int watts){
        super(watts);
    }

    // Cette methode fait reference a la methode
    // Abstract definit sur la classe parent
    public int getLumens(){
        return LUMENS * getWatts();
    }
}
