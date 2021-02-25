package ensta;

import ensta.Ships.*;
import java.util.ArrayList;

public class TestBoard {
    public static void main(String[] args) {
        System.out.println();
        Board myBoard = new Board("test", 9);
        /*try {
            myBoard.setHit(false, 1, 1);
        } catch(Exception e) {

        }*/
        
        myBoard.print();
        // NAVIRES
        Destroyer destroyer = new Destroyer(Orientation.WEST);
        Submarine submarine = new Submarine(Orientation.WEST);
        /*ShipState state1 = new ShipState();
        ShipState state2 = new ShipState();
        state1.setShip(destroyer);
        state2.setShip(destroyer);

        try {
            state1.getShip().addStrike();
        } catch (Exception e) {}
        System.out.println("HEEREE :  ");
        System.out.println(state2.getShip().getStrikeCount());*/
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
        ships.add(submarine);
        Player player = new Player(myBoard, myBoard, ships);
        player.putShips();
        
        /*
        myBoard.sendHit(1, 1);
        myBoard.print();
        myBoard.sendHit(2, 1);
        myBoard.print();*/

    }
}