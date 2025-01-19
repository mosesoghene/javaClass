package ac;

public class AC {
    private boolean acPowerState = false;
    private final int MIN_TEMP = 16;
    private final int MAX_TEMP = 30;
    private int acTemperature = MIN_TEMP;

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
        acTemperature++;
    }

    public int temperature() {
        return acTemperature;
    }

    public void decreaseTemperature() {
        if (acTemperature == MIN_TEMP) return;
        acTemperature--;
    }
}
