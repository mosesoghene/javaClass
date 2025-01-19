package ac;

public class AC {
    private boolean acPowerState = false;

    public void turnOn(){
        System.out.println("Turn On");
        acPowerState = true;
    }

    public boolean isOn() {
        return acPowerState;
    }

    public void turnOff() {
        System.out.println("Turn Off");
        acPowerState = false;
    }

    public void increaseTemperature() {
    }

    public int temperature() {
        return 17;
    }
}
