/**
 * 
 */
package org.sreesoft.graphql.cotroller;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sreesoft.graphql.service.GraphQLService;

import graphql.ExecutionResult;

/**
 * @author k_sre
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/process")
@RestController
public class ProcessController {

	private static final Logger log = LoggerFactory.getLogger(ProcessController.class);
	
	@Autowired
    GraphQLService graphQLService;
	
	
	
	@PostMapping
	ResponseEntity<Object> getProcess(@RequestBody String query) {
		log.info(" @RequestBody : "+query);
		
		String inputQuery = StringEscapeUtils.unescapeJava(query);
		log.info(" @Input Query  : "+inputQuery);
		 ExecutionResult execute = graphQLService.getGraphQL().execute(inputQuery);
		 log.info(" @ResponseEntity : "+execute);
	        return new ResponseEntity<>(execute, HttpStatus.OK);
	}
	
}
