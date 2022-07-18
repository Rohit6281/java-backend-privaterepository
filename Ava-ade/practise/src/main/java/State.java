package main.java;

public class State {
    private String stateName;
    private int pinCode;

    public State(String stateName, int pinCode){
        this.stateName = stateName;
        this.pinCode = pinCode;
    }

    public String getStateName() {
        if(stateName.length() > 16){
            return "name is too long";
        }else {
            return stateName;
        }
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getPinCode() {
        if (pinCode >= 100) {
            return pinCode;
        }else{
            return 000;
        }
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
