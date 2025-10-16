package Decorators;

import Devices.Device;

public class VoiceControlDecorator extends DeviceDecorator {
    public VoiceControlDecorator(Device device) {
        super(device);
    }

    @Override
    public boolean operate() {
        device.operate();
        System.out.println(device.name() + " got voice control");
        return true;
    }

    @Override
    public String name() {
        return device.name() + " with Voice Control";
    }
}