package net.projet2501.swapigraphql.api.model;


import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleur on 21/12/2014.
 * Film model represents a Star Wars single film.
 */
@XmlRootElement
public class Film extends SWAPIObject implements Serializable {
    
    @XmlElement(name = "title")
    private String name;
    
    @XmlElement(name ="episode_id")
    private int episodeId;
    @XmlElement(name ="opening_crawl")
    private String openingCrawl;
    private String director;
    private String producer;
    @XmlElement(name="release_date")
    private String releaseDate;
    
    
    private ArrayList<String> species;
    private ArrayList<String> starships;
    private ArrayList<String> vehicles;
    private ArrayList<String> planets;
    private ArrayList<String> characters;

    /**
     * @return the title
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the title to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the episodeId
     */
    public int getEpisodeId() {
        return episodeId;
    }

    /**
     * @param episodeId the episodeId to set
     */
    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    /**
     * @return the openingCrawl
     */
    public String getOpeningCrawl() {
        return openingCrawl;
    }

    /**
     * @param openingCrawl the openingCrawl to set
     */
    public void setOpeningCrawl(String openingCrawl) {
        this.openingCrawl = openingCrawl;
    }

    /**
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * @return the releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * @return the species
     */
    public ArrayList<String> getSpecies() {
        return species;
    }

    /**
     * @param species the species to set
     */
    public void setSpecies(ArrayList<String> species) {
        this.species = species;
    }

    /**
     * @return the starships
     */
    public ArrayList<String> getStarships() {
        return starships;
    }

    /**
     * @param starships the starships to set
     */
    public void setStarships(ArrayList<String> starships) {
        this.starships = starships;
    }

    /**
     * @return the vehicles
     */
    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(ArrayList<String> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * @return the planets
     */
    public ArrayList<String> getPlanets() {
        return planets;
    }

    /**
     * @param planets the planets to set
     */
    public void setPlanets(ArrayList<String> planets) {
        this.planets = planets;
    }

    /**
     * @return the characters
     */
    public ArrayList<String> getCharacters() {
        return characters;
    }

    /**
     * @param characters the characters to set
     */
    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }
    
    
    
}
