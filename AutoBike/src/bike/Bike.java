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
        if (speed >= 20 && speed < 30) gear = 2;
        if (speed >= 30 && speed < 40) gear = 3;
        if (speed >= 40) gear = 4;
    }

    public int gear() {
        return gear;
    }
}
