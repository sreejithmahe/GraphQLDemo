package org.sreesoft.graphql.model;

import java.util.List;

import org.sreesoft.graphql.entity.Processes;


/**
 * @author k_sre
 *
 */
public class ProcessModel {


/**
 * @return the process
 */
public static List<Processes> getProcess() {
return process;
}

/**
 * @param process the process to set
 */
public static void setProcess(final List<Processes> process) {
ProcessModel.process = process;
}

/**
 *
 */
private static List<Processes> process;



}
