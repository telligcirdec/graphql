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
public abstract class PlanetGraph {

    public static final String PLANET_TYPE_NAME = "Planet";

    public static GraphQLObjectType getType(
            PeopleDataFetcher peopleDataFetcher,
            FilmDataFetcher filmDataFetcher) {
        return GraphQLObjectType.newObject()
                .name(PLANET_TYPE_NAME)
                .description("A Planet resource is a large mass, planet or planetoid in the Star Wars Universe, "
                        + "at the time of 0 ABY.")
                .withInterface(SWAPIObjectGraph.getType())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of the Planet. URL encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name")
                        .description("The name of this planet.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("diameter")
                        .description("The diameter of this planet in kilometers.")
                        .type(Scalars.GraphQLInt)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("rotationPeriod")
                        .description("The number of standard hours it takes for this planet "
                                + "to complete a single rotation on its axis.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("orbitalPeriod")
                        .description("The number of standard days it takes for this planet to complete "
                                + "a single orbit of its local star.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("gravity")
                        .description("A number denoting the gravity of this planet, "
                                + "where \"1\" is normal or 1 standard G. \"2\" "
                                + "is twice or 2 standard Gs. \"0.5\" is half or 0.5 standard Gs.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("population")
                        .description("The average population of sentient beings inhabiting this planet.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("climate")
                        .description("The climate of this planet. Comma-seperated if diverse.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("terrain")
                        .description("The terrain of this planet. Comma-seperated if diverse.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("surfaceWater")
                        .description("The percentage of the planet surface "
                                + "that is naturally occuring water or bodies of water.")
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
                        .name("residents")
                        .description("An array of People that live on this planet.")
                        .type(new GraphQLList(new GraphQLTypeReference(PeopleGraph.PEOPLE_TYPE_NAME)))
                        .dataFetcher(peopleDataFetcher.charactersDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("films")
                        .description("An array of Film that this planet has appeared in.")
                        .type(new GraphQLList(new GraphQLTypeReference(FilmlGraph.FILM_TYPE_NAME)))
                        .dataFetcher(filmDataFetcher.filmsDataFectcher())
                        .build())
                .build();
    }

}
