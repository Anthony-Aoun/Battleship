package ensta.Ships;

import ensta.*;

public class AbstractShip {
    protected char label;
    protected String nom;
    protected int taille;
    protected Orientation orientation;
    protected int strikeCount;

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

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public void setOrientation(Orientation o) {
        this.orientation = o;
    }

    public void addStrike() throws Exception {
        if (this.strikeCount >= this.taille)
            throw new Exception("Max number of possible strikes reached");
        else
            this.strikeCount++;
    }

    public boolean isSunck() {
        try {
            if(this.strikeCount >= this.taille)
                return true;
            else
                return false;
        } catch(Exception e) {
            return false;
        }
        
    }

    public AbstractShip(char l, String n, int t, Orientation o) {
        this.label = l;
        this.nom = n;
        this.taille = t;
        this.orientation = o;
        this.strikeCount = 0;
    }
}
