package ensta;

import ensta.Ships.*;
import java.io.Serializable;
import java.util.List;

public class Player {
    /*
     * ** Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /*
     * ** Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /*
     * ** Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given
     * coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getNom(), s.getTaille());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();

            s.setOrientation(res.orientation);
            try {
                board.putShip(s, res.x + 1, res.y + 1);
                // When ship placement successful
                ++i;
                done = i == 2;
            } catch (Exception e) {
                // Couldn't place ship
                System.out.println("Couldn't place ship. Please try again");
            }

            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) {
        boolean done = false;
        Hit hit = null;

        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput();
            try {
                hit = this.opponentBoard.sendHit(hitInput.x, hitInput.y);
                // en java les arguments sont passés en référence
                coords[0] = hitInput.x;
                coords[1] = hitInput.y;
                done = true;
            } catch (Exception e) {
                System.out.println("Couldn't send hit. Please try again")
                done = false;
            }
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
