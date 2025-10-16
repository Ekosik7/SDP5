package Decorators;

import Devices.Device;

public class EnergySavingDecorator extends DeviceDecorator {

    public EnergySavingDecorator(Device device) {
        super(device);
    }

    @Override
    public String name() {
        return super.name() + " with energy saving";
    }

    @Override
    public boolean operate() {
        device.operate();
        System.out.println(device.name() + " is optimized for energy saving");
        return false;
    }
}
