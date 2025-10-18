import Decorators.*;
import Devices.*;

public class Main {
    public static void main(String[] args) {
        Light lightBase = new Light("Cristiano Ronaldo 7");
        MusicSystem msBase = new MusicSystem("Yandex kolonka");
        Thermostat thermostat = new Thermostat("Home Thermostat");
        SecurityCamera camera = new SecurityCamera("Home Camera");

        Device decoratedLight = new VoiceControlDecorator(new EnergySavingDecorator(new DeviceDecorator(lightBase)));
        Device decoratedMusic = new RemoteAccessDecorator(new EnergySavingDecorator(new DeviceDecorator(msBase)));

        HomeAutomationFacade homeFacade = new HomeAutomationFacade(lightBase, msBase, thermostat, camera);

        StreetLight streetLightBase = new StreetLight("Street Light #1");
        Sprinkler sprinklerBase = new Sprinkler("Garden Sprinkler");
        GateOpener gateBase = new GateOpener("Front Gate");

        OutdoorAutomationFacade outdoorFacade = new OutdoorAutomationFacade(streetLightBase, sprinklerBase, gateBase);

        ConsoleController cli = new ConsoleController(
                lightBase,
                msBase,
                thermostat,
                camera,
                streetLightBase,
                sprinklerBase,
                gateBase,
                homeFacade,
                outdoorFacade
        );

        cli.start();
    }
}
