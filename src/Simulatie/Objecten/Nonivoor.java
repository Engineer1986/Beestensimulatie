/*
 * Nonivoor klasse.
 * 
 * Dit is een abstracte klasse waaronder de Omnivoren en Carnivoren vallen.
 */

package Simulatie.Objecten;
import Simulatie.Wereld;
import Simulatie.BasisObject;
import java.awt.Color;
import java.awt.Point;

public class Nonivoor extends BasisObject {
    
    public Nonivoor (Wereld oureng, Point newpositie, Direction newrichting) {
        super (oureng, newpositie, newrichting);
        this.setKleur(Color.MAGENTA);
    }
    
    @Override
    public void UpdateObject() {
        super.UpdateObject();
    }
}
