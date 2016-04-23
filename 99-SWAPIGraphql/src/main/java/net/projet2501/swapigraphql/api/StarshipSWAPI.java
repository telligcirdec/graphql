package net.projet2501.swapigraphql.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import net.projet2501.swapigraphql.api.model.Starship;
import org.apache.cxf.feature.Features;
import org.apache.cxf.feature.LoggingFeature;

/**
 *
 * @author telligcirdec
 */
@Features(classes = {LoggingFeature.class})
@Path("/" + APIConstants.STARSCHIPS_URL)
public interface StarshipSWAPI {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("{id}/")
    public Starship getStarschipsById(@PathParam("id") String id);

}
