package Decorators;

import Devices.Device;

public class DeviceDecorator implements Device {
    protected final Device device;

    public DeviceDecorator(Device device) {
        this.device = device;
    }

    @Override
    public String name() {
        return device.name();
    }

    @Override
    public boolean operate() {
        return device.operate();
    }
}