package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.ArrayList;
import java.util.List;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.StarWarsApiClient;
import net.projet2501.swapigraphql.api.client.VehicleClient;
import net.projet2501.swapigraphql.api.model.Film;
import net.projet2501.swapigraphql.api.model.People;
import net.projet2501.swapigraphql.api.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author telligcirdec
 */
@Component
public class VehicleDataFetcher  extends StarWarsApiDataFetcher{

    @Autowired
    private VehicleClient vehicleClient;

    @Override
    protected String getComponentURI() {
       return APIConstants.VEHICLES_URL;
    }
    
    @Override
    protected StarWarsApiClient getApiClient() {
        return vehicleClient;
    }

    public DataFetcher vehiclesDataFectcher() {
        return (DataFetchingEnvironment dfe) -> {
            List<Vehicle> result = new ArrayList<>();
            if (People.class.isAssignableFrom(dfe.getSource().getClass())) {
                People people = (People) dfe.getSource();
                people.getStarships().stream().forEach((vehicleURL) -> {
                    result.add(vehicleClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(vehicleURL, APIConstants.VEHICLES_URL)));
                });
            } else if (Film.class.isAssignableFrom(dfe.getSource().getClass())) {
                Film film = (Film) dfe.getSource();
                film.getStarships().stream().forEach((vehicleURL) -> {
                    result.add(vehicleClient.getById(
                            StarWarsApiDataFetcher.getIdFromURL(vehicleURL, APIConstants.VEHICLES_URL)));
                });
            }
            return result;
        };
    }
}
