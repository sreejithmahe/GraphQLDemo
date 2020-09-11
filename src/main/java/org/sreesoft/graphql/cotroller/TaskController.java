/**
 * 
 */
package org.sreesoft.graphql.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sreesoft.graphql.service.GraphQLService;
import org.sreesoft.service.TaskService;

import graphql.ExecutionResult;

/**
 * @author k_sre
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/tasks")
@RestController
public class TaskController {

	
//	@Autowired
	//private TaskService taskService;
	
}
