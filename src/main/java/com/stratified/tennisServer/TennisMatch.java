/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stratified.tennisServer;

/**
 *
 * @author david
 */
public class TennisMatch {
    private Integer id;
    private String player1;
    private String player2;
    private Integer timeminutes;
    private Boolean ongoing;
    private Integer sets_player1;
    private Integer sets_player2;
    private Integer games_player1;
    private Integer games_player2;
    private Integer points_player1;
    private Integer points_player2;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the player1
     */
    public String getPlayer1() {
        return player1;
    }

    /**
     * @param player1 the player1 to set
     */
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    /**
     * @return the player2
     */
    public String getPlayer2() {
        return player2;
    }

    /**
     * @param player2 the player2 to set
     */
    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    /**
     * @return the timeminutes
     */
    public Integer getTimeminutes() {
        return timeminutes;
    }

    /**
     * @param timeminutes the timeminutes to set
     */
    public void setTimeminutes(Integer timeminutes) {
        this.timeminutes = timeminutes;
    }

    /**
     * @return the ongoing
     */
    public Boolean getOngoing() {
        return ongoing;
    }

    /**
     * @param ongoing the ongoing to set
     */
    public void setOngoing(Boolean ongoing) {
        this.ongoing = ongoing;
    }

    /**
     * @return the sets_player1
     */
    public Integer getSets_player1() {
        return sets_player1;
    }

    /**
     * @param sets_player1 the sets_player1 to set
     */
    public void setSets_player1(Integer sets_player1) {
        this.sets_player1 = sets_player1;
    }

    /**
     * @return the sets_player2
     */
    public Integer getSets_player2() {
        return sets_player2;
    }

    /**
     * @param sets_player2 the sets_player2 to set
     */
    public void setSets_player2(Integer sets_player2) {
        this.sets_player2 = sets_player2;
    }

    /**
     * @return the games_player1
     */
    public Integer getGames_player1() {
        return games_player1;
    }

    /**
     * @param games_player1 the games_player1 to set
     */
    public void setGames_player1(Integer games_player1) {
        this.games_player1 = games_player1;
    }

    /**
     * @return the games_player2
     */
    public Integer getGames_player2() {
        return games_player2;
    }

    /**
     * @param games_player2 the games_player2 to set
     */
    public void setGames_player2(Integer games_player2) {
        this.games_player2 = games_player2;
    }

    /**
     * @return the points_player1
     */
    public Integer getPoints_player1() {
        return points_player1;
    }

    /**
     * @param points_player1 the points_player1 to set
     */
    public void setPoints_player1(Integer points_player1) {
        this.points_player1 = points_player1;
    }

    /**
     * @return the points_player2
     */
    public Integer getPoints_player2() {
        return points_player2;
    }

    /**
     * @param points_player2 the points_player2 to set
     */
    public void setPoints_player2(Integer points_player2) {
        this.points_player2 = points_player2;
    }
    
    
}
