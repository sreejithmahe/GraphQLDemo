/**
 * 
 */
package org.sreesoft.graphql.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sreesoft.graphql.service.GraphQLService;

import graphql.ExecutionResult;

/**
 * @author k_sre
 *
 */
@RequestMapping("/api/process")
@RestController
public class ProcessController {

	@Autowired
    GraphQLService graphQLService;
	
	@GetMapping
	ResponseEntity<Object> getProcess(@RequestBody String query) {
		 ExecutionResult execute = graphQLService.getGraphQL().execute(query);
	        return new ResponseEntity<>(execute, HttpStatus.OK);
	}
}
