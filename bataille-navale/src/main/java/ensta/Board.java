package ensta;

import ensta.Ships.*;

public class Board implements IBoard {
    private String nom;
    private ShipState navires[][];
    private Boolean frappes[][];

    public Board(String n, int taille) {
        this.nom = n;
        this.navires = new ShipState[taille][taille];
        // on initialise this.navires
        for (int i = 0; i < taille; ++i) {
            for (int j = 0; j < taille; ++j) {
                this.navires[i][j] = new ShipState();
            }
        }
        this.frappes = new Boolean[taille][taille];
        // on initialise this.frappes
        for (int i = 0; i < taille; ++i) {
            for (int j = 0; j < taille; ++j) {
                this.frappes[i][j] = null;
            }
        }
    }

    public Board(String n) {
        this.nom = n;
        this.navires = new ShipState[10][10];
        // on initialise this.navires
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                this.navires[i][j] = new ShipState();
            }
        }
        this.frappes = new Boolean[10][10];
        // on initialise this.frappes
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                this.frappes[i][j] = null;
            }
        }
    }

    public String getNom() {
        return this.nom;
    }

    public ShipState[][] getNavires() {
        return this.navires;
    }

    public Boolean[][] getFrappes() {
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
                }
            }
            // if not possible throw exception
            if (!possible)
                throw new Exception("Couldn't place ship");
            // if possible, place ship
            else {
                for (i = y - 1; i >= y - size_ship; --i) {
                    this.navires[i][j].setShip(ship);
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
                }
            }
            if (!possible)
                throw new Exception("Couldn't place ship");
            else {
                for (i = y - 1; i <= y + size_ship - 2; ++i) {
                    this.navires[i][j].setShip(ship);
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
                }
            }
            if (!possible)
                throw new Exception("Couldn't place ship");
            else {
                for (j = x - 1; j <= x + size_ship - 2; ++j) {
                    this.navires[i][j].setShip(ship);
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
                }
            }
            if (!possible)
                throw new Exception("Couldn't place ship");
            else {
                for (j = x - 1; j >= x - size_ship; --j) {
                    this.navires[i][j].setShip(ship);
                }
            }
        }
    }

    public boolean hasShip(int x, int y) throws Exception {
        int size_grid = this.frappes.length;
        if (x < 1 || x > size_grid || y < 1 || y > size_grid)
            throw new Exception("Index out of bound");
        return (this.navires[y - 1][x - 1].getShip() != null);
    }

    public void setHit(Boolean hit, int x, int y) throws Exception {
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

    public Hit sendHit(int x, int y) throws Exception {
        // on try si x et y sont dans le board
        try {
            if (hasShip(x, y)) {
                // si on a déjà frappé là ou le bateau est coulé c'est un miss
                if (this.navires[y - 1][x - 1].isStruck() || this.navires[y - 1][x - 1].isSunck()) {
                    return Hit.MISS;
                }
                // s'il y a un navire non frappé dans cette position
                else {
                    // on le frappe
                    this.navires[y - 1][x - 1].getShip().addStrike();
                    this.navires[y - 1][x - 1].setStruck(true);
                    // on vérifie s'il coule
                    if (this.navires[y - 1][x - 1].isSunck()) {
                        System.out.println("Le navire " + this.navires[y - 1][x - 1].getShip().getNom() + " "
                                + this.navires[y - 1][x - 1].toString() + " a coulé");
                        return Hit.fromInt(this.navires[y - 1][x - 1].getShip().getTaille());
                    } else {
                        return Hit.STIKE;
                    }
                }
            } else {
                return Hit.MISS;
            }
        // si index out of bound
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    public void print() {
        for (int i=0; i< 2*this.navires.length + 1; ++i) {
            System.out.print("*");
        }
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
                if (this.navires[i][j].getShip() == null)
                    System.out.print(". ");
                else if (this.navires[i][j].isStruck() && !this.navires[i][j].isSunck())
                    System.out.print(ColorUtil.colorize(this.navires[i][j].getShip().getLabel()+" ", ColorUtil.Color.YELLOW));
                else if (this.navires[i][j].isSunck())
                    System.out.print(ColorUtil.colorize(this.navires[i][j].getShip().getLabel()+" ", ColorUtil.Color.RED));
                else
                    System.out.print(ColorUtil.colorize(this.navires[i][j].getShip().getLabel()+" ", ColorUtil.Color.WHITE));
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
                if (this.frappes[i][j] == null)
                    System.out.print(". ");
                else if (this.frappes[i][j] == true)
                    if (this.navires[i][j].isSunck()) {
                        System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.RED));
                    }
                    else {
                        System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.YELLOW));
                    }   
                else
                    System.out.print(ColorUtil.colorize("X ", ColorUtil.Color.WHITE));
            }
            System.out.println();
        }

        System.out.println();
    }
}