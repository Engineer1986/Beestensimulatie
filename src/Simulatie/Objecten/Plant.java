package Simulatie.Objecten;

import Simulatie.Wereld;
import Simulatie.BasisObject;
import java.awt.Color;
import java.awt.Point;

public final class Plant extends BasisObject {
    private Integer formaat = 10; // (0 t/m 10) = gelijk aan energieniveau, 0 = dode plant
    private Boolean leeft = true; // Dood / leeft status
    private Integer generatiesSindsDood = 100; // Het aantal updates sinds de plant dood ging
    
    public Plant (Wereld oureng, Point newpositie, Integer newformaat) {
        super (oureng, newpositie, Direction.Geen);
        
        this.formaat = newformaat;
        
        // Voer 1x een update uit zodat de kleur goed staat.
        this.UpdateObject();
    }
    
    @Override
    public void UpdateObject() {
        super.UpdateObject();
        
        // Als de plant dood was, maar 100 generaties zijn verstreken, leven.
        if (this.leeft == false && this.generatiesSindsDood >= 100)
        {
            this.leeft = true;
            this.formaat = 1;
        }
        
        // Formaat is nul geworden, plantstatus gaat naar dood
        if (this.formaat == 0)
        {
            this.leeft = false;
            this.generatiesSindsDood = 0;
        }
        
        if (!leeft) { // Plant is dood, kleur hem grijs
                this.generatiesSindsDood++;
        }
        
        // geef groen-tint afhankelijk van het formaat
        this.setKleur(new Color(0,20 + (this.formaat*20),0));
            
        this.formaat++;
        if (this.formaat > 10)
            this.formaat = 10;
    }
}
