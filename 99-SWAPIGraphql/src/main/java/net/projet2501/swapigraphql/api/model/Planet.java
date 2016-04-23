package net.projet2501.swapigraphql.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleur on 22/12/2014. Planet model represents a large mass, planet
 * or planetoid in the Star Wars Universe, at the time of 0 ABY.
 */
@XmlRootElement
public class Planet extends SWAPIObject implements Serializable {

    private String diameter;
    private String gravity;
    private String population;
    private String climate;
    private String terrain;
    
    @XmlElement(name = "rotation_period")
    private String rotationPeriod;
    @XmlElement(name = "orbital_period")
    private String orbitalPeriod;
    @XmlElement(name = "surface_water")
    private String surfaceWater;

    private ArrayList<String> residents;
    private ArrayList<String> films;

    /**
     * @return the diameter
     */
    public String getDiameter() {
        return diameter;
    }

    /**
     * @param diameter the diameter to set
     */
    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    /**
     * @return the gravity
     */
    public String getGravity() {
        return gravity;
    }

    /**
     * @param gravity the gravity to set
     */
    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    /**
     * @return the population
     */
    public String getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(String population) {
        this.population = population;
    }

    /**
     * @return the climate
     */
    public String getClimate() {
        return climate;
    }

    /**
     * @param climate the climate to set
     */
    public void setClimate(String climate) {
        this.climate = climate;
    }

    /**
     * @return the terrain
     */
    public String getTerrain() {
        return terrain;
    }

    /**
     * @param terrain the terrain to set
     */
    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    /**
     * @return the rotationPeriod
     */
    public String getRotationPeriod() {
        return rotationPeriod;
    }

    /**
     * @param rotationPeriod the rotationPeriod to set
     */
    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    /**
     * @return the orbitalPeriod
     */
    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    /**
     * @param orbitalPeriod the orbitalPeriod to set
     */
    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    /**
     * @return the surfaceWater
     */
    public String getSurfaceWater() {
        return surfaceWater;
    }

    /**
     * @param surfaceWater the surfaceWater to set
     */
    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    /**
     * @return the residents
     */
    public ArrayList<String> getResidents() {
        return residents;
    }

    /**
     * @param residents the residents to set
     */
    public void setResidents(ArrayList<String> residents) {
        this.residents = residents;
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
