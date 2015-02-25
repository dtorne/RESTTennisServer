package com.strata.tennisServer;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "tennismatches" path)
 */
@Path("tennismatches")
public class TennisMatches {

    /**
     * Method HTTP PUT request
     * Given two players input strings, the method creates a new game and updates the database
     *
     * @param player1
     * @param player2
     * @return Returns unique Id identifier for the game as a text/plain response.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String addGame(@FormParam("player1") String player1,@FormParam("player2") String player2) {
        return "";
    }
    
    /**
     * Method HTTP POST request
     * Given an id match in the path of the url ex http://localhost:8080/webapp/tennismatches/1
     * and the name of the scoring player, updates the match with the new point
     *
     * @param idMatch
     * @param playerScoring
     * @return Success if updated correctly
     */
    @Path("{idMatch}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addPoint(@PathParam("id") String idMatch, @FormParam("playerScoring") String playerScoring) {
        return "";
    }
    
     /**
     * Method HTTP GET request
     * Given an id match in the path of the url ex http://localhost:8080/webapp/tennismatches/1
     * it returns the sets, games and points of every player, their names, status of match and duration of game
     *
     * @param idMatch
     * @param playerScoring
     * @return Success if updated correctly
     */
    @Path("{idMatch}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String statusMatch(@PathParam("idMatch") String idMatch) {
        return "";
    }
    
    
}
