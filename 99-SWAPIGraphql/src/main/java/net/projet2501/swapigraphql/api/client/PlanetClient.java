package net.projet2501.swapigraphql.api.client;

import javax.annotation.PostConstruct;
import net.projet2501.swapigraphql.api.PlanetSWAPI;
import net.projet2501.swapigraphql.api.model.Planet;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class PlanetClient extends StarWarsApiClient<PlanetSWAPI, Planet> {

    @PostConstruct
    public void init() {
        webservice = super.init(PlanetSWAPI.class);
    }

    @Cacheable("planetById")
    @Override
    public Planet getById(String id) {
        return webservice.getPlanetById(id);
    }

}
