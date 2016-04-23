package net.projet2501.swapigraphql.api.model;


import java.io.Serializable;

/**
 * Created by Oleur on 21/12/2014.
 * Root model that provides information on all avaiable resources within the API.
 */
public class Root implements Serializable {

    private String films;
    private String people;
    private String planets;
    private String species;
    private String starships;
    private String vehicles;

    /**
     * @return the films
     */
    public String getFilms() {
        return films;
    }

    /**
     * @param films the films to set
     */
    public void setFilms(String films) {
        this.films = films;
    }

    /**
     * @return the people
     */
    public String getPeople() {
        return people;
    }

    /**
     * @param people the people to set
     */
    public void setPeople(String people) {
        this.people = people;
    }

    /**
     * @return the planets
     */
    public String getPlanets() {
        return planets;
    }

    /**
     * @param planets the planets to set
     */
    public void setPlanets(String planets) {
        this.planets = planets;
    }

    /**
     * @return the species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * @return the starships
     */
    public String getStarships() {
        return starships;
    }

    /**
     * @param starships the starships to set
     */
    public void setStarships(String starships) {
        this.starships = starships;
    }

    /**
     * @return the vehicles
     */
    public String getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }
    
    
    
}
