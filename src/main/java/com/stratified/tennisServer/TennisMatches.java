package com.stratified.tennisServer;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Root resource (exposed at "tennismatches" path)
 */
@Path("tennismatches")
public class TennisMatches {

    private static final String dbURL = "jdbc:derby://localhost:1527/myDB;create=true;user=mine;password=mine";
    private static final String tableName = "tennismatches";
    // jdbc Connection
    private static Connection conn = null;
    private static Statement stmt = null;

    /**
     * Method HTTP PUT request Given two players input strings, the method
     * creates a new game and updates the database
     *
     * @param player1
     * @param player2
     * @return Returns unique Id identifier for the game as a text/plain
     * response.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String addGame(@FormParam("player1") String player1, @FormParam("player2") String player2) {

        return "";
    }

    /**
     * Method HTTP POST request Given an id match in the path of the url ex
     * http://localhost:8080/webapp/tennismatches/1 and the name of the scoring
     * player, updates the match with the new point
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
     * Method HTTP GET request Given an id match in the path of the url ex
     * http://localhost:8080/tennismatches/1 it returns the sets, games and
     * points of every player, their names, status of match and duration of game
     *
     * @param idMatch
     * @return Success if updated correctly
     */
    @Path("{idMatch}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response statusMatch(@PathParam("idMatch") String idMatch) {
        TennisMatch tennisMatch = selectTennisMatch(idMatch);
        
        if (tennisMatch == null) {
            Response.status(404).
                    build();
        }
        else {
            return Response.status(200).entity(tennisMatch.toString()).build();
        }
        return null;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response wellcome() {
        return Response.status(200).entity("Wellcome to tennis server").build();
    }

    private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            //Get a connection
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static TennisMatch selectTennisMatch(String id) {
        TennisMatch tennisMatch = null;
        try {
            stmt = (Statement) conn.createStatement();
            ResultSet results = stmt.executeQuery("select * from " + tableName + " where id="+id);
            ResultSetMetaData rsmd = results.getMetaData();
            tennisMatch = new TennisMatch();
           
            while (results.next()) {
                tennisMatch.setId(results.getInt(1));
                tennisMatch.setPlayer1(results.getString(2));
                tennisMatch.setPlayer2(results.getString(3));
                tennisMatch.setTimeminutes(results.getInt(4));
                tennisMatch.setOngoing(results.getBoolean(5));
                tennisMatch.setSets_player1(results.getInt(6));
                tennisMatch.setSets_player2(results.getInt(7));
                tennisMatch.setGames_player1(results.getInt(8));
                tennisMatch.setGames_player2(results.getInt(9));
                tennisMatch.setPoints_player1(results.getInt(10));
                tennisMatch.setPoints_player2(results.getInt(11));
            }
            results.close();
            stmt.close();
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        }
        return tennisMatch;
    }

}
