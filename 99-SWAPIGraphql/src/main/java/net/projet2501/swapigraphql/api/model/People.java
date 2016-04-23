package net.projet2501.swapigraphql.api.model;


import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleur on 21/12/2014.
 * People model represents an individual person or character within the Star Wars universe.
 */
@XmlRootElement
public class People extends SWAPIObject  implements Serializable {

    @XmlElement(name = "birth_year")
    private String birthYear;
    private String gender;
    @XmlElement(name = "hair_color")
    private String hairColor;
    @XmlElement(name = "eye_color")
    private String eyeColor;
    private String height;
    private String homeworld;
    private String mass;
    @XmlElement(name = "skin_color")
    private String skinColor;
    
    private ArrayList<String> films;
    private ArrayList<String> species;
    private ArrayList<String> starships;
    private ArrayList<String> vehicles;

    /**
     * @return the birthYear
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * @param birthYear the birthYear to set
     */
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

   

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the hairColor
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     * @param hairColor the hairColor to set
     */
    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    

    /**
     * @return the mass
     */
    public String getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(String mass) {
        this.mass = mass;
    }

    /**
     * @return the skinColor
     */
    public String getSkinColor() {
        return skinColor;
    }

    /**
     * @param skinColor the skinColor to set
     */
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    /**
     * @return the eyeColor
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * @param eyeColor the eyeColor to set
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * @return the homeworld
     */
    public String getHomeworld() {
        return homeworld;
    }

    /**
     * @param homeworld the homeworld to set
     */
    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    /**
     * @return the films
     */
    public ArrayList<String> getFilms() {
        return films;
    }

    /**
     * @param films the films to set
     */
    public void setFilms(ArrayList<String> films) {
        this.films = films;
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

    
    
    
}
