package Devices;

public class Sprinkler implements Device {
    private final String name;
    private boolean running = false;

    public Sprinkler(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void start() {
        if (!running) {
            running = true;
            System.out.println(name() + " started watering");
        } else {
            System.out.println(name() + " is already watering");
        }
    }

    public void stop() {
        if (running) {
            running = false;
            System.out.println(name() + " stopped watering");
        } else {
            System.out.println(name() + " is already stopped");
        }
    }

    @Override
    public boolean operate() {
        if (running) stop(); else start();
        return running;
    }
}
