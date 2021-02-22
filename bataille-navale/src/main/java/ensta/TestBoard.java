package ensta;

import ensta.Ships.*;
import java.util.ArrayList;

public class TestBoard {
    public static void main(String[] args) {
        System.out.println();
        Board myBoard = new Board("test", 9);
        // NAVIRES
        Destroyer destroyer = new Destroyer(Orientation.WEST);
        /*
         * Submarine submarine = new Submarine(); AircraftCarrier aircraft = new
         * AircraftCarrier(Orientation.SOUTH); BattleShip battleship = new
         * BattleShip(Orientation.NORTH); //placed try { myBoard.putShip(destroyer, 2,
         * 1); myBoard.putShip(submarine, 3, 3); myBoard.putShip(aircraft, 5, 5);
         * myBoard.putShip(battleship, 9, 9); } catch (Exception e) {
         * System.out.println(e); }
         * 
         * //can't be placed try { myBoard.putShip(aircraft, 5, 6); } catch (Exception
         * e) { System.out.println(e); }
         */

        // FRAPPES
        /*
         * myBoard.setHit(true, 3, 3); boolean hit = myBoard.getHit(3, 3);
         * System.out.println(hit);
         */
        ArrayList<AbstractShip> ships = new ArrayList<>();
        ships.add(destroyer);
        ships.add(destroyer);
        ships.add(destroyer);
        ships.add(destroyer);
        ships.add(destroyer);
        Player player = new Player(myBoard, myBoard, ships);
        player.putShips();

        myBoard.print();
    }
}