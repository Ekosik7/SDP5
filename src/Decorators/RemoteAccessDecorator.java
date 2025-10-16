package Decorators;

import Devices.Device;

public class RemoteAccessDecorator extends DeviceDecorator {

    public RemoteAccessDecorator(Device device) {
        super(device);
    }

    @Override
    public String name() {
        return super.name() + " with remote access";
    }

    @Override
    public boolean operate() {
        device.operate();
        System.out.println(device.name() + " can be controlled remotely");
        return false;
    }
}
