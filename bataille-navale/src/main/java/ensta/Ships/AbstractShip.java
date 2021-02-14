package ensta.Ships;
import ensta.*;

public class AbstractShip {
    protected char label;
    protected String nom;
    protected int taille;
    protected Orientation orientation;

    public char getLabel() {
        return this.label;
    }

    public String getNom() {
        return this.nom;
    }

    public int getTaille() {
        return this.taille;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public void setOrientation(Orientation o) {
        this.orientation = o;
    }

    public AbstractShip(char l, String n, int t, Orientation o) {
        this.label = l;
        this.nom = n;
        this.taille = t;
        this.orientation = o;
    }
}


