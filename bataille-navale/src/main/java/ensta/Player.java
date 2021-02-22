package ensta;
import ensta.Ships.*;
import java.io.Serializable;
import java.util.List;

public class Player {
    /* **
     * Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /* **
     * Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /* **
     * Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getNom(), s.getTaille());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();

            if (res.orientation == "n") s.setOrientation(Orientation.NORTH);
            else if (res.orientation == "s") s.setOrientation(Orientation.SOUTH);
            else if (res.orientation == "e") s.setOrientation(Orientation.EAST);
            else if (res.orientation == "s") s.setOrientation(Orientation.SOUTH);
            try {
                board.putShip(s, res.x, res.y);
                // When ship placement successful
                ++i;
                done = i == 5;
            } catch (Exception e) {
                // Couldn't place ship
                System.out.println(e);
            }

            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            // TODO call sendHit on this.opponentBoard

            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            // return hit is obvious. But how to return coords at the same time ?
        } while (!done);

        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
