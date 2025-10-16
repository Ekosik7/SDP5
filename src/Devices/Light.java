package Devices;

public class Light implements Device {
    private final String id;

    public Light(String id) {
        this.id = id;
    }

    public void turnOn() {
        System.out.println(name() + " turned on");
    }

    public void turnOff() {
        System.out.println(name() + " turned off");
    }

    @Override
    public String name() {
        return "Light[" + id + "]";
    }

    @Override
    public boolean operate() {
        turnOn();
        return true;
    }
}