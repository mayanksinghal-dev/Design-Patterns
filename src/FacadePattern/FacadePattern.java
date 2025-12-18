package FacadePattern;

/**
 * Facade pattern provide a single point of contact to client with simplified, unified interface to a set of complex subsystem. It hides the complexity of the system and
 * exposes only what is necessary.
 * -x-
 * client -> Facade interface -> whole subsystem of multiple class and methods(A,B,C,D,E,F,G,H);
 * Facade provide the SPOC to initiate the service and the system internally communicates to each other. Client do not need to maintain the knowledge of subsystem.
 */

interface ComputerFacade{
    void start();
}
class Power{
    void powerSupply(){
        System.out.println("Power on");
    }
}

class Cooling{
    void startFans(){
        System.out.println("Cooling on");
    }
}

class GraphicCard{
    void start(){
        System.out.println("GraphicCard on");
    }
}

class HardwareConnect{
    void start(){
        System.out.println("HardwareConnect on");
    }
}
class Bios{
    void boot(){
        System.out.println("Bios on");
    }
}
class HardDrive{
    void spinup(){
        System.out.println("HardDrive on");
    }
}
class OperatingSystem{
    void load(){
        System.out.println("OperatingSystem on");
    }
}
class Computer implements ComputerFacade{
    Power power;
    OperatingSystem os;
    HardwareConnect hardwareConnect;
    HardDrive hardDrive;
    Bios bios;
    GraphicCard graphicCard;
    Cooling cooling;

    public Computer() {
        power = new Power();
        os = new OperatingSystem();
        hardwareConnect = new HardwareConnect();
        hardDrive = new HardDrive();
        bios = new Bios();
        graphicCard = new GraphicCard();
        cooling = new Cooling();
    }

    public void start(){
        power.powerSupply();
        os.load();
        hardDrive.spinup();
        hardwareConnect.start();
        bios.boot();
        graphicCard.start();
        cooling.startFans();
        System.out.println("System started");
    }
}
public class FacadePattern {
    public static void main(String[] args){
        ComputerFacade comp = new Computer();
        comp.start();
    }
}
