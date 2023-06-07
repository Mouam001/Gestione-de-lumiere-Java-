package Isg.examen;

abstract public  class Light {
    private int watts;
    private boolean on = false;

    public int getWatts(){
        return this.watts;
    }

    public abstract int getLumens();

    // état des Light (allumer ou éteint)

    /**
     *
     * @return true ou false
     */
    public boolean isOn(){
        return this.on;
    }

    public void turnOn(){
        this.on = true;
    }

    public void turnOff(){
        this.on = false;
    }

    // constructeur

   public Light ( int watts){
        this.watts = watts;
    }

    @Override
    public java.lang.String toString() {

        String etat;
        if(isOn()){
            etat = "ON";
        } else etat = "OFF";

        return String.format("%-5s (%3d W | %4d lm : %s", this.getClass().getSimpleName(),
                getWatts(),getLumens(), etat);
    }
}
