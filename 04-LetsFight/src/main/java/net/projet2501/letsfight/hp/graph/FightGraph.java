/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.letsfight.hp.graph;

import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLTypeReference;
import net.projet2501.letsfight.hp.graph.fetcher.FightDataFetcher;
import net.projet2501.swapigraphql.graph.PeopleGraph;

/**
 *
 * @author telligcirdec
 */
public abstract class FightGraph {
    
    
    public static final String FIGHT_TYPE_NAME = "Fight";

    public static GraphQLObjectType getType(
            FightDataFetcher fightDataFetcher) {
        return GraphQLObjectType.newObject()
                .name(FIGHT_TYPE_NAME)
                .description("Let's fight !!!!")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("id")
                        .description("Id from database of this Fight.")
                        .type(Scalars.GraphQLLong)
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("hpPeople")
                        .description("The HpPeople fighter.")
                        .type(new GraphQLTypeReference(HpPeopleGraph.HP_PEOPLE_TYPE_NAME))
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("swPeople")
                        .description("The SwPeople fighter.")
                        .type(new GraphQLTypeReference(PeopleGraph.PEOPLE_TYPE_NAME))
                        .dataFetcher(fightDataFetcher.fetchSwPeople())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("winner")
                        .description("True if star wars people wins, false otherwise.")
                        .type(WinnerGraph.getEnum())
                        .build())
                .build();
    }
}
