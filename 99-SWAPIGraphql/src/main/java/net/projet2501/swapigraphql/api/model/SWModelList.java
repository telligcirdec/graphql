package net.projet2501.swapigraphql.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleur on 22/12/2014.
 * Film list model
 * @param <T>
 */
@XmlRootElement
public class SWModelList<T> implements Serializable {
    
    private int count;
    private String next;
    private String previous;
    private ArrayList<T> results;

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(String next) {
        this.next = next;
    }

    /**
     * @return the previous
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * @param previous the previous to set
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * @return the results
     */
    public ArrayList<T> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(ArrayList<T> results) {
        this.results = results;
    }

    
    
}
