package ensta.Ships;
import ensta.*;

public class Submarine extends AbstractShip {
    public Submarine(Orientation o) {
        super('S', "Submarine", 3, o);
    }
    public Submarine() {
        super('S', "Submarine", 3, Orientation.EAST);
    }
}
