/*
 * Obstakel object.
 */
package Simulatie.Objecten;

import Simulatie.Wereld;
import Simulatie.BasisObject;
import java.awt.Color;
import java.awt.Point;

public class Obstakel extends BasisObject {
    public Obstakel (Wereld oureng, Point newpositie) {
        super (oureng, newpositie, Direction.Geen);
        this.setKleur(Color.black);
    }
    
    @Override
    public void UpdateObject() {
        super.UpdateObject();
    }
    
    @Override
    public Point BotstMet(Point nieuwePositie, BasisObject o) {
        switch (o.getRichting()) {
            case Omhoog:
                o.setRichting(Direction.Rechts);
                break;
            case Omlaag:
                o.setRichting(Direction.Links);
                break;
            case Links:
                o.setRichting(Direction.Omhoog);
                break;
            case Rechts:
                o.setRichting(Direction.Omlaag);
                break;
        }
        
        o.UpdateObject();
        return o.getPositie();
    }
}
