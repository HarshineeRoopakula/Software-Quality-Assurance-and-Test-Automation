package jukebox;

import Jukebox.Database;
import Jukebox.Song;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author Sai Harshinee
 */
public class DatabaseTest {
    private java.util.List songList, songList1;
    private Song testSong1,testSong2, testSong3;
    private Database testDB, testDB1;

    public DatabaseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        songList =  new java.util.ArrayList();
        songList1 =  new java.util.ArrayList();
        testSong1 = new Song("Kadhal Cricket", "Kharesma Ravichandran",
                "Thani Oruvan", "Cricket.mp3", "Mp3", 214);
        testSong2 = new Song("Kadhal Cricket", "Kharesma Ravichandran",
                "Thani Oruvan", "Cricket.mp3", "Mp3", 214);

        testSong3 = new Song("Kadhal Cricket", "Kharesma Ravichandran",
                "Thani Oruvan", "Cricket.mp3", "Mp3", 214);

        songList.add(testSong1);
        songList.add(testSong2);

        songList1.add(testSong1);

        testDB = new Database(songList);
        testDB1 = new Database(songList1);
    }
    @After
    public void tearDown() {
        songList = null;
        songList1 = null;
        testDB = null;
        testDB1 = null;
    }

    @Test
    public void testGetSongList() {
        System.out.println("Running testGetSongList method(Database class)...");
        assertEquals("get Songlist",songList,testDB.getSongList());
    }
    @Test
    public void testSetSongList() {
        System.out.println("Running testSetSongList method(Database class)...");
        testDB1.setSongList(songList1);
        assertEquals("get Songlist",songList1,testDB1.getSongList());
    }
    @Test
    public void testAddSong() {
        System.out.println("Running testAddSong method(Database class)...");
        testDB1.addSong(testSong3);
        assertEquals("get Songlist",songList1,testDB1.getSongList());
    }
    @Test
    public void testRemoveSong() {
        System.out.println("Running testRemoveSong method(Database class)...");
        testDB.removeSong(testSong1);
        assertEquals("get Songlist",songList,testDB.getSongList());
    }
    @Test
    public void testRemoveSongByIndex() {
        System.out.println("Running testRemoveSongByIndex method(Database class)...");
        testDB.removeSong(1);
        assertEquals("get Songlist",songList,testDB.getSongList());
    }
    @Test
    public void testIsEmpty() {
        System.out.println("Running testIsEmpty method(Database class)...");
        assertEquals("Database is not empty", false,testDB1.isEmpty());
    }
}

