package ensta;
import ensta.Ships.*;

public class TestBoard {
    public static void main(String[] args) {
        System.out.println();
        Board myBoard = new Board("test", 9);
        //NAVIRES
        Destroyer destroyer = new Destroyer(Orientation.WEST);
        Submarine submarine = new Submarine();
        AircraftCarrier aircraft = new AircraftCarrier(Orientation.SOUTH);
        BattleShip battleship = new BattleShip(Orientation.NORTH);
        //placed
        myBoard.putShip(destroyer, 2, 1);
        myBoard.putShip(submarine, 3, 3);
        myBoard.putShip(aircraft, 5, 5);
        myBoard.putShip(battleship, 9, 9);
        //can't be placed
        myBoard.putShip(aircraft, 5, 6);
        myBoard.putShip(destroyer, 3, 1);

        //FRAPPES
        myBoard.setHit(true, 3, 3);
        boolean hit = myBoard.getHit(3, 3);
        System.out.println(hit);


        myBoard.print();
    }
}