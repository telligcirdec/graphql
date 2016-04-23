package net.projet2501.swapigraphql.api.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by Oleur on 22/12/2014. Starship model represents a single transport
 * craft that has hyperdrive capability.
 */
public class Starship extends Vehicle implements Serializable {

    @XmlElement(name = "starship_class")
    private String starshipClass;
    @XmlElement(name = "hyperdrive_rating")
    private String hyperdriveRating;
    @XmlElement(name = "MGLT")
    private String mglt;

    /**
     * @return the starshipClass
     */
    public String getStarshipClass() {
        return starshipClass;
    }

    /**
     * @param starshipClass the starshipClass to set
     */
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    /**
     * @return the hyperdriveRating
     */
    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    /**
     * @param hyperdriveRating the hyperdriveRating to set
     */
    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    /**
     * @return the mglt
     */
    public String getMglt() {
        return mglt;
    }

    /**
     * @param mglt the mglt to set
     */
    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    
    
}
