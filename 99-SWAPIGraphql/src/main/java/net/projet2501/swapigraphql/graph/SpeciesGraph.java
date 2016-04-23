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
public abstract class SpeciesGraph {

    public static final String SPECIES_TYPE_NAME = "Species";

    public static GraphQLObjectType getType(
            PeopleDataFetcher peopleDataFetcher, 
            FilmDataFetcher filmDataFetcher) {
        return GraphQLObjectType.newObject()
                .name(SPECIES_TYPE_NAME)
                .description("A Species resource is a type of person or character within the Star Wars Universe.")
                .withInterface(SWAPIObjectGraph.getType())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of the film. URL encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name")
                        .description("The name of this species.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("classification")
                        .description("The classification of this species, such as \"mammal\" or \"reptile\".")
                        .type(Scalars.GraphQLInt)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("designation")
                        .description("The designation of this species, such as \"sentient\".")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("averageHeight")
                        .description("The average height of this species in centimeters.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("averageLifespan")
                        .description("The average lifespan of this species in years.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("eyeColors")
                        .description("A comma-seperated string of common eye colors for this species, \"none\" "
                                + "if this species does not typically have eyes.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("hairColors")
                        .description("A comma-seperated string of common hair colors for this species, \"none\" "
                                + "if this species does not typically have hair.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("skinColors")
                        .description("A comma-seperated string of common skin colors for this species, \"none\" "
                                + "if this species does not typically have skin.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("language")
                        .description("The language commonly spoken by this species.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("homeworld")
                        .description("The URL of a planet resource, a planet that this species originates from.")
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
                        .name("url")
                        .description("the hypermedia URL of this resource.")
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
                        .name("people")
                        .description("An array of People that are a part of this species.")
                        .type(new GraphQLList(new GraphQLTypeReference(PeopleGraph.PEOPLE_TYPE_NAME)))
                        .dataFetcher(peopleDataFetcher.charactersDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("films")
                        .description("An array of Film that this species has appeared in.")
                        .type(new GraphQLList(new GraphQLTypeReference(FilmlGraph.FILM_TYPE_NAME)))
                        .dataFetcher(filmDataFetcher.filmsDataFectcher())
                        .build())
                .build();
    }

}
