package org.sreesoft.graphql.model;

import java.util.List;

import org.sreesoft.graphql.entity.Processes;


public class ProcessModel {
	private static List<Processes> processList ;

	public static List<Processes> getProcessList() {
		return processList;
	}

	public static void setProcessList(List<Processes> processList) {
		ProcessModel.processList = processList;
	}
}
