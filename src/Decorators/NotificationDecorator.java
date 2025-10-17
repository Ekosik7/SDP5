package Decorators;

import Devices.Device;

public class NotificationDecorator extends DeviceDecorator {

    public NotificationDecorator(Device device) {
        super(device);
    }

    @Override
    public boolean operate() {
        device.operate();
        System.out.println("Notification: " + device.name() + " status has changed");
        return true;
    }

    @Override
    public String name() {
        return device.name() + " with Notifications";
    }
}
