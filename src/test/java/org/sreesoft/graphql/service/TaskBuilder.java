package org.sreesoft.graphql.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import org.sreesoft.graphql.entity.Tasks;

public class TaskBuilder {

	  private UUID tenantId = UUID.randomUUID();
	  private UUID taskInstanceId = UUID.randomUUID();
	  private UUID processInstanceId = UUID.randomUUID();
	  private Timestamp assignedDateTime = Timestamp.from(Instant.now());
	  private Timestamp startDateTime = Timestamp.from(Instant.now());
	  private Timestamp completedDateTime = Timestamp.from(Instant.now());
	  private Timestamp terminatedDateTime = Timestamp.from(Instant.now());
	  private Timestamp lastModifiedDateTime = Timestamp.from(Instant.now());

	  public TaskBuilder withTenantId(UUID tenantId) {
	    this.tenantId = tenantId;
	    return this;
	  }

	  public TaskBuilder withTaskInstanceId(UUID taskInstanceId) {
	    this.taskInstanceId = taskInstanceId;
	    return this;
	  }

	  public TaskBuilder withProcessInstanceId(UUID processInstanceId) {
	    this.processInstanceId = processInstanceId;
	    return this;
	  }

	  public Tasks build() {
	    return new Tasks(
	        null, tenantId, "Ultimate", taskInstanceId, "Name of a Task", "User", processInstanceId,
	        null, "{ someKey: 0123456789 }", null, "Frank Kitchen", assignedDateTime, startDateTime,
	        "Orson Welles", completedDateTime, "Cyberdyne Systems", terminatedDateTime,
	        "Nathan Wallace", lastModifiedDateTime, "workflow.engine.TaskStartedMessage"
	    );
	  }
	}
