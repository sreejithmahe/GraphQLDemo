package org.sreesoft.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.service.ProcessService;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class PersonQuery implements GraphQLQueryResolver{
	
	@Autowired
	ProcessService processService;
	
	public List<Processes> getProcess(final int count) {
        return this.processService.getProcess(count);
    }

}
