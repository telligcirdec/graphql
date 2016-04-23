package net.projet2501.swapigraphql.api.client;

import javax.annotation.PostConstruct;
import net.projet2501.swapigraphql.api.SpeciesSWAPI;
import net.projet2501.swapigraphql.api.model.Species;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class SpeciesClient extends StarWarsApiClient<SpeciesSWAPI, Species> {

    @PostConstruct
    public void init() {
        webservice = super.init(SpeciesSWAPI.class);
    }

    @Cacheable("speciesById")
    @Override
    public Species getById(String id) {
        return webservice.getSpeciesById(id);
    }

}
