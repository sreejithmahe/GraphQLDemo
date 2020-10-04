package org.sreesoft.graphql.query;

import java.util.List;
import java.util.UUID;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.model.ProcessModel;
import org.sreesoft.graphql.service.ProcessService;


/**
 * @author k_sre
 *
 */
@Component
@GraphQLApi
public class ProcessQuery {

/**
 *
 */
@Autowired
private ProcessService processService;


/**
 * @param count count
 * @return count
 */
@GraphQLQuery(name = "allProcessModel")
public ProcessModel getProcess1(@GraphQLArgument(name = "count",
defaultValue = "0") final int count) {

List<Processes> processList = processService.getProcess(count);
        ProcessModel processModel = new ProcessModel();
        ProcessModel.setProcess(processList);
        return processModel;
    }
/**
 * @param count count
 * @return count
 */
@GraphQLQuery(name = "processAll")
public List<Processes> getProcessAll(@GraphQLArgument(name = "count",
defaultValue = "0") final int count) {
        return this.processService.getProcess(count);
    }

/**
 * @param processInstanceId processInstanceId
 * @return Processes
 */
@GraphQLQuery(name = "processLatest")
public  List<Processes>  getProcessLatest(final String processInstanceId) {
return this.processService.
getProcessLatest(UUID.fromString(processInstanceId));
}
/**
 * @return ProcessModel
 */
@GraphQLQuery(name = "processLatestAssignee")
public  ProcessModel  getProcessLatestAssignee() {
List<Processes> processList = processService.getProcessLatestAssignee();
    ProcessModel processModel = new ProcessModel();
    ProcessModel.setProcess(processList);
    return processModel;
}
/**
 * @param tenantName tenantName
 * @return Processes
 */
@GraphQLQuery(name = "processByTenantName")
public Processes getByTenantName(final String tenantName) {
        return this.processService.getByTenantName(tenantName);
    }

    /*
@GraphQLQuery(name ="AllProcessByPage")
public List<Processes> getProcessByPage(@GraphQLContext Processes processes,
@GraphQLArgument(name ="page" ,defaultValue = "0")
final int page,@GraphQLArgument(name ="size" ,defaultValue = "25" )
final int size) {
return this.processService.getProcessByPage(page,size);
    }
public List<Processes> getProcessByPageSortedByTenantName
(final int page,final int size,String SortBy) {
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
public Integer totalCount(@GraphQLContext Processes processes,
final int page,final int size) {
 return this.processService.getTotalPage(page,size);

}
@GraphQLQuery(name = "_pageInfo")
public Page<Processes> totalElements(@GraphQLContext ProcessModel processModel,
@GraphQLArgument(name ="page" ,defaultValue = "0")
final int page,@GraphQLArgument(name ="size" ,
defaultValue = "25" )final int size) {
 return this.processService.getPageInfo(page,size);
}
@GraphQLQuery(name = "_pageable")
public boolean getPageable(@GraphQLContext Processes processes,
int page, int size) {
return this.processService.getPageable(page,size);
}
*/
}
