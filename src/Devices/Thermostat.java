package Devices;

public class Thermostat implements Device {
    private final String name;
    private int temperature = 22;

    public Thermostat(String name) {
        this.name = name;
    }

    public void setTemperature(int temperatureC) {
        temperature = temperatureC;
        System.out.println(name() + " is set to " + temperature + "C");
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean operate() {
        setTemperature(22);
        return false;
    }
}
