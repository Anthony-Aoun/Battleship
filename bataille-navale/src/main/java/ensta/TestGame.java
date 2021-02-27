package ensta;

import ensta.Ships.*;

public class TestGame {
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String argc[]) {
        Board myBoard = new Board("test", 9);
        AbstractShip ships[] = new AbstractShip[5];
        BattleShipsAI ai = new BattleShipsAI(myBoard, myBoard);
        int destroyed;
        int[] coords = new int[2];
        Hit hit;

        Destroyer destroyer = new Destroyer();
        ships[0] = destroyer;
        AircraftCarrier aircraft = new AircraftCarrier();
        ships[1] = aircraft;
        BattleShip battleship1 = new BattleShip();
        ships[2] = battleship1;
        BattleShip battleship2 = new BattleShip();
        ships[3] = battleship2;
        Submarine submarine = new Submarine();
        ships[4] = submarine;

        ai.putShips(ships);

        myBoard.print();

        do {
            hit = ai.sendHit(coords);

            myBoard.print();
            System.out.println();
            System.out.println("Hit in position (x, y) = (" + coords[0] + ", " + coords[1] + ")");
            System.out.print("Status of Hit : ");
            if (hit == Hit.MISS || hit == Hit.STIKE) {
                System.out.println(hit.toString());
            } else {
                System.out.println(hit.toString() + " coulé");
            }

            // sleep
            sleep(2000);

            destroyed = 0;
            for (AbstractShip ship : ships) {
                if (ship.isSunck()) {
                    destroyed++;
                }
            }
        } while (destroyed < ships.length);

    }
}
