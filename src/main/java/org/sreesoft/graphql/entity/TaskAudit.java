package org.sreesoft.graphql.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class TaskAudit {
	
	  @Id
	  private Long id;
	  private String tenantId;
	  private String tenantName;
	  private String processDefinitionId;

}
