package net.projet2501.letsfight.hp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author telligcirdec
 */
@Entity
public class Fight implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="HP_PEOPLE_ID")
    private HpPeople hpPeople;
    private String swapiUid;
    private boolean winner;

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
     * @return the swapiUid
     */
    public String getSwapiUid() {
        return swapiUid;
    }

    /**
     * @param swapiUid the swapiUid to set
     */
    public void setSwapiUid(String swapiUid) {
        this.swapiUid = swapiUid;
    }

    /**
     * @return the winner
     */
    public boolean getWinner() {
        return isWinner();
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    /**
     * @return the hpPeople
     */
    public HpPeople getHpPeople() {
        return hpPeople;
    }

    /**
     * @param hpPeople the hpPeople to set
     */
    public void setHpPeople(HpPeople hpPeople) {
        this.hpPeople = hpPeople;
    }

    /**
     * @return the winner
     */
    public boolean isWinner() {
        return winner;
    }

}
