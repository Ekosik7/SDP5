package Devices;

public class GateOpener implements Device {
    private final String name;
    private boolean opened = false;

    public GateOpener(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void open() {
        if (!opened) {
            opened = true;
            System.out.println(name() + " is OPENED");
        } else {
            System.out.println(name() + " is already OPENED");
        }
    }

    public void close() {
        if (opened) {
            opened = false;
            System.out.println(name() + " is CLOSED");
        } else {
            System.out.println(name() + " is already CLOSED");
        }
    }

    @Override
    public boolean operate() {
        if (opened) close(); else open();
        return opened;
    }
}
