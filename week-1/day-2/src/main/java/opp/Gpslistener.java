package opp;

public interface Gpslistener {
    float [] locate();
    default boolean checkLocation(){
        return locate().length==2;
    }
}
