package Devices;

public class DoorLock implements Device {
    private final String name;
    private boolean isLocked = false;

    public DoorLock(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void lock() {
        if (!isLocked) {
            isLocked = true;
            System.out.println(name + " is now LOCKED");
        } else {
            System.out.println(name + " is already LOCKED");
        }
    }

    public void unlock() {
        if (isLocked) {
            isLocked = false;
            System.out.println(name + " is now UNLOCKED");
        } else {
            System.out.println(name + " is already UNLOCKED");
        }
    }

    @Override
    public boolean operate() {
        if (isLocked) unlock(); else lock();
        return isLocked;
    }
}
