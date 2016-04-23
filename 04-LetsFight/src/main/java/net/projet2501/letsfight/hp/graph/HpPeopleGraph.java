package net.projet2501.letsfight.hp.graph;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import net.projet2501.letsfight.hp.graph.fetcher.HpPeopleDataFetcher;

/**
 *
 * @author telligcirdec
 */
public abstract class HpPeopleGraph {
   
    public static final String HP_PEOPLE_TYPE_NAME = "HpPeople";

    public static GraphQLObjectType getType(
            HpPeopleDataFetcher hpPeopleDataFetcher) {
        return GraphQLObjectType.newObject()
                .name(HP_PEOPLE_TYPE_NAME)
                .description("A HpPeople resource is an individual person or character within the Harry Potter universe.")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("uid")
                        .description("Unique id of this HpPeople. (Id + FirstName + LastName) seperatde by pipe encoded in BASE64.")
                        .type(Scalars.GraphQLID)
                        .dataFetcher(hpPeopleDataFetcher.generateUid())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("id")
                        .description("Id from database of this HpPeople.")
                        .type(Scalars.GraphQLLong)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("firstName")
                        .description("The first name of this HpPeople.")
                        .type(Scalars.GraphQLString)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("lastName")
                        .description("The last name of this HpPeople.")
                        .type(Scalars.GraphQLString)
                        .build())
                .build();
    }
    
}
