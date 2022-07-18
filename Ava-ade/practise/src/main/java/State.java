package main.java;

public class State {
    private String stateName;
    private int pinCode;

    public State(String stateName, int pinCode){
        this.stateName = stateName;
        this.pinCode = pinCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
