package Decorators;

import Devices.Device;

public class WeatherProofDecorator extends DeviceDecorator {

    public WeatherProofDecorator(Device device) {
        super(device);
    }

    @Override
    public boolean operate() {
        device.operate();
        System.out.println(device.name() + " has weather protection enabled");
        return true;
    }

    @Override
    public String name() {
        return device.name() + " with Weather Proof";
    }
}
