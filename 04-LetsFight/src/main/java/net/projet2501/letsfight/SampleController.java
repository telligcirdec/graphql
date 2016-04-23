/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.letsfight;

import graphql.ExecutionResult;
import graphql.GraphQL;
import java.util.LinkedHashMap;
import java.util.Map;
import net.projet2501.letsfight.hp.graph.fetcher.FightDataFetcher;
import net.projet2501.letsfight.hp.graph.fetcher.HpPeopleDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.FilmDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PeopleDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PlanetDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.SWAPIObjectDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.SpeciesDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.StarshipDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.VehicleDataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    private static final Logger LOG = LoggerFactory.getLogger(SampleController.class);

    private final GraphQL graphql;

    @Autowired
    public SampleController(
            FilmDataFetcher filmDataFetcher,
            PeopleDataFetcher peopleDataFetcher,
            SpeciesDataFetcher speciesDataFetcher,
            StarshipDataFetcher starshipDataFetcher,
            PlanetDataFetcher planetDataFetcher,
            VehicleDataFetcher vehicleDataFetcher,
            SWAPIObjectDataFetcher objectDataFetcher,
            HpPeopleDataFetcher hpPeopleDataFetcher,
            FightDataFetcher fightDataFetcher) {

        this.graphql = new GraphQL(
                FightSchema.getSchema(
                        filmDataFetcher,
                        peopleDataFetcher,
                        speciesDataFetcher,
                        starshipDataFetcher,
                        planetDataFetcher,
                        vehicleDataFetcher,
                        objectDataFetcher,
                        hpPeopleDataFetcher,
                        fightDataFetcher));
    }

    @RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object executeOperation(@RequestBody Map body) {

        String query = (String) body.get("query");
        query = query.replaceAll("'", "\"");
        // Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        ExecutionResult executionResult = graphql.execute(query);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
            LOG.error("Errors: {}", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }

}
