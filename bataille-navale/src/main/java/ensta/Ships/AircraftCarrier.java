package ensta.Ships;
import ensta.*;

public class AircraftCarrier extends AbstractShip {
    public AircraftCarrier(Orientation o) {
        super('A', "AircraftCarrier", 5, o);
    }
    public AircraftCarrier() {
        super('A', "AircraftCarrier", 5, Orientation.EAST);
    }
}
