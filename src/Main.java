import Decorators.DeviceDecorator;
import Decorators.VoiceControlDecorator;
import Decorators.EnergySavingDecorator;
import Decorators.RemoteAccessDecorator;

import Devices.Device;
import Devices.Light;
import Devices.MusicSystem;
import Devices.Thermostat;
import Devices.SecurityCamera;

public class Main {
    public static void main(String[] args) {
        MusicSystem msBase = new MusicSystem("Yandex kolonka");
        Device home1 = new DeviceDecorator(msBase);
        home1 = new VoiceControlDecorator(new EnergySavingDecorator(home1));

        Light lightBase = new Light("Cristiano Ronaldo 7");
        Device home2 = new DeviceDecorator(lightBase);
        home2 = new VoiceControlDecorator(new EnergySavingDecorator(home2));

        Device remoteMusic = new RemoteAccessDecorator(new DeviceDecorator(msBase));
        remoteMusic.operate();

        System.out.println(home1.name());
        System.out.println();
        System.out.println(home2.name());

        Thermostat thermostat = new Thermostat("Home Thermostat");
        SecurityCamera camera = new SecurityCamera("Home Camera");

        HomeAutomationFacade facade = new HomeAutomationFacade(lightBase, msBase, thermostat, camera);

        facade.turnOnAll();
        facade.turnOffAll();

        facade.startPartyMode();
        facade.activateNightMode();
        facade.leaveHome();
    }
}
