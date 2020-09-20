package org.sreesoft.graphql.service;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.entity.Tasks;
import org.sreesoft.graphql.model.Status;
import org.sreesoft.graphql.repository.ProcessRepository;
import org.sreesoft.graphql.repository.TaskRepository;
import org.sreesoft.graphql.service.datafetcher.ProcessByIdDataFetcher;
import org.sreesoft.graphql.service.datafetcher.ProcessDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {

    @Autowired
    ProcessRepository processRepository;
    @Autowired
    TaskRepository taskRepository;

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
	  Instant instant = Instant.now();
  	  Timestamp timestamp = Timestamp.from(instant);
 /*
  	  Stream.of(
        		new Processes (
        				new Long(1000), "","Samsung","","33",
        				"5001","processName-workflow","variables",timestamp,
        				"TerminatedBy", "2020-09-01", "Modified-p","2020-09-11","EventType",Status.COMPLETED
        				),new Processes (
                				new Long(1001), "","Sony","","55",
                				"5002","processName-camunda","variables",timestamp,
                				"TerminatedBy", "2020-09-01", "Modified-u","2020-09-11","EventType",Status.PENDING
                				),
        		new Processes (
        				new Long(1002), "","Gionee","","66",
        				"5003","processName-kafka","variables",timestamp,
        				"TerminatedBy", "2020-09-01", "Modified-t","2020-09-11","EventType",Status.COMPLETED
        				),
        		new Processes (
        				new Long(1003), "","Philips","","65",
        				"5004","processName-workflow","testData",timestamp,
        				"TerminatedBy", "2020-09-01", "Modified-t","2020-09-11","EventType",Status.TERMINATED
        				)
        ).forEach(processes -> {
        	processRepository.save(processes);
        });
        
        
        Stream.of(
        		new Tasks (
        				new Long(100), "5001","Winld","wilddog",""
        				),
        		new Tasks (
        				new Long(101), "5001","Herald","booto",""
                		),
        		new Tasks (
        				new Long(102), "5002","Wintage","rajesh",""
        				),
        		new Tasks (
        				new Long(103), "5004","Mykuna","mygu",""
        				)
        ).forEach(tasks -> {
        	taskRepository.save(tasks);
        });
        
       */
    }

	private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allProcess", processDataFetcher)
                        .dataFetcher("processById", processByIdDataFetcher))
                .build();
    }


    public GraphQL getGraphQL() {
        return graphQL;
    }
}
