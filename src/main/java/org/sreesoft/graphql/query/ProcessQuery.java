package org.sreesoft.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.service.ProcessService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;


@Component
public class ProcessQuery 
//implements GraphQLQueryResolver
{
	
	@Autowired
	ProcessService processService;
    /*
	
	{
	    hello
	    (Processes: 
	    {id: 1000, tenantId: "Sreejith"}
	    )
	    
	} */
	
	
	 @GraphQLQuery(name = "hello")
	    public String getGreeting(@GraphQLArgument(name = "Processes", description = "Processes to greet.")
	                              final Processes processes){
	        return "Hello "+ processes.getTenantId()+"!";
	    }
/*
	 {
	     AllProcess
	     
	      {
	          id
	           tenantId
	           tenantName
	          
	      }
	      
	    } */
	@GraphQLQuery(name ="AllProcess")
	public List<Processes> getProcessAll() {
        return this.processService.getProcessAll();
    }
	/*
	 query {
	     AllProcessByCount(count : "*")
	     
	      {
	          id
	           tenantId
	           tenantName
	           isCool
	       
	      }
	      
	    } */
	@GraphQLQuery(name ="AllProcessByCount")
	public List<Processes> getProcess(final String count) {
        return this.processService.getProcess(count);
    }
	
	public Processes getByTenantName(final String tenantName) {
        return this.processService.getByTenantName(tenantName);
    }


	@GraphQLQuery(name ="AllProcessByPage")
	public List<Processes> getProcessByPage(final int page,final int size) {
		return this.processService.getProcessByPage(page,size);
    }
	public List<Processes> getProcessByPageSortedByTenantName(final int page,final int size,String SortBy) {
		return this.processService.getProcessByPageSortedByTenantName(page,size,SortBy);
    }
    
	
	@GraphQLQuery(name = "totalCount")
	public Integer totalCount(@GraphQLContext Processes processes) {
		 return this.processService.getTotalCount();
	
	}
	
	
	@GraphQLQuery(name = "_gateWay")
	public String isCool(@GraphQLContext Processes processes) {
		final String gateWayURL ="http://localhost:8083/gateway/testurl";
		return gateWayURL;
	}
	
}
