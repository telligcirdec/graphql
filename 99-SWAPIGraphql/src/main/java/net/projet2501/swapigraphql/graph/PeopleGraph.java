package net.projet2501.swapigraphql.graph;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLTypeReference;
import net.projet2501.swapigraphql.graph.fetcher.FilmDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PlanetDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.StarshipDataFetcher;

/**
 * @author telligcirdec
 */
public abstract class PeopleGraph {

    public static final String PEOPLE_TYPE_NAME = "People";

    public static GraphQLObjectType getType(
            FilmDataFetcher filmDataFetcher,
            StarshipDataFetcher starshipDataFetcher,
            PlanetDataFetcher planetDataFetcher) {
        return getSimpleBuilder()
                .withInterface(SWAPIObjectGraph.getType())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("homeworld")
                        .description("The planet that "
                                + "this person was born on or inhabits.")
                        .type(new GraphQLTypeReference(PlanetGraph.PLANET_TYPE_NAME))
                        .dataFetcher(planetDataFetcher.planetsDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("films")
                        .description("An array of films that this person has been in.")
                        .type(new GraphQLList(new GraphQLTypeReference(FilmlGraph.FILM_TYPE_NAME)))
                        .dataFetcher(filmDataFetcher.filmsDataFectcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("starships")
                        .description("An array of starships that this person has piloted.")
                        .type(new GraphQLList(new GraphQLTypeReference(StarshipGraph.STARSHIP_TYPE_NAME)))
                        .dataFetcher(starshipDataFetcher.starshipsDataFectcher())
                        .build())
                .build();
    }
    
    public static GraphQLObjectType getTypeWithFilmMapping(
            FilmDataFetcher filmDataFetcher) {
        return getSimpleBuilder()
                .withInterface(SWAPIObjectGraph.getType())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("starships")
                        .description("An array of starships URL resources that this person has piloted.")
                        .type(new GraphQLList(Scalars.GraphQLString))
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("homeworld")
                        .description("The URL of a planet resource, a planet that "
                                + "this person was born on or inhabits.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("films")
                        .description("An array of films that this person has been in.")
                        .type(new GraphQLList(new GraphQLTypeReference(FilmlGraph.FILM_TYPE_NAME)))
                        .dataFetcher(filmDataFetcher.filmsDataFectcher())
                        .build())
                .build();
    }
    
    public static GraphQLObjectType getSimpleType(){
        return getSimpleBuilder()
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("films")
                        .description("An array of films URL resources that this person has been in.")
                        .type(new GraphQLList(Scalars.GraphQLString))
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("starships")
                        .description("An array of starships URL resources that this person has piloted.")
                        .type(new GraphQLList(Scalars.GraphQLString))
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("homeworld")
                        .description("The URL of a planet resource, a planet that "
                                + "this person was born on or inhabits.")
                        .type(Scalars.GraphQLString)
                        .build())
                .build();
    }
    
    private static GraphQLObjectType.Builder getSimpleBuilder() {
        return GraphQLObjectType.newObject()
                .name(PEOPLE_TYPE_NAME)
                .description("A People resource is an individual person or character within the Star Wars universe.")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of the People. URL encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("name")
                        .description("The name of this person.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("birthYear")
                        .description("The birth year of the person, using the in-universe standard of BBY or ABY - "
                                + "Before the Battle of Yavin or After the Battle of Yavin. "
                                + "The Battle of Yavin is a battle that occurs at the end of Star Wars episode IV: A New Hope.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("gender")
                        .description("The gender of this person. Either \"Male\", \"Female\" or \"unknown\", \"n/a\" "
                                + "if the person does not have a gender.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("hairColor")
                        .description("The hair color of this person. Will be \"unknown\" "
                                + "if not known or \"n/a\" if the person does not have hair.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("eyeColor")
                        .description("The eye color of this person. Will be \"unknown\" "
                                + "if not known or \"n/a\" if the person does not have an eye.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("height")
                        .description("The height of the person in centimeters.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("mass")
                        .description("The mass of the person in kilograms.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("skinColor")
                        .description("The skin color of this person.")
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
