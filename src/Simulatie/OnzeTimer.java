package Simulatie;

import java.util.Timer;
import java.util.TimerTask;

/** De timer die steeds de simulatie even laat wachten en opnieuw de 
 * SimulatieStap() methode aanroept in Wereld.
 * 
 * @author Richard
 */
public class OnzeTimer extends TimerTask {
    private Wereld eng;
    private Timer timer;
    
    public OnzeTimer(Wereld engine) {
        this.eng = engine;
        
        // Maak een nieuwe Timer object en start deze 
        this.timer = new Timer(true);
        this.timer.schedule(this, eng.SnelheidInstelling());

        //System.out.println(eng.SnelheidInstelling());
    }
    
    // TimerTask roept telkens deze methode aan
    @Override
    public void run() {
        this.eng.SimulatieStap(); // Verwijzen door naar SimulatieStap
        this.timer = null;
    }
}
