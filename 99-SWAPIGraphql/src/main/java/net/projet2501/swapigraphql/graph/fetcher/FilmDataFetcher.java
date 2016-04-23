package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.FilmClient;
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
public class FilmDataFetcher extends StarWarsApiDataFetcher{

    @Autowired
    private FilmClient filmClient;

    @Override
    protected String getComponentURI() {
       return APIConstants.FILMS_URL;
    }

    @Override
    protected StarWarsApiClient getApiClient() {
        return filmClient;
    }

    public DataFetcher filmsDataFectcher() {
        return (DataFetchingEnvironment dfe) -> {
            List<Film> result = new ArrayList<>();
            if (People.class.isAssignableFrom(dfe.getSource().getClass())) {
                People people = (People) dfe.getSource();
                people.getFilms().stream().forEach((filmURL) -> {
                    result.add(filmClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(filmURL, APIConstants.FILMS_URL)));
                });
            } else if (Planet.class.isAssignableFrom(dfe.getSource().getClass())) {
                Planet planet = (Planet) dfe.getSource();
                planet.getFilms().stream().forEach((filmURL) -> {
                    result.add(filmClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(filmURL, APIConstants.FILMS_URL)));
                });
            } else if (Species.class.isAssignableFrom(dfe.getSource().getClass())) {
                Species species = (Species) dfe.getSource();
                species.getFilms().stream().forEach((filmURL) -> {
                    result.add(filmClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(filmURL, APIConstants.FILMS_URL)));
                });
            }
            return result;
        };
    }

    

}
