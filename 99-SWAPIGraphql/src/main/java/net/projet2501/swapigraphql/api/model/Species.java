package net.projet2501.swapigraphql.api.model;


import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleur on 22/12/2014.
 * Species model represents a type of person or character within the Star Wars Universe.
 */
@XmlRootElement
public class Species extends SWAPIObject implements Serializable {
    
    private String classification;
    private String designation;
    @XmlElement(name = "average_height")
    private String averageHeight;
    @XmlElement(name = "average_lifespan")
    private String averageLifespan;
    @XmlElement(name = "eye_colors")
    private String eyeColors;
    @XmlElement(name = "hair_colors")
    private String hairColors;
    @XmlElement(name = "skin_colors")
    private String skinColors;
    private String homeworld;
    private String language;

    private ArrayList<String> people;
    private ArrayList<String> films;

    /**
     * @return the classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the averageHeight
     */
    public String getAverageHeight() {
        return averageHeight;
    }

    /**
     * @param averageHeight the averageHeight to set
     */
    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    /**
     * @return the averageLifespan
     */
    public String getAverageLifespan() {
        return averageLifespan;
    }

    /**
     * @param averageLifespan the averageLifespan to set
     */
    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    /**
     * @return the eyeColors
     */
    public String getEyeColors() {
        return eyeColors;
    }

    /**
     * @param eyeColors the eyeColors to set
     */
    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    /**
     * @return the hairColors
     */
    public String getHairColors() {
        return hairColors;
    }

    /**
     * @param hairColors the hairColors to set
     */
    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    /**
     * @return the skinColors
     */
    public String getSkinColors() {
        return skinColors;
    }

    /**
     * @param skinColors the skinColors to set
     */
    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
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
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the people
     */
    public ArrayList<String> getPeople() {
        return people;
    }

    /**
     * @param people the people to set
     */
    public void setPeople(ArrayList<String> people) {
        this.people = people;
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
    
    
}
