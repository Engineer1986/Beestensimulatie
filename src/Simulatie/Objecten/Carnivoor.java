/*
 * Carnivoren eten enkel planten
 * 
 * Een Carnivoor extend de Omnivoor klasse, waarbij de EetBeest() methode
 * override wordt met een lege variant.
 */
package Simulatie.Objecten;

import Simulatie.Wereld;
import java.awt.Color;
import java.awt.Point;

public class Carnivoor extends Nonivoor {
    
    public Carnivoor (Wereld oureng, Point newpositie, Direction newrichting) {
        super (oureng, newpositie, newrichting);
        this.setKleur(Color.red);
    }
}
