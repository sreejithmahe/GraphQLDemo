package org.sreesoft.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.entity.Tasks;
import org.sreesoft.graphql.model.ProcessModel;
import org.sreesoft.graphql.model.TaskModel;
import org.sreesoft.graphql.service.TaskService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;


@Component
public class TaskQuery 
{
	@Autowired
	TaskService taskService;
   
	@GraphQLQuery(name ="AllTaskModel")
	public TaskModel getTask(@GraphQLArgument(name ="count" ,defaultValue = "0" ) final int count) {
        
		List<Tasks> taskList = taskService.getTask(count);
		TaskModel taskModel = new TaskModel();
		TaskModel.setTaskList(taskList);
        return taskModel;
    }
	
	
	@GraphQLQuery(name = "_pageInfo")
	public Page<Tasks> totalElements(@GraphQLContext TaskModel taskModel,@GraphQLArgument(name ="page" ,defaultValue = "0" ) final int page,@GraphQLArgument(name ="size" ,defaultValue = "25" )final int size) {
		 return this.taskService.getPageInfo(page,size);
	}
}
