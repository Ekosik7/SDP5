package Devices;

public class MusicSystem implements Device {
    private final String id;

    public MusicSystem(String id) {
        this.id = id;
    }

    public void play() {
        System.out.println(name() + " started playing");
    }

    public void stop() {
        System.out.println(name() + " stopped");
    }

    @Override
    public String name() {
        return "MusicSystem[" + id + "]";
    }

    @Override
    public boolean operate() {
        play();
        return true;
    }
}