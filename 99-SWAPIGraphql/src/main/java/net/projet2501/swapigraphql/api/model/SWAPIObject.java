/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.swapigraphql.api.model;

import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author telligcirdec
 */
public class SWAPIObject {
    
    @XmlTransient
    private String uid;
    
    private String name;
    private String created;
    private String edited;
    private String url;
    
    /**
     * @return the created
     */
    public String getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * @return the edited
     */
    public String getEdited() {
        return edited;
    }

    /**
     * @param edited the edited to set
     */
    public void setEdited(String edited) {
        this.edited = edited;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
