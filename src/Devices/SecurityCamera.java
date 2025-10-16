package Devices;

public class SecurityCamera implements Device {
    private final String id;

    public SecurityCamera(String id) {
        this.id = id;
    }

    public void start() {
        System.out.println(name() + " started recording");
    }

    public void stop() {
        System.out.println(name() + " stopped recording");
    }

    @Override
    public String name() {
        return "SecurityCamera[" + id + "]";
    }

    @Override
    public boolean operate() {
        start();
        return true;
    }
}