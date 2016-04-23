/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.letsfight.hp.graph;

import graphql.schema.GraphQLEnumType;

/**
 *
 * @author telligcirdec
 */
public abstract class WinnerGraph {

    public static GraphQLEnumType getEnum() {
        return GraphQLEnumType.newEnum()
                .name("Winner")
                .description("Type of winner.")
                .value("Wizard", Boolean.FALSE)
                .value("Jedi", Boolean.TRUE)
                .build();
    }

}
