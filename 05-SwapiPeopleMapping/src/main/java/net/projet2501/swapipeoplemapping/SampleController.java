/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.swapipeoplemapping;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import java.util.LinkedHashMap;
import java.util.Map;
import net.projet2501.swapigraphql.graph.PeopleGraph;
import net.projet2501.swapigraphql.graph.fetcher.PeopleDataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    private static final Logger LOG = LoggerFactory.getLogger(SampleController.class);

    private final GraphQL graphql;

    @Autowired
    public SampleController(PeopleDataFetcher peopleDataFetcher) {

        GraphQLObjectType peopleType = PeopleGraph.getSimpleType();

        this.graphql = new GraphQL(
                GraphQLSchema.newSchema()
                .query(
                        GraphQLObjectType.newObject()
                        .name("QueryType")
                        .field(GraphQLFieldDefinition.newFieldDefinition()
                                .name("people")
                                .type(peopleType)
                                .argument(GraphQLArgument.newArgument()
                                        .name("id")
                                        .description("SWAPI id of the hero. If omitted, "
                                                + "returns the hero of the whole saga. "
                                                + "If provided, returns the hero of that particular episode.")
                                        .type(Scalars.GraphQLString)
                                        .defaultValue("1")
                                        .build())
                                .dataFetcher(peopleDataFetcher.simpleDataFectcher())
                                .build())
                        .build())
                .build());
    }

    @RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object executeOperation(@RequestBody Map body) {

        String query = (String) body.get("query");
        query = query.replaceAll("'", "\"");
        // Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        ExecutionResult executionResult = graphql.execute(query);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
            LOG.error("Errors: {}", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }

}
