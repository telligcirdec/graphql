package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Base64;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.FilmClient;
import net.projet2501.swapigraphql.api.client.PeopleClient;
import net.projet2501.swapigraphql.api.client.PlanetClient;
import net.projet2501.swapigraphql.api.client.SpeciesClient;
import net.projet2501.swapigraphql.api.client.StarshipClient;
import net.projet2501.swapigraphql.api.client.VehicleClient;
import net.projet2501.swapigraphql.api.model.SWAPIObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author telligcirdec
 */
@Component
public class SWAPIObjectDataFetcher {

    @Autowired
    private FilmClient filmClient;
    
    @Autowired
    private PeopleClient peopleClient;
    
    @Autowired
    private PlanetClient planetClient;
    
    @Autowired
    private SpeciesClient speciesClient;
    
    @Autowired
    private StarshipClient starshipClient;
    
    @Autowired
    private VehicleClient vehicleClient;
    
    public DataFetcher swapiObjectDataFetcher(){
        return (DataFetchingEnvironment dfe)->{
            String uid = dfe.getArgument("uid");
            return getSwapiObjectByUid(uid);
        };
    }
    
    
    public SWAPIObject getSwapiObjectByUid(String uid){
        String URL = new String(Base64.getDecoder().decode(uid));
            if(URL.contains(APIConstants.FILMS_URL)){
                return filmClient.getById(StarWarsApiDataFetcher.getIdFromURL(URL, APIConstants.FILMS_URL));
            }else if(URL.contains(APIConstants.PEOPLE_URL)){
                return peopleClient.getById(StarWarsApiDataFetcher.getIdFromURL(URL, APIConstants.PEOPLE_URL));
            }else if(URL.contains(APIConstants.PLANETS_URL)){
                return planetClient.getById(StarWarsApiDataFetcher.getIdFromURL(URL, APIConstants.PLANETS_URL));
            }else if(URL.contains(APIConstants.SPECIES_URL)){
                return speciesClient.getById(StarWarsApiDataFetcher.getIdFromURL(URL, APIConstants.SPECIES_URL));
            }else if(URL.contains(APIConstants.STARSCHIPS_URL)){
                return starshipClient.getById(StarWarsApiDataFetcher.getIdFromURL(URL, APIConstants.STARSCHIPS_URL));
            }else if(URL.contains(APIConstants.VEHICLES_URL)){
                return vehicleClient.getById(StarWarsApiDataFetcher.getIdFromURL(URL, APIConstants.VEHICLES_URL));
            }
            return null;
    }
    
    
}
