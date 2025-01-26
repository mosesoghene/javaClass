package bike;

public class Bike {

    private boolean isOn = false;
    private int speed = 0;
    private int gear = 1;

    public boolean isOn() {
        return isOn;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    public Object speed() {
        if (!isOn) return null;
        return speed;
    }

    public void accelerate() {
        speed += gear;
        changeGear();
    }

    private void changeGear() {
        if (speed > 10 && speed % 20 == 0 && gear < 4) gear += 1;
    }

    public int gear() {
        return gear;
    }
}
