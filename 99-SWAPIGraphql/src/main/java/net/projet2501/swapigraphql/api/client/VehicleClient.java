package net.projet2501.swapigraphql.api.client;

import javax.annotation.PostConstruct;
import net.projet2501.swapigraphql.api.VehicleSWAPI;
import net.projet2501.swapigraphql.api.model.Vehicle;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 *
 * @author telligcirdec
 */
@Component
public class VehicleClient extends StarWarsApiClient<VehicleSWAPI, Vehicle> {

    @PostConstruct
    public void init() {
        webservice = super.init(VehicleSWAPI.class);
    }

    @Cacheable("vehicleById")
    @Override
    public Vehicle getById(String id) {
        return webservice.getVehicleById(id);
    }

}
