package ensta;

import java.util.Arrays;
import java.util.Scanner;

public final class InputHelper {

    /*
     * ** Constructeur
     */
    private InputHelper() {
    }

    /*
     * ** Classe ShipInput, interne à InputHelper
     */
    public static class ShipInput {
        public Orientation orientation; // modifié
        public int x;
        public int y;
    }

    /*
     * ** Classe CoordInput, interne à InputHelper
     */
    public static class CoordInput {
        public int x;
        public int y;
    }

    /*
     * ** Méthodes de la classe InputHelper
     */
    public static ShipInput readShipInput() {
        @SuppressWarnings("resource")
        Scanner sin = new Scanner(System.in);
        ShipInput res = new ShipInput();
        String[] validOrientations = { "n", "s", "e", "w" }; // North, South, East, West
        boolean done = false;

        do {
            try {
                String[] in = sin.nextLine().toLowerCase().split(" ");
                if (in.length == 2) {
                    String coord = in[0];
                    if (Arrays.asList(validOrientations).contains(in[1])) {
                        // res.orientation est un objet de classe Orientation
                        if (in[1].equals("n"))
                            res.orientation = Orientation.NORTH;
                        else if (in[1].equals("s"))
                            res.orientation = Orientation.SOUTH;
                        else if (in[1].equals("e"))
                            res.orientation = Orientation.EAST;
                        else if (in[1].equals("w"))
                            res.orientation = Orientation.WEST;

                        res.x = coord.charAt(0) - 'a';
                        res.y = Integer.parseInt(coord.substring(1, coord.length())) - 1;
                        done = true;
                    }
                }
            } catch (Exception e) {
                // nop
            }

            if (!done) {
                System.err.println("Format incorrect! Entrez la position sous forme 'A0 n'");
            }
        } while (!done && sin.hasNextLine());

        return res;
    }

    public static CoordInput readCoordInput() {
        @SuppressWarnings("resource")
        Scanner sin = new Scanner(System.in);
        CoordInput res = new CoordInput();
        boolean done = false;

        do {
            try {
                String coord = sin.nextLine().toLowerCase();
                res.x = coord.charAt(0) - 'a';
                res.y = Integer.parseInt(coord.substring(1, coord.length())) - 1;
                done = true;
            } catch (Exception e) {
                // nop
            }

            if (!done) {
                System.err.println("Format incorrect! Entrez la position sous forme 'A0'");
            }
        } while (!done && sin.hasNextLine());

        res.x++;
        res.y++;
        return res;
    }
}
