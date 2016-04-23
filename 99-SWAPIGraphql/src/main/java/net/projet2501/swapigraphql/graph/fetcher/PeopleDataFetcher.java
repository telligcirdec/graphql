package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.PeopleClient;
import net.projet2501.swapigraphql.api.client.StarWarsApiClient;
import net.projet2501.swapigraphql.api.model.Film;
import net.projet2501.swapigraphql.api.model.People;
import net.projet2501.swapigraphql.api.model.Planet;
import net.projet2501.swapigraphql.api.model.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class PeopleDataFetcher extends StarWarsApiDataFetcher{

    @Autowired
    private PeopleClient peopleClient;
    
    @Override
    protected String getComponentURI() {
       return APIConstants.PEOPLE_URL;
    }

    @Override
    protected StarWarsApiClient getApiClient() {
        return peopleClient;
    }

    public DataFetcher charactersDataFectcher() {
        return (DataFetchingEnvironment dfe) -> {
            List<People> result = new ArrayList<>();
            if (Film.class.isAssignableFrom(dfe.getSource().getClass())) {
                Film film = (Film) dfe.getSource();
                film.getCharacters().stream().forEach((characterURL) -> {
                    result.add(peopleClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(characterURL, APIConstants.PEOPLE_URL)));
                });
            } else if (Planet.class.isAssignableFrom(dfe.getSource().getClass())) {
                Planet planet = (Planet) dfe.getSource();
                planet.getResidents().stream().forEach((residentURL) -> {
                    result.add(peopleClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(residentURL, APIConstants.PEOPLE_URL)));
                });
            } else if (Species.class.isAssignableFrom(dfe.getSource().getClass())) {
                Species species = (Species) dfe.getSource();
                species.getPeople().stream().forEach((peopleURL) -> {
                    result.add(peopleClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(peopleURL, APIConstants.PEOPLE_URL)));
                });
            }
            return result;
        };
    }

}
