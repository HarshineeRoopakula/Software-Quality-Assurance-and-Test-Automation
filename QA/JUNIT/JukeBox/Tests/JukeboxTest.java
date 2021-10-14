package jukebox;

import Jukebox.Database;
import Jukebox.Jukebox;
import Jukebox.Song;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Sai Harshinee
 */

public class JukeboxTest {
    private Jukebox testJB;
    private Database db1, db2;
    private List songListJB1;
    private List songListJB2;
    private Song song1,song2;
    private int ccn=1234567;

    public JukeboxTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        song1 = new Song("Kadhal Cricket", "Kharesma Ravichandran",
                "Thani Oruvan", "Cricket.mp3", "Mp3", 214);
        song2 = new Song("Kadhal Cricket", "Kharesma Ravichandran",
                "Thani Oruvan", "Cricket.mp3", "Mp3", 214);

        songListJB1 = new java.util.ArrayList();
        songListJB2 = new java.util.ArrayList();
        songListJB2.add(song1);

        songListJB1.add(song1);
        songListJB1.add(song2);

        db1 = new Database(songListJB1);
        db2 = new Database(songListJB2);

        testJB = new Jukebox(db1,ccn);
    }

    @After
    public void tearDown() {
        testJB = null;
    }

    @Test
    public void testGetCreditCard() {
        System.out.println("Running testGetCreditCard method(Jukebox class)...");
        assertEquals("Get Credit card number",1234567,testJB.getCreditCard());
    }

    @Test
    public void testSetCreditCard() {
        System.out.println("Running testSetCreditCard method(Jukebox class)...");
        testJB.setCreditCard(123456789);
        assertEquals("Get Credit card number",123456789,testJB.getCreditCard());
    }

    @Test
    public void testGetDb() {
        System.out.println("Running testGetDb method(Jukebox class)...");
        assertNotNull("Get Database",testJB.getDb());
        assertTrue("Get Database",testJB.getDb() instanceof Database);
        assertEquals("Get Credit card number",1234567,testJB.getCreditCard());
        assertEquals("Get Song List",2,testJB.getDb().getSongList().size());
    }

    @Test
    public void testSetDb() {
        System.out.println("Running testSetDb method(Jukebox class)...");
        testJB.setDb(db2);
        assertNotNull("Get Database",testJB.getDb());
        assertTrue("Get Database",testJB.getDb() instanceof Database);
        assertEquals("Get Credit card number",1234567,testJB.getCreditCard());
        assertEquals("Get Song List",1,testJB.getDb().getSongList().size());
    }

    @Test
    public void testIsValidCreditCard() {
        System.out.println("Running testIsValidCreditCard method(Jukebox class)...");
        assertEquals("Credit card is valid if value is greater than 0",true,testJB.isValidCreditCard());
    }
}
