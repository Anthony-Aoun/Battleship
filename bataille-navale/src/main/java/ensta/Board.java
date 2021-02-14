package ensta;

public class Board {
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
                    System.out.println("x ");
            }
            System.out.println();
        }
    }
}