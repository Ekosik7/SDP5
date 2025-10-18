import java.util.Scanner;

import Devices.*;
import Decorators.*;

public class ConsoleController {

    private final Light light;
    private final MusicSystem music;
    private final Thermostat thermostat;
    private final SecurityCamera camera;

    private final StreetLight streetLight;
    private final Sprinkler sprinkler;
    private final GateOpener gate;


    private final HomeAutomationFacade home;
    private final OutdoorAutomationFacade outdoor;

    public ConsoleController(
            Light light,
            MusicSystem music,
            Thermostat thermostat,
            SecurityCamera camera,
            StreetLight streetLight,
            Sprinkler sprinkler,
            GateOpener gate,
            HomeAutomationFacade home,
            OutdoorAutomationFacade outdoor
    ) {
        this.light = light;
        this.music = music;
        this.thermostat = thermostat;
        this.camera = camera;
        this.streetLight = streetLight;
        this.sprinkler = sprinkler;
        this.gate = gate;
        this.home = home;
        this.outdoor = outdoor;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Terminal Control ===");
        help();

        while (true) {
            System.out.print("\n> ");
            String line = sc.nextLine().trim();

            if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("0")) {
                System.out.println("Bye.");
                break;
            }
            if (line.equalsIgnoreCase("help") || line.equalsIgnoreCase("h")) {
                help();
                continue;
            }

            if (line.equalsIgnoreCase("clap")) {
                System.out.println("Clap detected -> toggling light");
                light.operate();
                continue;
            }


            String[] parts = line.split("\\s+");
            String cmd = parts[0].toLowerCase();

            try {
                switch (cmd) {

                    case "onall": home.turnOnAll(); break;
                    case "offall": home.turnOffAll(); break;
                    case "party": home.startPartyMode(); break;
                    case "night": home.activateNightMode(); break;
                    case "leave": home.leaveHome(); break;


                    case "out_open":  outdoor.openAll(); break;
                    case "out_even":  outdoor.activateEveningMode(); break;
                    case "out_morn":  outdoor.activateMorningMode(); break;
                    case "out_secure": outdoor.secureOutside(); break;
                    case "out_off":   outdoor.shutdownAll(); break;


                    case "light":
                        requireArg(parts);
                        if (parts[1].equalsIgnoreCase("on"))  light.turnOn();
                        else if (parts[1].equalsIgnoreCase("off")) light.turnOff();
                        else if (parts[1].equalsIgnoreCase("toggle")) light.operate();
                        else System.out.println("Use: light on|off|toggle");
                        break;


                    case "music":
                        requireArg(parts);
                        if (parts[1].equalsIgnoreCase("play")) music.play();
                        else if (parts[1].equalsIgnoreCase("stop")) music.stop();
                        else if (parts[1].equalsIgnoreCase("toggle")) music.operate();
                        else System.out.println("Use: music play|stop|toggle");
                        break;


                    case "temp":
                        requireArg(parts);
                        int t = Integer.parseInt(parts[1]);
                        thermostat.setTemperature(t);
                        break;


                    case "cam":
                        requireArg(parts);
                        if (parts[1].equalsIgnoreCase("toggle")) camera.operate();
                        else System.out.println("Use: cam toggle");
                        break;


                    case "street":
                        requireArg(parts);
                        if (parts[1].equalsIgnoreCase("on"))  streetLight.turnOn();
                        else if (parts[1].equalsIgnoreCase("off")) streetLight.turnOff();
                        else if (parts[1].equalsIgnoreCase("toggle")) streetLight.operate();
                        else System.out.println("Use: street on|off|toggle");
                        break;


                    case "sprink":
                        requireArg(parts);
                        if (parts[1].equalsIgnoreCase("start")) sprinkler.start();
                        else if (parts[1].equalsIgnoreCase("stop")) sprinkler.stop();
                        else if (parts[1].equalsIgnoreCase("toggle")) sprinkler.operate();
                        else System.out.println("Use: sprink start|stop|toggle");
                        break;


                    case "gate":
                        requireArg(parts);
                        if (parts[1].equalsIgnoreCase("open")) gate.open();
                        else if (parts[1].equalsIgnoreCase("close")) gate.close();
                        else if (parts[1].equalsIgnoreCase("toggle")) gate.operate();
                        else System.out.println("Use: gate open|close|toggle");
                        break;

                    default:
                        System.out.println("Unknown command. Type 'help'.");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    private void help() {
        System.out.println("""
                Commands:
                  help / h            — show this help
                  exit / 0            — exit

                  clap                — simulate clap (toggle room light)

                  onall               — home facade: turnOnAll
                  offall              — home facade: turnOffAll
                  party               — home facade: startPartyMode
                  night               — home facade: activateNightMode
                  leave               — home facade: leaveHome

                  out_open            — outdoor facade: openAll
                  out_even            — outdoor facade: activateEveningMode
                  out_morn            — outdoor facade: activateMorningMode
                  out_secure          — outdoor facade: secureOutside
                  out_off             — outdoor facade: shutdownAll

                  light on|off|toggle
                  music play|stop|toggle
                  temp <N>            — set thermostat temperature (e.g. temp 21)
                  cam toggle

                  street on|off|toggle
                  sprink start|stop|toggle
                  gate open|close|toggle
                """);
    }

    private void requireArg(String[] parts) {
        if (parts.length < 2) throw new IllegalArgumentException("Argument required");
    }
}
