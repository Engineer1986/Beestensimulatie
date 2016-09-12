/*
 * Omnivoren eten zowel planten als beesten
 */
package Simulatie.Objecten;

import Simulatie.Wereld;
import java.awt.Point;
import java.awt.Color;

public class Omnivoor extends Nonivoor {
    public Omnivoor (Wereld oureng, Point newpositie, Direction newrichting) {
        super (oureng, newpositie, newrichting);
        this.setKleur(Color.yellow);
    }
    
    @Override
    public void UpdateObject() {
        super.UpdateObject();
        
    }
}
