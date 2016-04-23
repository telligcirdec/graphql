package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.StarWarsApiClient;
import net.projet2501.swapigraphql.api.client.StarshipClient;
import net.projet2501.swapigraphql.api.model.Film;
import net.projet2501.swapigraphql.api.model.People;
import net.projet2501.swapigraphql.api.model.Starship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class StarshipDataFetcher  extends StarWarsApiDataFetcher{

    @Autowired
    private StarshipClient starshipClient;

    @Override
    protected String getComponentURI() {
       return APIConstants.STARSCHIPS_URL;
    }

    @Override
    protected StarWarsApiClient getApiClient() {
        return starshipClient;
    }

    public DataFetcher starshipsDataFectcher() {
        return (DataFetchingEnvironment dfe) -> {
            List<Starship> result = new ArrayList<>();
            if (People.class.isAssignableFrom(dfe.getSource().getClass())) {
                People people = (People) dfe.getSource();
                people.getStarships().stream().forEach((starshipURL) -> {
                    result.add(starshipClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(starshipURL, APIConstants.STARSCHIPS_URL)));
                });
            } else if (Film.class.isAssignableFrom(dfe.getSource().getClass())) {
                Film film = (Film) dfe.getSource();
                film.getStarships().stream().forEach((starshipURL) -> {
                    result.add(starshipClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(starshipURL, APIConstants.STARSCHIPS_URL)));
                });
            }
            return result;
        };
    }

}
