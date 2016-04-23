package net.projet2501.swapigraphql.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.projet2501.swapigraphql.api.model.Planet;
import org.apache.cxf.feature.Features;
import org.apache.cxf.feature.LoggingFeature;

/**
 *
 * @author telligcirdec
 */
@Features(classes = {LoggingFeature.class})
@Path("/" + APIConstants.PLANETS_URL)
public interface PlanetSWAPI {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}/")
    public Planet getPlanetById(@PathParam("id") String id);

}
