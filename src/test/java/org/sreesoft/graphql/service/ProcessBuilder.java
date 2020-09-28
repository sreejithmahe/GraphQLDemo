package org.sreesoft.graphql.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.entity.Tasks;

public class ProcessBuilder {

	  private UUID tenantId = UUID.randomUUID();
	  private UUID taskInstanceId = UUID.randomUUID();
	  private UUID processInstanceId = UUID.randomUUID();
	  private Timestamp assignedDateTime = Timestamp.from(Instant.now());
	  private Timestamp startDateTime = Timestamp.from(Instant.now());
	  private Timestamp completedDateTime = Timestamp.from(Instant.now());
	  private Timestamp terminatedDateTime = Timestamp.from(Instant.now());
	  private Timestamp lastModifiedDateTime = Timestamp.from(Instant.now());

	  public ProcessBuilder withTenantId(UUID tenantId) {
	    this.tenantId = tenantId;
	    return this;
	  }

	  public ProcessBuilder withTaskInstanceId(UUID taskInstanceId) {
	    this.taskInstanceId = taskInstanceId;
	    return this;
	  }

	  public ProcessBuilder withProcessInstanceId(UUID processInstanceId) {
	    this.processInstanceId = processInstanceId;
	    return this;
	  }

	  public Processes build() {
	    return new Processes(
	        null, processInstanceId, "", processInstanceId, processInstanceId, processInstanceId, null, null, null, null, assignedDateTime, assignedDateTime, null, assignedDateTime, null, assignedDateTime, null
	    );
	  }
	}
