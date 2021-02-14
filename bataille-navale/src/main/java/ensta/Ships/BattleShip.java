package ensta.Ships;
import ensta.*;

public class BattleShip extends AbstractShip {
    public BattleShip(Orientation o) {
        super('B', "BattleShip", 4, o);
    }
    public BattleShip() {
        super('B', "BattleShip", 4, Orientation.EAST);
    }
}
