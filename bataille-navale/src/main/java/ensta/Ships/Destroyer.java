package ensta.Ships;
import ensta.*;

public class Destroyer extends AbstractShip {
    public Destroyer(Orientation o) {
        super('D', "Destroyer", 2, o);
    }
    public Destroyer() {
        super('D', "Destroyer", 2, Orientation.EAST);
    }
}
