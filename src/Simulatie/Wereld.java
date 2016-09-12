package Simulatie;

import Database.Database;
import GUI.Hoofdscherm;
import Simulatie.BasisObject.Direction;
import Simulatie.Objecten.*;
import java.awt.Point;
import java.util.ArrayList;

public class Wereld {
    private Hoofdscherm scherm; // Referentie naar de GUI
    private Database dB; // Referentie naar de database
    private OnzeTimer oT;
    private Boolean engineRunning = false; // Simulatie gepauzeert of niet
    private Integer worldID; // De huidige wereld, 1 tot 9
    private Integer stapNummer;
    private ArrayList<BasisObject> objecten;
    
    private static int cellSize = 20; // De grootte van een cel
    private static int fieldSize = 16; // Het aantal vakjes in het veld op de x en y as
    
    public Wereld (Hoofdscherm scherm, Integer wereldID) {
        this.scherm = scherm;
        this.dB = new Database(this);
        this.stapNummer = 0;
        this.objecten = new ArrayList<>();
        this.worldID = wereldID;
        
        for (int i = 0; i < 5; i++)
            this.objecten.add(new Obstakel(this, new Point((int)(Math.random() * 13) + 2,(int)(Math.random() * 13) + 2)));
        
        for (int i = 0; i < 5; i++)
            this.objecten.add(new Plant(this, new Point((int)(Math.random() * 13) + 2,(int)(Math.random() * 13) + 2), 2));
        
        for (int i = 0; i < 2; i++)
            this.objecten.add(new Nonivoor(this, new Point((int)(Math.random() * 13) + 2,(int)(Math.random() * 13) + 2), Direction.Rechts));
        
        for (int i = 0; i < 2; i++)
            this.objecten.add(new Omnivoor(this, new Point((int)(Math.random() * 13) + 2,(int)(Math.random() * 13) + 2), Direction.Omhoog));
        
        // Start de simulatie
        //this.oT = new OnzeTimer(this);
    }
    
    // Deze methode werkt de simulatie 1 stap bij
    public void SimulatieStap() {
        // Geef alle objecten een update
        for (BasisObject O : this.getObjecten()) {
            O.UpdateObject();
        }
        
        this.stapNummer++;
        scherm.updateHoofdscherm();
        
        // Verwijder timer object en start overnieuw.
        if (this.oT != null) {
            this.oT.cancel();
            this.oT = null;
            this.oT = new OnzeTimer(this);
        }
    }
    
    // Deze methode vangt muisklikken op het veld op vanuit Hoofdscherm.
    // De meegekregen locatie is de veldpositie.
    public void VeldKlik(Point positie) {
        // niks
    }
    
    // Met deze methode wordt de simulatie gepauzeert en aangezet
    public void pauseSimulation(Boolean pause) {
        if (pause) { // Pauzeren
            this.engineRunning = false;
            this.oT.cancel(); // Cancel de timer
            this.oT = null; // Timerobject weggooien
        }
        else { // Starten
            this.engineRunning = true;
            this.oT = new OnzeTimer(this); // Nieuwe timer aanmaken
        }
        
        // Update de titelbalk van het hoofdscherm
        scherm.updateHoofdscherm();
    }
    
    // Met deze methode kan de huidige wereld veranderd worden
    public void VeranderWereldID(int world) {
        this.worldID = world;
        
        // Update de titelbalk van het hoofdscherm
        scherm.updateHoofdscherm();
    }

    /**
     * @return the World
     */
    public Integer getWorldID() {
        return worldID;
    }

    /**
     * @return the stapNummer
     */
    public Integer getStapNummer() {
        return stapNummer;
    }

    /**
     * @return the engineRunning
     */
    public Boolean getWereldRunning() {
        return engineRunning;
    }

    /**
     * @return the objecten
     */
    public ArrayList<BasisObject> getObjecten() {
        return objecten;
    }

    /**
     * @param objecten the objecten to set
     */
    public void setObjecten(ArrayList<BasisObject> objecten) {
        this.objecten = objecten;
    }
    
    public Integer SnelheidInstelling() {
        return this.scherm.SnelheidInstelling();
    }

    /**
     * @return the cellSize
     */
    static public int getCellSize() {
        return cellSize;
    }

    /**
     * @return the fieldSize
     */
    static public int getFieldSize() {
        return fieldSize;
    }
}
