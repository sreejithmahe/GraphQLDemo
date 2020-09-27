/**
 * 
 */
package org.sreesoft.graphql.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author k_sre
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
@RestController
public class ProcessController {

	private static final Logger log = LoggerFactory.getLogger(ProcessController.class);
	
	/*
	 * @Autowired GraphQLService graphQLService;
	 * 
	 * @PostMapping(value = "/process", consumes =
	 * MediaType.APPLICATION_JSON_UTF8_VALUE, produces =
	 * MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * 
	 * @ResponseBody public Map<String, Object> indexFromAnnotated(@RequestBody
	 * Map<String, String> request, HttpServletRequest raw) { ExecutionResult
	 * executionResult =
	 * graphQLService.getGraphQL().execute(ExecutionInput.newExecutionInput()
	 * .query(request.get("query")).operationName(request.get("operationName")).
	 * context(raw).build()); return executionResult.toSpecification(); }
	 */
	
}
