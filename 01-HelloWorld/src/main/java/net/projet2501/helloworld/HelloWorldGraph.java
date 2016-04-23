/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.helloworld;

import static graphql.Scalars.GraphQLString;
import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import graphql.schema.GraphQLObjectType;
import static graphql.schema.GraphQLObjectType.newObject;
import graphql.schema.GraphQLSchema;

/**
 *
 * @author telligcirdec
 */
public class HelloWorldGraph {
    
    private final GraphQLSchema schema; 

    public HelloWorldGraph() {
        
        
        GraphQLObjectType queryType = newObject()
                        .name("helloWorldQuery")
                        .field(newFieldDefinition()
                                .type(GraphQLString)
                                .name("hello")
                                .staticValue("world")
                                .build())
                        .build();
        
        this.schema = GraphQLSchema.newSchema()
                        .query(queryType)
                        .build();
        
    }

    public GraphQLSchema getSchema() {
        return schema;
    }     
    
}
