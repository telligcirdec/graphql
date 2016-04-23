package net.projet2501.swapigraphql.graph;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLTypeReference;
import net.projet2501.swapigraphql.graph.fetcher.PeopleDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PlanetDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.StarshipDataFetcher;

/**
 * @author telligcirdec
 */
public abstract class FilmlGraph {

    public static final String FILM_TYPE_NAME = "Film";

    public static GraphQLObjectType getType(
            PeopleDataFetcher peopleDataFetcher,
            PlanetDataFetcher planetDataFetcher,
            StarshipDataFetcher starshipDataFetcher) {
        return getSimpleBuilder()
                
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("characters")
                        .description("An array of people that are in this film.")
                        .type(new GraphQLList(new GraphQLTypeReference(PeopleGraph.PEOPLE_TYPE_NAME)))
                        .dataFetcher(peopleDataFetcher.charactersDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("planets")
                        .description("An array of planets that are in this film.")
                        .type(new GraphQLList(new GraphQLTypeReference(PlanetGraph.PLANET_TYPE_NAME)))
                        .dataFetcher(planetDataFetcher.planetsDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("starships")
                        .description("An array of starships that are in this film.")
                        .type(new GraphQLList(new GraphQLTypeReference(StarshipGraph.STARSHIP_TYPE_NAME)))
                        .dataFetcher(starshipDataFetcher.starshipsDataFectcher())
                        .build())
                
                
                
                .build();
    }
    
    public static GraphQLObjectType getSimpleTypeWithPeopleFetching(
            PeopleDataFetcher peopleDataFetcher) {
        return getSimpleBuilder()
                
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("characters")
                        .description("An array of people that are in this film.")
                        .type(new GraphQLList(new GraphQLTypeReference(PeopleGraph.PEOPLE_TYPE_NAME)))
                        .dataFetcher(peopleDataFetcher.charactersDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("planets")
                        .description("An array of planets URL resources that are in this film.")
                        .type(new GraphQLList(Scalars.GraphQLString))
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("starships")
                        .description("An array of starships URL reesources that are in this film.")
                        .type(new GraphQLList(Scalars.GraphQLString))
                        .build())
                .build();
    }

    public static GraphQLObjectType.Builder getSimpleBuilder() {
        return GraphQLObjectType.newObject()
                .name(FILM_TYPE_NAME)
                .description("A Film resource is an single film.")
                .withInterface(SWAPIObjectGraph.getType())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of the film. URL encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name")
                        .description("The title of this film")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("episodeId")
                        .description("The episode number of this film.")
                        .type(Scalars.GraphQLInt)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("openingCrawl")
                        .description("The opening paragraphs at the beginning of this film.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("director")
                        .description("The name of the director of this film.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("producer")
                        .description("The name(s) of the producer(s) of this film. Comma seperated.")
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
                        .build());
    }
    
    
}
