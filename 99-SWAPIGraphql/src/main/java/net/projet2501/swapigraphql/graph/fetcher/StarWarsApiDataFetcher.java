package net.projet2501.swapigraphql.graph.fetcher;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import java.util.Base64;
import net.projet2501.swapigraphql.api.APIConstants;
import net.projet2501.swapigraphql.api.client.StarWarsApiClient;
import net.projet2501.swapigraphql.api.model.SWAPIObject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author telligcirdec
 */
public abstract class StarWarsApiDataFetcher {
    
    public DataFetcher uniqueIdDataFetcher() {
        return (DataFetchingEnvironment dfe) -> StarWarsApiDataFetcher.getUniqueID(getComponentURI(), dfe.getArgument("id"));
    }
    
    public DataFetcher simpleDataFectcher() {
        return (DataFetchingEnvironment dfe) -> {
            SWAPIObject swapio = getApiClient().getById(dfe.getArgument("id"));
            swapio.setUid(Base64.getEncoder().encodeToString(swapio.getUrl().getBytes()));
            return swapio;
        };
    }
    
    public static String getIdFromURL(String filmURL, String urlComponent) {
        return StringUtils.replace(StringUtils.replace(filmURL, APIConstants.BASE_URL + urlComponent + "/", ""), "/", "");
    }
    
    private static String getUniqueID(String urlComponent, String id) {
        return Base64.getEncoder().encodeToString((APIConstants.BASE_URL + urlComponent + "/" + id + "/").getBytes());
    }
    
    protected abstract String getComponentURI();
    
    protected abstract StarWarsApiClient getApiClient();
    
}
