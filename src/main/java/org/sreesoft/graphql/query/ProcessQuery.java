package org.sreesoft.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.service.ProcessService;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class ProcessQuery implements GraphQLQueryResolver{
	
	@Autowired
	ProcessService processService;
	
	public List<Processes> getProcessAll() {
        return this.processService.getProcessAll();
    }
	
	public List<Processes> getProcess(final int count) {
        return this.processService.getProcess(count);
    }
	
	public Processes getByTenantName(final String tenantName) {
        return this.processService.getByTenantName(tenantName);
    }


	public List<Processes> getProcessByPage(final int page,final int size) {
		return this.processService.getProcessByPage(page,size);
    }
	public List<Processes> getProcessByPageSortedByTenantName(final int page,final int size,String SortBy) {
		return this.processService.getProcessByPageSortedByTenantName(page,size,SortBy);
    }
}
