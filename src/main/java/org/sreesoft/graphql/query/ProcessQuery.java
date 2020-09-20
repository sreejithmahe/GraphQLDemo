package org.sreesoft.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.model.ProcessModel;
import org.sreesoft.graphql.service.ProcessService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;


@Component
public class ProcessQuery 
			//	implements GraphQLQueryResolver
{
	@Autowired
	ProcessService processService;
    
	
	@GraphQLQuery(name ="AllProcessModel")
	public ProcessModel getProcess1(   @GraphQLArgument(name ="count" ,defaultValue = "0" ) final int count) {
        
		List<Processes> processList = processService.getProcess(count);
        ProcessModel processModel = new ProcessModel();
        ProcessModel.setProcessList(processList);
        return processModel;
    }
	
	@GraphQLQuery(name ="AllProcess")
	public List<Processes> getProcess(@GraphQLArgument(name ="count" ,defaultValue = "0" ) final int count) {
        return this.processService.getProcess(count);
    }
	@GraphQLQuery(name ="AllProcessByTenantName")
	public Processes getByTenantName(final String tenantName) {
        return this.processService.getByTenantName(tenantName);
    }
	@GraphQLQuery(name ="AllProcessByPage")
	public List<Processes> getProcessByPage(@GraphQLContext Processes processes,@GraphQLArgument(name ="page" ,defaultValue = "0" ) final int page,@GraphQLArgument(name ="size" ,defaultValue = "25" )final int size) {
		return this.processService.getProcessByPage(page,size);
    }
	public List<Processes> getProcessByPageSortedByTenantName(final int page,final int size,String SortBy) {
		return this.processService.getProcessByPageSortedByTenantName(page,size,SortBy);
    }
	@GraphQLQuery(name = "_gateWay")
	public String isCool(@GraphQLContext Processes processes) {
		final String gateWayURL ="http://localhost:8083/gateway/testurl";
		return gateWayURL;
	}
	@GraphQLQuery(name = "totalCount")
	public Integer totalCount(@GraphQLContext Processes processes) {
		 return this.processService.getTotalCount();
	}
	@GraphQLQuery(name = "totalPage")
	public Integer totalCount(@GraphQLContext Processes processes,final int page,final int size) {
		 return this.processService.getTotalPage(page,size);
	
	}
	@GraphQLQuery(name = "_pageInfo")
	public Page<Processes> totalElements(@GraphQLContext ProcessModel processModel,@GraphQLArgument(name ="page" ,defaultValue = "0" ) final int page,@GraphQLArgument(name ="size" ,defaultValue = "25" )final int size) {
		 return this.processService.getPageInfo(page,size);
	}
	@GraphQLQuery(name = "_pageable")
	public boolean getPageable(@GraphQLContext Processes processes,int page, int size) {
		return this.processService.getPageable(page,size);
	}
}
