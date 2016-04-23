package net.projet2501.swapigraphql;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import net.projet2501.swapigraphql.graph.FilmlGraph;
import net.projet2501.swapigraphql.graph.PeopleGraph;
import net.projet2501.swapigraphql.graph.PlanetGraph;
import net.projet2501.swapigraphql.graph.SWAPIObjectGraph;
import net.projet2501.swapigraphql.graph.SpeciesGraph;
import net.projet2501.swapigraphql.graph.StarshipGraph;
import net.projet2501.swapigraphql.graph.VehicleGraph;
import net.projet2501.swapigraphql.graph.fetcher.FilmDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PeopleDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PlanetDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.SWAPIObjectDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.SpeciesDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.StarshipDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.VehicleDataFetcher;

/**
 * @author telligcirdec
 */
public abstract class StarWarsSchema {

    public static GraphQLSchema getStarWarsSchema(
            FilmDataFetcher filmDataFetcher,
            PeopleDataFetcher peopleDataFetcher,
            SpeciesDataFetcher speciesDataFetcher,
            StarshipDataFetcher starshipDataFetcher,
            PlanetDataFetcher planetDataFetcher,
            VehicleDataFetcher vehicleDataFetcher,
            SWAPIObjectDataFetcher objectDataFetcher) {

        GraphQLObjectType queryType = getBuilder(
                filmDataFetcher,
                peopleDataFetcher,
                speciesDataFetcher,
                starshipDataFetcher,
                planetDataFetcher,
                vehicleDataFetcher,
                objectDataFetcher)
                .build();

        return GraphQLSchema.newSchema()
                .query(queryType)
                .build();
    }

    public static GraphQLObjectType.Builder getBuilder(
            FilmDataFetcher filmDataFetcher,
            PeopleDataFetcher peopleDataFetcher,
            SpeciesDataFetcher speciesDataFetcher,
            StarshipDataFetcher starshipDataFetcher,
            PlanetDataFetcher planetDataFetcher,
            VehicleDataFetcher vehicleDataFetcher,
            SWAPIObjectDataFetcher objectDataFetcher) {

        GraphQLObjectType filmType = FilmlGraph.getType(peopleDataFetcher,
                                                        planetDataFetcher,
                                                        starshipDataFetcher);

        GraphQLObjectType peopleType = PeopleGraph.getType(filmDataFetcher,
                                                            starshipDataFetcher,
                                                            planetDataFetcher);

        GraphQLObjectType starshipType = StarshipGraph.getStarshipGraph(peopleDataFetcher,
                                                                        filmDataFetcher);

        GraphQLObjectType vehicleType = VehicleGraph.getType(peopleDataFetcher, filmDataFetcher);

        GraphQLObjectType planetType = PlanetGraph.getType(peopleDataFetcher, filmDataFetcher);

        return GraphQLObjectType.newObject()
                .name("QueryType")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("people")
                        .type(peopleType)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("SWAPI id of the hero. If omitted, "
                                        + "returns the hero of the whole saga. "
                                        + "If provided, returns the hero of that particular episode.")
                                .type(Scalars.GraphQLString)
                                .defaultValue("1")
                                .build())
                        .dataFetcher(peopleDataFetcher.simpleDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("film")
                        .type(filmType)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("SWAPI id of the film.")
                                .type(new GraphQLNonNull(Scalars.GraphQLID))
                                .build())
                        .dataFetcher(filmDataFetcher.simpleDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("planet")
                        .type(planetType)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("SWAPI id of the planet.")
                                .type(new GraphQLNonNull(Scalars.GraphQLString))
                                .build())
                        .dataFetcher(planetDataFetcher.simpleDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("specie")
                        .type(SpeciesGraph.getType(peopleDataFetcher, filmDataFetcher))
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("SWAPI id of the specie.")
                                .type(new GraphQLNonNull(Scalars.GraphQLString))
                                .build())
                        .dataFetcher(speciesDataFetcher.simpleDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("starship")
                        .type(starshipType)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("SWAPI id of the starship.")
                                .type(new GraphQLNonNull(Scalars.GraphQLString))
                                .build())
                        .dataFetcher(starshipDataFetcher.simpleDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("vehicle")
                        .type(vehicleType)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("SWAPI id of the vehicle.")
                                .type(new GraphQLNonNull(Scalars.GraphQLString))
                                .build())
                        .dataFetcher(vehicleDataFetcher.simpleDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("swapiObject")
                        .type(SWAPIObjectGraph.getType(filmType, peopleType, planetType, starshipType, vehicleType))
                        .argument(GraphQLArgument.newArgument()
                                .name("uid")
                                .description("Unique ID of the SWAPIObject")
                                .type(new GraphQLNonNull(Scalars.GraphQLID))
                                .build())
                        .dataFetcher(objectDataFetcher.swapiObjectDataFetcher())
                        .build());
    }
}
