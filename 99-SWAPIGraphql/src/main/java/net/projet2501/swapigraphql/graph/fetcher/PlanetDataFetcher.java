package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.PlanetClient;
import net.projet2501.swapigraphql.api.client.StarWarsApiClient;
import net.projet2501.swapigraphql.api.model.Film;
import net.projet2501.swapigraphql.api.model.People;
import net.projet2501.swapigraphql.api.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class PlanetDataFetcher  extends StarWarsApiDataFetcher{

    @Autowired
    private PlanetClient planetClient;

    @Override
    protected String getComponentURI() {
       return APIConstants.PLANETS_URL;
    }

    @Override
    protected StarWarsApiClient getApiClient() {
        return planetClient;
    }

    public DataFetcher planetsDataFectcher() {
        return (DataFetchingEnvironment dfe) -> {
            if (Film.class.isAssignableFrom(dfe.getSource().getClass())) {
                List<Planet> result = new ArrayList<>();
                Film film = Film.class.cast(dfe.getSource());
                film.getPlanets().stream().forEach((planetURL) -> {
                    result.add(planetClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(planetURL, APIConstants.PLANETS_URL)));
                });
                return result;
            }else if(People.class.isAssignableFrom(dfe.getSource().getClass())){
                People people = People.class.cast(dfe.getSource());
                return planetClient.getById(
                        StarWarsApiDataFetcher.getIdFromURL(people.getHomeworld(), APIConstants.PLANETS_URL));
            }
            return null;
        };
    }
}
