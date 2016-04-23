package net.projet2501.swapigraphql.api.model;


import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleur on 22/12/2014.
 * Vehicle model represents a single transport craft that does not have hyperdrive capability.
 */
@XmlRootElement
public class Vehicle extends SWAPIObject implements Serializable {
    
    private String model;
    private String vehicleClass;
    private String manufacturer;
    @XmlElement(name = "cost_in_credits")
    private String costInCredits;
    private String length;
    private String crew;
    private String passengers;
    @XmlElement(name = "max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    @XmlElement(name = "cargo_capacity")
    private String cargoCapacity;
    private String consumables;

    private ArrayList<String> pilots;
    private ArrayList<String> films;

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the vehicleClass
     */
    public String getVehicleClass() {
        return vehicleClass;
    }

    /**
     * @param vehicleClass the vehicleClass to set
     */
    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the costInCredits
     */
    public String getCostInCredits() {
        return costInCredits;
    }

    /**
     * @param costInCredits the costInCredits to set
     */
    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    /**
     * @return the length
     */
    public String getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * @return the crew
     */
    public String getCrew() {
        return crew;
    }

    /**
     * @param crew the crew to set
     */
    public void setCrew(String crew) {
        this.crew = crew;
    }

    /**
     * @return the passengers
     */
    public String getPassengers() {
        return passengers;
    }

    /**
     * @param passengers the passengers to set
     */
    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    /**
     * @return the maxAtmospheringSpeed
     */
    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    /**
     * @param maxAtmospheringSpeed the maxAtmospheringSpeed to set
     */
    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    /**
     * @return the cargoCapacity
     */
    public String getCargoCapacity() {
        return cargoCapacity;
    }

    /**
     * @param cargoCapacity the cargoCapacity to set
     */
    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * @return the consumables
     */
    public String getConsumables() {
        return consumables;
    }

    /**
     * @param consumables the consumables to set
     */
    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    /**
     * @return the pilots
     */
    public ArrayList<String> getPilots() {
        return pilots;
    }

    /**
     * @param pilots the pilots to set
     */
    public void setPilots(ArrayList<String> pilots) {
        this.pilots = pilots;
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
