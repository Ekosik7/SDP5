package Devices;

public class StreetLight implements Device {
    private final String name;
    private boolean isOn = false;

    public StreetLight(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println(name() + " is turned on");
        } else {
            System.out.println(name() + " is already turned on");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println(name() + " is turned off");
        } else {
            System.out.println(name() + " is already turned off");
        }
    }

    @Override
    public boolean operate() {
        if (isOn) turnOff(); else turnOn();
        return isOn;
    }
}
