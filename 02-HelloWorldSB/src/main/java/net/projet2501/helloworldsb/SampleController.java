/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.projet2501.helloworldsb;

import graphql.ExecutionResult;
import java.util.LinkedHashMap;
import java.util.Map;
import net.projet2501.helloworld.HelloWorldGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @RequestMapping("/sample")
    @ResponseBody
    String home() {

        HelloWorldGraph schema = new HelloWorldGraph();

        Object result = new graphql.GraphQL(schema.getSchema()).execute("{hello}").getData();

        return result.toString();
    }

    @RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Object executeOperation(@RequestBody Map body) {

        HelloWorldGraph schema = new HelloWorldGraph();


        String query = (String) body.get("query");
        Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        ExecutionResult executionResult = new graphql.GraphQL(schema.getSchema()).execute(query);
        Map<String, Object> result = new LinkedHashMap<>();
        if (executionResult.getErrors().size() > 0) {
            result.put("errors", executionResult.getErrors());
            log.error("Errors: {}", executionResult.getErrors());
        }
        result.put("data", executionResult.getData());
        return result;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
