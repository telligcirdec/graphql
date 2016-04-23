/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.swapigraphql.api.client;

import java.util.Arrays;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.model.SWAPIObject;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

/**
 *
 * @author telligcirdec
 * @param <T>
 * @param <E>
 */
public abstract class StarWarsApiClient<T,E extends SWAPIObject > {

    protected T webservice;

    protected T init(Class<T> clazz) {
        return webservice = JAXRSClientFactory.create(APIConstants.BASE_URL, clazz, Arrays.asList(new JacksonJaxbJsonProvider()));
    }
    
    public abstract E getById(String id);

}
