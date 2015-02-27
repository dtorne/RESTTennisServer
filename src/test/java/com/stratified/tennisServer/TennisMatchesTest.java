/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stratified.tennisServer;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.glassfish.jersey.client.ClientConfig;

/**
 *
 * @author david
 */
public class TennisMatchesTest extends JerseyTest {
    
    ClientConfig config;
    Client client;
    WebTarget target;
    static final Logger logger = Logger.getLogger(TennisMatchesTest.class);

    public TennisMatchesTest() {
    }

    @Override
    protected Application configure() {
        return new ResourceConfig(TennisMatches.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    @Override
    public void setUp() {

        //Configure client
        config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        target = client.target(getBaseURI());
        //Configure logger
        BasicConfigurator.configure();

    }

    @After
    @Override
    public void tearDown() {
    }

    /**
     * Test that we can add a new Game with two players Input two players,
     * returns a unique identifier for the match.
     */
    @Test
    public void testAddGame() {
        logger.debug("testAddGame");
        TennisMatches instance = new TennisMatches();
        String expResult = "";
        String result = instance.addGame("Peter", "John");
        assertEquals(expResult, result);

//        String responseMsg = target().path("tennismatches").request().get(String.class);
//
//        assertEquals("Hello, Heroku!", responseMsg);
    }

    /**
     * Test that we can add a new point on a given match Inputs the match id,
     * the name of the last scoring player Match exists, is not finished. Test
     * whether game has advanced one point on different situations. Game point,
     * set point, add point, tie brake cases.
     */
    @Test
    public void testAddPoint() {
        logger.debug("addPoint");
        TennisMatches instance = new TennisMatches();
        String expResult = "";
        String result = instance.addPoint("34442", "John");
        assertEquals(expResult, result);
    }

    /**
     * Test with a given identifier that it returns the expected mocked name of
     * players, status of match, duration of play and score based on a previous
     * initiated match and scores input
     */
    @Test
    public void testStatusMatch() {
        logger.debug("statusMatch");
        TennisMatches instance = new TennisMatches();
        String expResult = "";
        String result = instance.statusMatch("34442");
        
        //Test case match id does not exist
        //Responds 404 error not found
        final Response responseTest1 = target.path("1111").request()
                .accept(MediaType.APPLICATION_JSON).get(Response.class);
        assertEquals(404,responseTest1.getStatus());
        
        //Test case match id does not exist
        //Responds a predifined information for using 3424
        //TODO We mock the db connection with this values on the db
        final Response responseTest2 = target.path("11111").request()
                .accept(MediaType.APPLICATION_JSON).get(Response.class);
        
        assertEquals("{\"id\":3424,\"player1\":\"Anna\",\"player2\":\"Sandra\",\"status\":\"ongoing\",\"duration\":120,\"score\":\"setsgamesandpoints\"}"
                ,responseTest2.toString());
        
        
        
        
    }

    @Test
    public void testWellcome() {       

        final String resMsg = target.request()
                .accept(MediaType.APPLICATION_JSON).get(Response.class)
                .toString();

        logger.debug("Wellocme test");
        assertEquals("Wellcome to tennis server", resMsg);
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/tennismatches").build();
    }

}
