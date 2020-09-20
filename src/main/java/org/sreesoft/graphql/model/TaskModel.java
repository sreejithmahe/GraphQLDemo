package org.sreesoft.graphql.model;

import java.util.List;

import org.sreesoft.graphql.entity.Tasks;

public class TaskModel {
	private static List<Tasks> taskList;

	public static List<Tasks> getTaskList() {
		return taskList;
	}

	public static void setTaskList(List<Tasks> taskList) {
		TaskModel.taskList = taskList;
	}
}
