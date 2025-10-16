import Devices.Light;
import Devices.MusicSystem;
import Devices.Thermostat;
import Devices.SecurityCamera;

public class HomeAutomationFacade {

    private final Light light;
    private final MusicSystem music;
    private final Thermostat thermostat;
    private final SecurityCamera camera;

    public HomeAutomationFacade(Light light, MusicSystem music, Thermostat thermostat, SecurityCamera camera) {
        this.light = light;
        this.music = music;
        this.thermostat = thermostat;
        this.camera = camera;
    }

    public void startPartyMode() {
        System.out.println("\nStart Party Mode:");
        light.turnOn();
        System.out.println(light.name() + " dim effect: 80%");
        music.play();
        System.out.println(music.name() + " playing at high volume");
        System.out.println("Party mode actions done");
    }

    public void activateNightMode() {
        System.out.println("\nActivate Night Mode:");
        light.turnOff();
        System.out.println(light.name() + " dim effect: 10%");
        thermostat.setTemperature(19);
        camera.operate();
        System.out.println("Night mode actions done");
    }

    public void leaveHome() {
        System.out.println("\nLeave Home:");
        light.turnOff();
        music.stop();
        thermostat.setTemperature(18);
        camera.operate();
        System.out.println(camera.name() + " security enabled");
        System.out.println("Leave home actions done");
    }

    public void turnOnAll() {
        System.out.println("\nTurn on all devices:");
        light.turnOn();
        music.play();
        thermostat.setTemperature(22);
        camera.operate();
    }

    public void turnOffAll() {
        System.out.println("\nTurn off all devices:");
        light.turnOff();
        music.stop();
        thermostat.setTemperature(18);
        camera.operate();
    }
}
