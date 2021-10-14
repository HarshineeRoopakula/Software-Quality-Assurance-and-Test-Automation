package jukebox;

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

public class SongTest {
    private Song testSong1, testSong2;

    public SongTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testSong1 = new Song("Kadhal Cricket", "Kharesma Ravichandran",
                "Thani Oruvan", "Cricket.mp3", "Mp3", 214);
        testSong2 = new Song("Kadhal Cricket", "Kharesma Ravichandran",
                "Thani Oruvan", "Cricket.mp3", "Mp3", 214);
    }

    @After
    public void tearDown() {
        testSong1 = null;
        testSong2 = null;
    }

    @Test
    public void testGetName() {
        System.out.println("Running testGetName method(Song class) ...");
        assertEquals("Song names are equal", "Kadhal Cricket", testSong1.getName());
    }

    @Test
    public void testSetName() {
        System.out.println("Running testSetName method(Song class) ...");
        testSong1.setName("Kannala Kannala");
        assertEquals("Song names are equal", "Kannala Kannala", testSong1.getName());
    }

    @Test
    public void testGetArtist() {
        System.out.println("Running testGetArtist method(Song class)...");
        assertEquals("Song artists are equal", "Kharesma Ravichandran", testSong1.getArtist());
    }

    @Test
    public void testSetArtist() {
        System.out.println("Running testSetArtist method(Song class)...");
        testSong1.setArtist("Kaushik Krish");
        assertEquals("Song artists are equal", "Kaushik Krish", testSong1.getArtist());
    }

    @Test
    public void testGetAlbum() {
        System.out.println("Running testGetAlbum method(Song class)...");
        assertEquals("Song albums are equal", "Thani Oruvan", testSong1.getAlbum());
    }
    @Test
    public void testSetAlbum() {
        System.out.println("Running testSetAlbum method(Song class)...");
        testSong1.setAlbum("Lovely");
        assertEquals("Song albums are equal", "Lovely", testSong1.getAlbum());
    }

    @Test
    public void testGetUrl() {
        System.out.println("Running testGetUrl method(Song class)...");
        assertEquals("Song urls are equal", "Cricket.mp3", testSong1.getUrl());
    }

    @Test
    public void testSetUrl() {
        System.out.println("Running testSetUrl method(Song class)...");
        testSong1.setUrl("Kannala.mp3");
        assertEquals("Song urls are equal", "Kannala.mp3", testSong1.getUrl());
    }

    @Test
    public void testGetFormat() {
        System.out.println("Running testGetFormat method(Song class)...");
        assertEquals("Song formats are equal", "Mp3", testSong1.getFormat());
    }

    @Test
    public void testSetFormat() {
        System.out.println("Running testSetFormat method(Song class)...");
        testSong1.setFormat("Mp4");
        assertEquals("Song formats are equal", "Mp4", testSong1.getFormat());
    }

    @Test
    public void testGetDuration() {
        System.out.println("Running testGetDuration method(Song class)...");
        assertEquals("Song durations are equal", 214, testSong1.getDuration());
    }

    @Test
    public void testSetDuration() {
        System.out.println("Running testSetDuration method(Song class)...");
        testSong1.setDuration(300);
        assertEquals("Song durations are equal", 300, testSong1.getDuration());
    }

    @Test
    public void testIsLong1() {
        assertEquals("Song is long if length is more than 50", true, testSong1.isLong());
    }

    @Test
    public void testIsLong2() {
        assertEquals("Song is long if length is more than 50", true, testSong2.isLong());
    }
}
