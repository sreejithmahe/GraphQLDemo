package org.sreesoft.graphql.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Tasks;
import org.sreesoft.graphql.model.TaskModel;
import org.sreesoft.graphql.service.TaskService;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;


/**
 * @author k_sre
 *
 */

@Component
@GraphQLApi
public class TaskQuery {
/**
 *
 */
@Autowired
private TaskService taskService;

/**
 * @return taskModel
 */
@GraphQLQuery(name = "allTasksModel")
public TaskModel getTask() {

List<Tasks> taskList = taskService.getTaskAll();
TaskModel taskModel = new TaskModel();
TaskModel.setTasks(taskList);
        return taskModel;
    }

/**
 * @param count count
 * @return count count
 */
@GraphQLQuery(name = "taskAll")
public List<Tasks> getTaskAll(@GraphQLArgument(name = "count",
defaultValue = "0") final int count) {
return this.taskService.getTask(count);

    }


/**
 * @param taskModel taskModel
 * @param page page
 * @param size size
 * @return size size
 */
@GraphQLQuery(name = "_pageInfo")
public Page<Tasks> totalElements(@GraphQLContext final TaskModel taskModel,
@GraphQLArgument(name = "page", defaultValue = "0")final int page,
@GraphQLArgument(name = "size", defaultValue = "25")final int size) {
 return this.taskService.getPageInfo(page, size);
}
}
