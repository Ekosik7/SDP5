package Devices;

public class SmartTV implements Device {
    private final String name;
    private boolean isOn = false;

    public SmartTV(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println(name + " is now ON");
        } else {
            System.out.println(name + " is already ON");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println(name + " is now OFF");
        } else {
            System.out.println(name + " is already OFF");
        }
    }

    @Override
    public boolean operate() {
        if (isOn) turnOff(); else turnOn();
        return isOn;
    }
}
