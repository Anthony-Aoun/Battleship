package ensta.Ships;
import ensta.*;

public class ShipState { 
    protected AbstractShip ship;
    protected boolean struck;

    public ShipState() {
        this.ship = null;
        this.struck = false;
    }

    public AbstractShip getShip() {
        return this.ship;
    }
    public void setShip(AbstractShip s) {
        this.ship = s;
    }
    public boolean isStruck() {
        return this.struck;
    }
    public void setStruck(boolean s) {
        this.struck = s;
    }
    public boolean isSunck() {
        try {
            return this.ship.isSunck();
        } catch(Exception e) {
            return false;
        }
    }
    public String toString() {
        if (struck)
            return ColorUtil.colorize(this.ship.getLabel(), ColorUtil.Color.RED);
        else
            return ColorUtil.colorize(this.ship.getLabel(), ColorUtil.Color.WHITE);
    }
}
