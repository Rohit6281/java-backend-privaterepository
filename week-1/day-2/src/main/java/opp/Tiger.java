package opp;

public class Tiger extends Animal implements Gpslistener {
    @Override
    public String walk(){
        return "Tiger is walking";
    }

    public float[]locate(){
        return new float[]{17.82f, 72.64f};
    }

}
