/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.helloworld;

import graphql.GraphQL;

public class HelloWorldMain {

    public static void main(String[] args) {

        HelloWorldGraph schema = new HelloWorldGraph();
        
        Object result = new GraphQL(schema.getSchema()).execute("{hello}").getData();

        System.out.println(result);
        // Prints: {hello=world}
    }
}
