package org.sreesoft.graphql.service;


import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.model.Status;
import org.sreesoft.graphql.repository.ProcessRepository;
import org.sreesoft.graphql.service.datafetcher.ProcessByIdDataFetcher;
import org.sreesoft.graphql.service.datafetcher.ProcessDataFetcher;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class GraphQLService {

    @Autowired
    ProcessRepository processRepository;

    @Value("classpath:processes.graphql")
    Resource resource;

    private GraphQL graphQL;
    @Autowired
    private ProcessDataFetcher processDataFetcher;
    @Autowired
    private ProcessByIdDataFetcher processByIdDataFetcher;

    // load schema at application start up
    @PostConstruct
    private void loadSchema() throws IOException {

        //Load Process into the Process Repository
        loadDataIntoHSQL();

        // get the schema
        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }
    private void loadDataIntoHSQL() {
		/*
		 * Stream.of( new Processes ( new Long(1000), new UUID(868787,
		 * 987),"TenantName",new UUID(6777, 455),new UUID(555, 97787), new UUID(2333,
		 * 788),"processName-workflow","variables",Status.PENDING,new
		 * Timestamp(9863747), "TerminatedBy", new Timestamp(83747), "Modified-who",new
		 * Timestamp(76863747),"EventType" ) ).forEach(processes -> {
		 * processRepository.save(processes); });
		 */
        Stream.of(
        		new Processes (
        				new Long(1000), "","Samsung","","",
        				"","processName-workflow","variables","2020-08-21",
        				"TerminatedBy", "2020-09-01", "Modified-p","2020-09-11","EventType"
        				),new Processes (
                				new Long(1001), "","John","","",
                				"","processName-camunda","variables","2020-08-21",
                				"TerminatedBy", "2020-09-01", "Modified-u","2020-09-11","EventType"
                				),
        		new Processes (
        				new Long(1002), "","Len","","",
        				"","processName-kafka","variables","2020-08-21",
        				"TerminatedBy", "2020-09-01", "Modified-t","2020-09-11","EventType"
        				)
        ).forEach(processes -> {
        	processRepository.save(processes);
        });
    }

	private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allProces", processDataFetcher)
                        .dataFetcher("processById", processByIdDataFetcher))
                .build();
    }


    public GraphQL getGraphQL() {
        return graphQL;
    }
}
