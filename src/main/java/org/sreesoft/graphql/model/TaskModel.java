package org.sreesoft.graphql.model;

import java.util.List;

import org.sreesoft.graphql.entity.Tasks;

/**
 * @author k_sre
 *
 */
public final class TaskModel {
/**
 *
 */
private static List<Tasks> tasks;

/**
 * @return the tasks
 */
public static List<Tasks> getTasks() {
return tasks;
}

/**
 * @param tasks the tasks to set
 */
public static void setTasks(List<Tasks> tasks) {
TaskModel.tasks = tasks;
}


}
