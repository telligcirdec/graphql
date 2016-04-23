package net.projet2501.swapigraphql.api.client;

import javax.annotation.PostConstruct;
import net.projet2501.swapigraphql.api.FilmSWAPI;
import net.projet2501.swapigraphql.api.model.Film;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class FilmClient extends StarWarsApiClient<FilmSWAPI,Film> {

    @PostConstruct
    public void init(){
        webservice = super.init(FilmSWAPI.class);
    }
    
    @Cacheable("filmById")
    @Override
    public Film getById(String id) {
        return webservice.getFilmById(id);
    }

}
