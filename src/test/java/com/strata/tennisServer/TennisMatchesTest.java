/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.strata.tennisServer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author david
 */
public class TennisMatchesTest {
    
    public TennisMatchesTest() {
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
     * Test that we can add a new Game with two players
     * Input two players, returns a unique identifier for the match.
     */
    @Test
    public void testAddGame() {
        System.out.println("testAddGame");
        TennisMatches instance = new TennisMatches();
        String expResult = "";
        String result = instance.addGame("Peter", "John");
        assertEquals(expResult, result);
    }
    
     /**
     * Test that we can add a new point on a given match
     * Inputs the match id, the name of the last scoring player
     * Match exists, is not finished.
     * Test whether game has advanced one point on different situations.
     * Game point, set point, add point, tie brake cases.
     */
    @Test
    public void testAddPoint() {
        System.out.println("addPoint");
        TennisMatches instance = new TennisMatches();
        String expResult = "";
        String result = instance.addPoint("34442","John");
        assertEquals(expResult, result);
    }
    
    /**
     * Test with a given identifier that it returns the expected mocked name of players, 
     * status of match, duration of play and score based on a previous initiated match and scores input
     */
    @Test
    public void statusMatch() {
        System.out.println("statusMatch");
        TennisMatches instance = new TennisMatches();
        String expResult = "";
        String result = instance.statusMatch("34442");
        assertEquals(expResult, result);
    }
    
}
