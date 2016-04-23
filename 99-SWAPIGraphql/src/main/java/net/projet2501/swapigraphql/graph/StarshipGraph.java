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
public abstract class StarshipGraph {

    public static final String STARSHIP_TYPE_NAME = "Starship";

    public static GraphQLObjectType getStarshipGraph(
                                PeopleDataFetcher peopleDataFetcher, 
                                FilmDataFetcher filmDataFetcher) {
        return GraphQLObjectType.newObject()
                .name(STARSHIP_TYPE_NAME)
                .description("A Starship resource is a single transport craft that has hyperdrive capability.")
                .withInterface(SWAPIObjectGraph.getType())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of the Starship. URL encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name")
                        .description("The name of this starship. The common name, such as \"Death Star\".")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("model")
                        .description("The model or official name of this starship. "
                                + "Such as \"T-65 X-wing\" or \"DS-1 Orbital Battle Station\".")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("starshipClass")
                        .description("The class of this starship, "
                                + "such as \"Starfighter\" or \"Deep Space Mobile Battlestation\"")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("manufacturer")
                        .description("The manufacturer of this starship. Comma seperated if more than one.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("costInCredits")
                        .description("The cost of this starship new, in galactic credits.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("length")
                        .description("The length of this starship in meters.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("crew")
                        .description("The number of personnel needed to run or pilot this starship.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("passengers")
                        .description("The number of non-essential people this starship can transport.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("maxAtmospheringSpeed")
                        .description("The maximum speed of this starship in atmosphere. \"N/A\" "
                                + "if this starship is incapable of atmosphering flight.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("hyperdriveRating")
                        .description("The class of this starships hyperdrive.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("mglt")
                        .description("The Maximum number of Megalights this starship can travel in a standard hour. "
                                + "A \"Megalight\" is a standard unit of distance "
                                + "and has never been defined before within the Star Wars universe. "
                                + "This figure is only really useful for measuring "
                                + "the difference in speed of starships. "
                                + "We can assume it is similar to AU, the distance between our Sun (Sol) and Earth.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("cargoCapacity")
                        .description("The maximum number of kilograms that this starship can transport.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("consumables")
                        .description("The maximum length of time that this starship can provide consumables "
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
                        .description("An array of People that this starship has been piloted by.")
                        .type(new GraphQLList(new GraphQLTypeReference(PeopleGraph.PEOPLE_TYPE_NAME)))
                        .dataFetcher(peopleDataFetcher.charactersDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("films")
                        .description("An array of Film that this starship has appeared in.")
                        .type(new GraphQLList(new GraphQLTypeReference(FilmlGraph.FILM_TYPE_NAME)))
                        .dataFetcher(filmDataFetcher.filmsDataFectcher())
                        .build())
                .build();
    }

}
