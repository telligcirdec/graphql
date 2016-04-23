package net.projet2501.swapigraphql.api.client;

import javax.annotation.PostConstruct;
import net.projet2501.swapigraphql.api.StarshipSWAPI;
import net.projet2501.swapigraphql.api.model.Starship;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class StarshipClient extends StarWarsApiClient<StarshipSWAPI, Starship> {

    @PostConstruct
    public void init() {
        webservice = super.init(StarshipSWAPI.class);
    }

    @Cacheable("starshipById")
    @Override
    public Starship getById(String id) {
        return webservice.getStarschipsById(id);
    }

}
