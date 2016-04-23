package net.projet2501.swapigraphql.graph;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLInterfaceType;
import graphql.schema.GraphQLObjectType;
import java.util.Arrays;
import net.projet2501.swapigraphql.api.model.Film;
import net.projet2501.swapigraphql.api.model.People;
import net.projet2501.swapigraphql.api.model.Planet;
import net.projet2501.swapigraphql.api.model.Species;
import net.projet2501.swapigraphql.api.model.Starship;
import net.projet2501.swapigraphql.api.model.Vehicle;

/**
 * @author telligcirdec
 */
public abstract class SWAPIObjectGraph {

    public static final String SWAPI_OBJECT_TYPE_NAME = "SWAPIObject";

    public static GraphQLInterfaceType getType(GraphQLObjectType... types) {
        return GraphQLInterfaceType.newInterface()
                .name(SWAPI_OBJECT_TYPE_NAME)
                .description("A abstract SWAPI object.")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of the film. URL encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name")
                        .description("The name of this resource")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("url")
                        .description("the hypermedia URL of this resource.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("created")
                        .description("the ISO 8601 date format of the time that this resource was created.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("edited")
                        .description("the ISO 8601 date format of the time that this resource was edited.")
                        .type(Scalars.GraphQLString)
                        .build())
                .typeResolver((Object object) -> {
                    System.out.println("SWAPIObjectGraph typeResolver : " + object);
                    if (Film.class.isAssignableFrom(object.getClass())) {
                        return Arrays.stream(types).filter((GraphQLObjectType o) -> 
                             FilmlGraph.FILM_TYPE_NAME.equals(o.getName())).findFirst().orElse(null);
                    } else if (People.class.isAssignableFrom(object.getClass())) {
                        return Arrays.stream(types).filter((GraphQLObjectType o) -> 
                                PeopleGraph.PEOPLE_TYPE_NAME.equals(o.getName())).findFirst().orElse(null);
                    } else if (Planet.class.isAssignableFrom(object.getClass())) {
                        return Arrays.stream(types).filter((GraphQLObjectType o) -> 
                                PlanetGraph.PLANET_TYPE_NAME.equals(o.getName())).findFirst().orElse(null);
                    } else if (Species.class.isAssignableFrom(object.getClass())) {
                        return Arrays.stream(types).filter((GraphQLObjectType o) -> 
                                SpeciesGraph.SPECIES_TYPE_NAME.equals(o.getName())).findFirst().orElse(null);
                    } else if (Starship.class.isAssignableFrom(object.getClass())) {
                        return Arrays.stream(types).filter((GraphQLObjectType o) -> 
                                StarshipGraph.STARSHIP_TYPE_NAME.equals(o.getName())).findFirst().orElse(null);
                    } else if (Vehicle.class.isAssignableFrom(object.getClass())) {
                        return Arrays.stream(types).filter((GraphQLObjectType o) -> 
                                VehicleGraph.VEHICLE_TYPE_NAME.equals(o.getName())).findFirst().orElse(null);
                    }
                    return null;
                })
                .build();
    }

}
