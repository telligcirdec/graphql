package net.projet2501.swapigraphql.api.client;

import javax.annotation.PostConstruct;
import javax.ws.rs.PathParam;
import net.projet2501.swapigraphql.api.PeopleSWAPI;
import net.projet2501.swapigraphql.api.model.People;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class PeopleClient extends StarWarsApiClient<PeopleSWAPI,People> {

    @PostConstruct
    public void init() {
        webservice = super.init(PeopleSWAPI.class);
    }

    @Cacheable("peopleById")
    @Override
    public People getById(@PathParam("id") String id) {
        return webservice.getPeopleById(id);
    }

}
