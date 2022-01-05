package clsobj;

public class Car {
    // state
    public int speed;
// zero parameterized constructor
    public Car()
    {
        speed =10;
    }
    //paramerterized constructor
    public Car (int sp)
    {
        speed= sp;
    }

    public void speedUp()
    {
        speed +=10;
    }


}
