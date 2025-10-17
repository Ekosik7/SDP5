package Decorators;

import Devices.Device;

public class AutoShutdownDecorator extends DeviceDecorator {

    public AutoShutdownDecorator(Device device) {
        super(device);
    }

    @Override
    public boolean operate() {
        device.operate();
        System.out.println(device.name() + " has auto-shutdown feature enabled");
        return true;
    }

    @Override
    public String name() {
        return device.name() + " with Auto Shutdown";
    }
}
