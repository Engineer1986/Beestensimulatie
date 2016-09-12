package Simulatie;

import java.awt.Color;
import java.awt.Point;

/**
 * Dit is de basis klasse voor alle in-simulatie objecten.
 * 
 * Kent enkel positie variabelen + getters en setters.
 * @author Richard
 */
public abstract class BasisObject {
    private Wereld eng;
    private Point positie;
    private Direction richting;
    private Color kleur;

    /**
     * @return the richting
     */
    public Direction getRichting() {
        return richting;
    }

    /**
     * @param richting the richting to set
     */
    public void setRichting(Direction richting) {
        this.richting = richting;
    }
    
    public enum Direction {
        Omhoog, Omlaag, Links, Rechts, Geen
    }
    
    public BasisObject(Wereld oureng, Point newpositie, Direction newrichting) {
        // Initialiseer variabelen
        this.positie = newpositie;
        this.richting = newrichting;
        this.kleur = new Color(0,0,0);
        this.eng = oureng;
    }
    
    public void UpdateObject() {
        Point nieuwePositie = new Point(this.getPositie().x, this.getPositie().y);
        
        switch (this.getRichting()) {
            case Omhoog:
                nieuwePositie.y--;
                break;
            case Omlaag:
                nieuwePositie.y++;
                break;
            case Links:
                nieuwePositie.x--;
                break;
            case Rechts:
                nieuwePositie.x++;
                break;
        }
        
        
        /* Loop door alle objecten, als dit object met een ander object botst,
         * laat dit weten aan het object waarmee het botst.
         * 
         * Een obstakel kan de richting veranderen, een plant kan energie afgeven,
         * een carnivoor kan een beest of plant opeten, etc.
         */
        
        for (BasisObject O : this.eng.getObjecten())
            if (O != this && O.getPositie().x == nieuwePositie.x && O.getPositie().y == nieuwePositie.y) {
                nieuwePositie = O.BotstMet(nieuwePositie, this);
            }
        
        this.setPositie(nieuwePositie);
    }
    
    public Point BotstMet(Point nieuwePositie, BasisObject o) {
        return nieuwePositie;
    }
    
    /**
     * @return the positie
     */
    public Point getPositie() {
        return this.positie;
    }

    /**
     * @param positie the positie to set
     */
    public void setPositie(Point newpos) {
        /* Als de nieuwe positie buiten de wereld valt, checken of er een
         * buur-wereld bestaat. Zo niet dan verschijnt het object weer
         * in de meest tegenovergestelde wereld.
         */
        
        //Integer nieuweWereldID = this.eng.getWorldID();
        
        if (newpos.x < 0) { // Naar links
            newpos.x = Wereld.getFieldSize() - 1;
        }
        
        if (newpos.x > Wereld.getFieldSize() - 1) { // Naar rechts
            newpos.x = 0;
        }
        
        if (newpos.y < 0) { // Omhoog
            newpos.y = Wereld.getFieldSize() - 1;
        }
        
        if (newpos.y > Wereld.getFieldSize() - 1) { // Omlaag
            newpos.y = 0;
        }
        
        this.positie = newpos;
    }

    /**
     * @return the kleur
     */
    public Color getKleur() {
        return kleur;
    }

    /**
     * @param kleur the kleur to set
     */
    public void setKleur(Color kleur) {
        this.kleur = kleur;
    }
}
