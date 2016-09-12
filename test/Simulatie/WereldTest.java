/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulatie;

import GUI.Hoofdscherm;
import java.awt.Point;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richard
 */
public class WereldTest {
    
    public WereldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SimulatieStap method, of class Wereld.
      Geeft altijd een void terug dus hoeft niet getest te worden.
    @Test
    public void testSimulatieStap() {
        System.out.println("SimulatieStap");
        Wereld instance = null;
        instance.SimulatieStap();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of VeldKlik method, of class Wereld.
     Buiten werking, hoeft niet getest te worden
    @Test
    public void testVeldKlik() {
        System.out.println("VeldKlik");
        Point positie = null;
        Wereld instance = null;
        instance.VeldKlik(positie);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of pauseSimulation method, of class Wereld.
     Geeft altijd void terug, hoeft niet getest te worden.
    @Test
    public void testPauseSimulation() {
        System.out.println("pauseSimulation");
        Boolean pause = null;
        Wereld instance = null;
        instance.pauseSimulation(pause);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of VeranderWereldID method, of class Wereld.
     */
    @Test
    public void testVeranderWereldID() {
        System.out.println("VeranderWereldID");
        int world = 43;
        Wereld instance = new Wereld(new Hoofdscherm(), 0);
        instance.VeranderWereldID(world);
        
        long result = instance.getWorldID();
        assertEquals(world, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getWorldID method, of class Wereld.
     */
    @Test
    public void testGetWorldID() {
        System.out.println("getWorldID");
        Wereld instance = new Wereld(new Hoofdscherm(), 2);
        Integer expResult = 2;
        Integer result = instance.getWorldID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getStapNummer method, of class Wereld.
     */
    @Test
    public void testGetStapNummer() {
        System.out.println("getStapNummer");
        Wereld instance = new Wereld(new Hoofdscherm(), 0);
        Integer expResult = 0;
        Integer result = instance.getStapNummer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getWereldRunning method, of class Wereld.
     */
    @Test
    public void testGetWereldRunning() {
        System.out.println("getWereldRunning");
        Wereld instance = new Wereld(new Hoofdscherm(), 0);
        Boolean expResult = false;
        Boolean result = instance.getWereldRunning();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getObjecten method, of class Wereld.
     *
     * Dit valt niet te testen, de inhoud van de Objecten lijst is te onvoorspelbaar.
     * 
    @Test
    public void testGetObjecten() {
        System.out.println("getObjecten");
        Wereld instance = new Wereld(new Hoofdscherm(), 0);
        ArrayList<BasisObject> expResult = null;
        ArrayList<BasisObject> result = instance.getObjecten();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of setObjecten method, of class Wereld.
     */
    @Test
    public void testSetObjecten() {
        System.out.println("setObjecten");
        ArrayList<BasisObject> objecten = null;
        Wereld instance = new Wereld(new Hoofdscherm(), 0);
        instance.setObjecten(objecten);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SnelheidInstelling method, of class Wereld.
     */
    @Test
    public void testSnelheidInstelling() {
        System.out.println("SnelheidInstelling");
        Wereld instance = new Wereld(new Hoofdscherm(), 0);
        Integer expResult = 300;
        Integer result = instance.SnelheidInstelling();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCellSize method, of class Wereld.
     */
    @Test
    public void testGetCellSize() {
        System.out.println("getCellSize");
        int expResult = 20;
        int result = Wereld.getCellSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getFieldSize method, of class Wereld.
     */
    @Test
    public void testGetFieldSize() {
        System.out.println("getFieldSize");
        int expResult = 16;
        int result = Wereld.getFieldSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
