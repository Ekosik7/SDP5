package Devices;

public class AirConditioner implements Device {
    private final String name;
    private boolean isCooling = false;
    private int temperature = 22;

    public AirConditioner(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void startCooling() {
        if (!isCooling) {
            isCooling = true;
            System.out.println(name + " started cooling at " + temperature + "°C");
        } else {
            System.out.println(name + " is already cooling");
        }
    }

    public void stopCooling() {
        if (isCooling) {
            isCooling = false;
            System.out.println(name + " stopped cooling");
        } else {
            System.out.println(name + " is already stopped");
        }
    }

    @Override
    public boolean operate() {
        if (isCooling) stopCooling(); else startCooling();
        return isCooling;
    }
}
