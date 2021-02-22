package ensta;

import ensta.Ships.*;

public class Board implements IBoard {
    private String nom;
    private char navires[][];
    private boolean frappes[][];

    public Board(String n, int taille) {
        this.nom = n;
        this.navires = new char[taille][taille];
        // on initialise this.navires
        for (int i = 0; i < taille; ++i) {
            for (int j = 0; j < taille; ++j) {
                this.navires[i][j] = '.';
            }
        }
        this.frappes = new boolean[taille][taille];
    }

    public Board(String n) {
        this.nom = n;
        this.navires = new char[10][10];
        // on initialise this.navires
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                this.navires[i][j] = '.';
            }
        }
        this.frappes = new boolean[10][10];
    }

    public String getNom() {
        return this.nom;
    }

    public char[][] getNavires() {
        return this.navires;
    }

    public boolean[][] getFrappes() {
        return this.frappes;
    }

    public int getSize() {
        return this.navires.length;
    }

    // la position (x, y) = (1, 1) correspond à : en haut, à gauche
    // throws "Couldn't place ship" if there already is a ship here or index out of
    // bound
    public void putShip(AbstractShip ship, int x, int y) throws Exception {
        Orientation orient = ship.getOrientation();
        int size_ship = ship.getTaille();
        int i, j; // indices matriciels that go from 0 to size_grid-1
        boolean possible = true;

        // place the ship if possible according to orientation
        if (orient == Orientation.NORTH) {
            j = x - 1;
            // check if possible
            for (i = y - 1; i >= y - size_ship; --i) {
                try {
                    // trows exception if index out of bound
                    if (hasShip(j + 1, i + 1)) {
                        possible = false;
                    }
                } catch (Exception e) {
                    possible = false;
                    // Index out of bound
                    // System.out.println(e);
                }
            }
            // if not possible throw exception
            if (!possible)
                throw new Exception("Couldn't place ship");
            // if possible, place ship
            else {
                for (i = y - 1; i >= y - size_ship; --i) {
                    this.navires[i][j] = '#';
                }
            }
        } else if (orient == Orientation.SOUTH) {
            j = x - 1;
            for (i = y - 1; i <= y + size_ship - 2; ++i) {
                try {
                    if (hasShip(j + 1, i + 1)) {
                        possible = false;
                    }
                } catch (Exception e) {
                    possible = false;
                    System.out.println(e);
                }
            }
            if (!possible)
                throw new Exception("Couldn't place ship");
            else {
                for (i = y - 1; i <= y + size_ship - 2; ++i) {
                    this.navires[i][j] = '#';
                }
            }
        } else if (orient == Orientation.EAST) {
            i = y - 1;
            for (j = x - 1; j <= x + size_ship - 2; ++j) {
                try {
                    if (hasShip(j + 1, i + 1)) {
                        possible = false;
                    }
                } catch (Exception e) {
                    possible = false;
                    System.out.println(e);
                }
            }
            if (!possible)
                throw new Exception("Couldn't place ship");
            else {
                for (j = x - 1; j <= x + size_ship - 2; ++j) {
                    this.navires[i][j] = '#';
                }
            }
        } else if (orient == Orientation.WEST) {
            i = y - 1;
            for (j = x - 1; j >= x - size_ship; --j) {
                try {
                    if (hasShip(j + 1, i + 1)) {
                        possible = false;
                    }
                } catch (Exception e) {
                    possible = false;
                    System.out.println(e);
                }
            }
            if (!possible)
                throw new Exception("Couldn't place ship");
            else {
                for (j = x - 1; j >= x - size_ship; --j) {
                    this.navires[i][j] = '#';
                }
            }
        }
    }

    public boolean hasShip(int x, int y) throws Exception {
        int size_grid = this.frappes.length;
        if (x < 1 || x > size_grid || y < 1 || y > size_grid)
            throw new Exception("Index out of bound");
        return (this.navires[y - 1][x - 1] != '.');
    }

    public void setHit(boolean hit, int x, int y) throws Exception {
        int size_grid = this.frappes.length;
        if (x < 1 || x > size_grid || y < 1 || y > size_grid)
            throw new Exception("Index out of bound");
        this.frappes[y - 1][x - 1] = hit;
    }

    public Boolean getHit(int x, int y) throws Exception {
        int size_grid = this.frappes.length;
        if (x < 1 || x > size_grid || y < 1 || y > size_grid)
            throw new Exception("Index out of bound");
        return this.frappes[y - 1][x - 1];
    }

    public void print() {
        System.out.println();
        System.out.println("Navires : ");
        System.out.print("  ");
        char c = 'A';
        for (int i = 0; i < this.navires.length; ++i) {
            System.out.print(c + " ");
            c++;
        }
        System.out.println();
        for (int i = 0; i < this.navires.length; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < this.navires.length; ++j) {
                System.out.print(this.navires[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("Frappes : ");
        System.out.print("  ");
        c = 'A';
        for (int i = 0; i < this.navires.length; ++i) {
            System.out.print(c + " ");
            c++;
        }
        System.out.println();
        for (int i = 0; i < this.frappes.length; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < this.frappes.length; ++j) {
                if (this.frappes[i][j] == false)
                    System.out.print(". ");
                else
                    System.out.print("x ");
            }
            System.out.println();
        }
    }
}