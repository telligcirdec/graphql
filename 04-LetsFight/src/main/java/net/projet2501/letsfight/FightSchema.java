package net.projet2501.letsfight;

import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import net.projet2501.letsfight.hp.graph.FightGraph;
import net.projet2501.letsfight.hp.graph.HpPeopleGraph;
import net.projet2501.letsfight.hp.graph.WinnerGraph;
import net.projet2501.letsfight.hp.graph.fetcher.FightDataFetcher;
import net.projet2501.letsfight.hp.graph.fetcher.HpPeopleDataFetcher;
import net.projet2501.swapigraphql.StarWarsSchema;
import net.projet2501.swapigraphql.graph.fetcher.FilmDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PeopleDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.PlanetDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.SWAPIObjectDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.SpeciesDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.StarshipDataFetcher;
import net.projet2501.swapigraphql.graph.fetcher.VehicleDataFetcher;

/**
 *
 * @author telligcirdec
 */
public abstract class FightSchema {

    public static GraphQLSchema getSchema(
            FilmDataFetcher filmDataFetcher,
            PeopleDataFetcher peopleDataFetcher,
            SpeciesDataFetcher speciesDataFetcher,
            StarshipDataFetcher starshipDataFetcher,
            PlanetDataFetcher planetDataFetcher,
            VehicleDataFetcher vehicleDataFetcher,
            SWAPIObjectDataFetcher objectDataFetcher,
            HpPeopleDataFetcher hpPeopleDataFetcher,
            FightDataFetcher fightDataFetcher) {

        GraphQLObjectType hpPeopleType = HpPeopleGraph.getType(hpPeopleDataFetcher);
        
        GraphQLObjectType fightType = FightGraph.getType(fightDataFetcher);

        GraphQLObjectType queryType = StarWarsSchema.getBuilder(
                filmDataFetcher,
                peopleDataFetcher,
                speciesDataFetcher,
                starshipDataFetcher,
                planetDataFetcher,
                vehicleDataFetcher,
                objectDataFetcher).field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("hpPeople")
                        .type(hpPeopleType)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("Database hpPeople id")
                                .type(new GraphQLNonNull(Scalars.GraphQLLong))
                                .build())
                        .dataFetcher(hpPeopleDataFetcher.idDataFetcher())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("allHpPeople")
                        .type(new GraphQLList(hpPeopleType))
                        .dataFetcher(hpPeopleDataFetcher.allHpPeople())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("fight")
                        .type(fightType)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("Database fight id")
                                .type(new GraphQLNonNull(Scalars.GraphQLLong))
                                .build())
                        .dataFetcher(fightDataFetcher.idDataFetcher())
                        .build())
                .build();

        
        GraphQLObjectType mutationType = GraphQLObjectType.newObject()
                .name("MutationType")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("createHpPeople")
                        .type(hpPeopleType)
                        .argument(GraphQLArgument.newArgument()
                                .name("firstName")
                                .description("FisrtName of the HpPpeople to create.")
                                .type(new GraphQLNonNull(Scalars.GraphQLString))
                                .build())
                        .argument(GraphQLArgument.newArgument()
                                .name("lastName")
                                .description("LastName of the HpPpeople to create.")
                                .type(new GraphQLNonNull(Scalars.GraphQLString))
                                .build())
                        .dataFetcher(hpPeopleDataFetcher.create())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("deleteHpPeople")
                        .type(Scalars.GraphQLLong)
                        .argument(GraphQLArgument.newArgument()
                                .name("id")
                                .description("Id of the HpPpeople to delete.")
                                .type(Scalars.GraphQLLong)
                                .build())
                        .argument(GraphQLArgument.newArgument()
                                .name("firstName")
                                .description("FisrtName of the HpPpeople to delete.")
                                .type(Scalars.GraphQLString)
                                .build())
                        .argument(GraphQLArgument.newArgument()
                                .name("lastName")
                                .description("LastName of the HpPpeople to delete.")
                                .type(Scalars.GraphQLString)
                                .build())
                        .dataFetcher(hpPeopleDataFetcher.delete())
                        .build())
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .name("letsFight")
                        .type(fightType)
                        .argument(GraphQLArgument.newArgument()
                                .name("hpId")
                                .description("Id of the HpPpeople to delete.")
                                .type(new GraphQLNonNull(Scalars.GraphQLLong))
                                .build())
                        .argument(GraphQLArgument.newArgument()
                                .name("swapiId")
                                .description("FisrtName of the HpPpeople to delete.")
                                .type(new GraphQLNonNull(Scalars.GraphQLString))
                                .build())
                        .argument(GraphQLArgument.newArgument()
                                .name("winner")
                                .description("Cheater !!!!")
                                .type(WinnerGraph.getEnum())
                                .build())
                        .dataFetcher(fightDataFetcher.fight())
                        .build())
                .build();
        
        return GraphQLSchema.newSchema()
                .query(queryType)
                .mutation(mutationType)
                .build();
    }

}
