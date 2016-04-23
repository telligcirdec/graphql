package net.projet2501.letsfight.hp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 *
 * @author telligcirdec
 */
@Entity
public class HpPeople implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Transient
    private String uid;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "hpPeople")
    private List<Fight> fights;
     
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName
                + "]";
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the fights
     */
    public List<Fight> getFights() {
        return fights;
    }

    /**
     * @param fights the fights to set
     */
    public void setFights(List<Fight> fights) {
        this.fights = fights;
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

}
