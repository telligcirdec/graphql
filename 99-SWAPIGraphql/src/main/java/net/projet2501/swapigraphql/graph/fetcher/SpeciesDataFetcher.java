package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.SpeciesClient;
import net.projet2501.swapigraphql.api.client.StarWarsApiClient;
import net.projet2501.swapigraphql.api.model.Film;
import net.projet2501.swapigraphql.api.model.People;
import net.projet2501.swapigraphql.api.model.Species;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author telligcirdec
 */
@Component
public class SpeciesDataFetcher  extends StarWarsApiDataFetcher{

    @Autowired
    private SpeciesClient speciesClient;

    @Override
    protected String getComponentURI() {
       return APIConstants.SPECIES_URL;
    }

    @Override
    protected StarWarsApiClient getApiClient() {
        return speciesClient;
    }

    public DataFetcher speciesDataFectcher() {
        return (DataFetchingEnvironment dfe) -> {
            List<Species> result = new ArrayList<>();
            if (People.class.isAssignableFrom(dfe.getSource().getClass())) {
                People people = (People) dfe.getSource();
                people.getSpecies().stream().forEach((speciesURL) -> {
                    result.add(speciesClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(speciesURL, APIConstants.SPECIES_URL)));
                });
            } else if (Film.class.isAssignableFrom(dfe.getSource().getClass())) {
                Film film = (Film) dfe.getSource();
                film.getSpecies().stream().forEach((speciesURL) -> {
                    result.add(speciesClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(speciesURL, APIConstants.STARSCHIPS_URL)));
                });
            }
            return result;
        };
    }
}
