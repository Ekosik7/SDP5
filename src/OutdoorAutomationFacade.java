import Devices.StreetLight;
import Devices.Sprinkler;
import Devices.GateOpener;

public class OutdoorAutomationFacade {

    private final StreetLight streetLight;
    private final Sprinkler sprinkler;
    private final GateOpener gate;

    public OutdoorAutomationFacade(StreetLight streetLight, Sprinkler sprinkler, GateOpener gate) {
        this.streetLight = streetLight;
        this.sprinkler = sprinkler;
        this.gate = gate;
    }

    public void activateEveningMode() {
        System.out.println("\nActivate Evening Mode:");
        streetLight.turnOn();
        System.out.println(streetLight.name() + " brightness set to 70%");
        sprinkler.stop();
        gate.close();
        System.out.println("Evening mode actions done");
    }

    public void activateMorningMode() {
        System.out.println("\nActivate Morning Mode:");
        streetLight.turnOff();
        sprinkler.start();
        gate.open();
        System.out.println("Morning mode actions done");
    }

    public void secureOutside() {
        System.out.println("\nSecuring Outside:");
        streetLight.turnOn();
        sprinkler.stop();
        gate.close();
        System.out.println("All outdoor systems secured");
    }

    public void openAll() {
        System.out.println("\nOpening all outdoor devices:");
        streetLight.turnOn();
        sprinkler.start();
        gate.open();
    }

    public void shutdownAll() {
        System.out.println("\nShutting down all outdoor devices:");
        streetLight.turnOff();
        sprinkler.stop();
        gate.close();
    }
}
