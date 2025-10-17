import Decorators.*;

import Devices.*;

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

        System.out.println("\n--- New Devices Demonstration ---");

        Device tv = new NotificationDecorator(new SmartTV("Samsung Smart TV"));
        Device air = new AutoShutdownDecorator(new AirConditioner("LG Air Conditioner"));
        Device door = new NotificationDecorator(new AutoShutdownDecorator(new DoorLock("Main Door Lock")));

        tv.operate();
        air.operate();
        door.operate();

        System.out.println("\n--- Device Names ---");
        System.out.println(tv.name());
        System.out.println(air.name());
        System.out.println(door.name());

        Device streetLight = new SolarPowerDecorator(new StreetLight("Street Light #1"));
        Device sprinkler   = new WeatherProofDecorator(new Sprinkler("Garden Sprinkler"));
        Device gate        = new NotificationDecorator(new GateOpener("Front Gate"));

        System.out.println("\n--- Outdoor Devices Demonstration ---");
        streetLight.operate();
        sprinkler.operate();
        gate.operate();

        System.out.println("\n--- Outdoor Device Names ---");
        System.out.println(streetLight.name());
        System.out.println(sprinkler.name());
        System.out.println(gate.name());

        StreetLight streetLightBase = new StreetLight("Street Light #1");
        Sprinkler sprinklerBase = new Sprinkler("Garden Sprinkler");
        GateOpener gateBase = new GateOpener("Front Gate");

        OutdoorAutomationFacade outdoorFacade = new OutdoorAutomationFacade(streetLightBase, sprinklerBase, gateBase);

        outdoorFacade.openAll();
        outdoorFacade.activateEveningMode();
        outdoorFacade.activateMorningMode();
        outdoorFacade.secureOutside();
        outdoorFacade.shutdownAll();
    }
}
