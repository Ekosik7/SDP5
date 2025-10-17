package Decorators;

import Devices.Device;

public class SolarPowerDecorator extends DeviceDecorator {

    public SolarPowerDecorator(Device device) {
        super(device);
    }

    @Override
    public boolean operate() {
        device.operate();
        System.out.println(device.name() + " is powered by solar energy");
        return true;
    }

    @Override
    public String name() {
        return device.name() + " with Solar Power";
    }
}
