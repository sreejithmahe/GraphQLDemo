/**
 * 
 */
package org.sreesoft.graphql.cotroller;

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

//	private static final Logger log = LoggerFactory.getLogger(ProcessController.class);
	
	//@Autowired
    //GraphQLService graphQLService;
	
	/*
	
	 @PostMapping(value = "/process", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Object> getProcess(@RequestBody String query) {
		log.info(" @RequestBody : "+query);
		
		String inputQuery = StringEscapeUtils.unescapeJava(query);
		log.info(" @Input Query  : "+inputQuery);
		 ExecutionResult execute = graphQLService.getGraphQL().execute(inputQuery);
		 log.info(" @ResponseEntity : "+execute);
	        return new ResponseEntity<>(execute, HttpStatus.OK);
	}
	 */
	/*
	 * @PostMapping(value = "/process", consumes =
	 * MediaType.APPLICATION_JSON_UTF8_VALUE, produces =
	 * MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * 
	 * @ResponseBody public Map<String, Object> indexFromAnnotated(@RequestBody
	 * Map<String, String> request, HttpServletRequest raw) { ExecutionResult
	 * executionResult =
	 * graphQLService.getGraphQL().execute(ExecutionInput.newExecutionInput()
	 * .query(request.get("query")) .operationName(request.get("operationName"))
	 * .context(raw) .build()); return executionResult.toSpecification(); }
	 */
	 
	 
	
}
