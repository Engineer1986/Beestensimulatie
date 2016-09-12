package Simulatie.Objecten;

import Simulatie.BasisObject;
import Simulatie.Wereld;
import java.awt.Color;
import java.awt.Point;

public class Herbivoor extends Nonivoor {
    public Herbivoor (Wereld oureng, Point newpositie, BasisObject.Direction newrichting) {
        super (oureng, newpositie, newrichting);
        this.setKleur(new Color(185, 122, 87)); // Bruin
    }
}
