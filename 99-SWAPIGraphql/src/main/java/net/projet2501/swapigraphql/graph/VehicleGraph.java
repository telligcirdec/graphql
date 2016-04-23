package net.projet2501.swapigraphql.graph;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLTypeReference;
import net.projet2501.swapigraphql.graph.fetcher.FilmDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PeopleDataFetcher;

/**
 * @author telligcirdec
 */
public abstract class VehicleGraph {

    public static final String VEHICLE_TYPE_NAME = "Vehicle";

    public static GraphQLObjectType getType(
            PeopleDataFetcher peopleDataFetcher, 
            FilmDataFetcher filmDataFetcher) {
        return GraphQLObjectType.newObject()
                .name(VEHICLE_TYPE_NAME)
                .description("A vehicle resource is a single transport craft that has hyperdrive capability.")
                .withInterface(SWAPIObjectGraph.getType())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of the vehicle. URL encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name")
                        .description("The name of this vehicle. The common name, such as \"Death Star\".")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("model")
                        .description("The model or official name of this vehicle. "
                                + "Such as \"T-65 X-wing\" or \"DS-1 Orbital Battle Station\".")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("manufacturer")
                        .description("The manufacturer of this vehicle. Comma seperated if more than one.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("costInCredits")
                        .description("The cost of this vehicle new, in galactic credits.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("length")
                        .description("The length of this vehicle in meters.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("crew")
                        .description("The number of personnel needed to run or pilot this vehicle.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("passengers")
                        .description("The number of non-essential people this vehicle can transport.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("maxAtmospheringSpeed")
                        .description("The maximum speed of this vehicle in atmosphere. \"N/A\" "
                                + "if this starship is incapable of atmosphering flight.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("cargoCapacity")
                        .description("The maximum number of kilograms that this vehicle can transport.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("consumables")
                        .description("The maximum length of time that this vehicle can provide consumables "
                                + "for its entire crew without having to resupply.")
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
                
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("pilots")
                        .description("An array of People that this vehicle has been piloted by.")
                        .type(new GraphQLList(new GraphQLTypeReference(PeopleGraph.PEOPLE_TYPE_NAME)))
                        .dataFetcher(peopleDataFetcher.charactersDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("films")
                        .description("An array of Film that this vehicle has appeared in.")
                        .type(new GraphQLList(new GraphQLTypeReference(FilmlGraph.FILM_TYPE_NAME)))
                        .dataFetcher(filmDataFetcher.filmsDataFectcher())
                        .build())
                .build();
    }

}
