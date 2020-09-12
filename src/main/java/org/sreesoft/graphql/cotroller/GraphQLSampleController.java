package org.sreesoft.graphql.cotroller;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sreesoft.graphql.query.ProcessQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class GraphQLSampleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphQLSampleController.class);

    private final GraphQL graphQL;

    @Autowired
    public GraphQLSampleController(ProcessQuery processQuery
                                   ) {

        //Schema generated from query classes
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withBasePackages("org.sreesoft.graphql")
                .withOperationsFromSingletons(processQuery)
                .generate();
        graphQL = GraphQL.newGraphQL(schema).build();

        LOGGER.info("Generated GraphQL schema using SPQR");
    }

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> indexFromAnnotated(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }
}
