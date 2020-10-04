/**
 * 
 */
package org.sreesoft.graphql.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;
import org.sreesoft.graphql.model.Status;
import org.sreesoft.graphql.model.StatusConverter;

import io.leangen.graphql.annotations.GraphQLQuery;

/**
 * @author k_sre
 *
 */
@Table(name = "processes")
@Entity
public class Processes implements Serializable {

/**
 * 
 */
private static final long serialVersionUID = 1L;

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)


  private Long id;


  @NotNull
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  @GraphQLQuery(name="TenantId", description ="Process tenantId ")
  private UUID tenantId;

  private String tenantName;

  @NotNull
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID processDefinitionId;

  
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID parentProcessInstanceId;

  @NaturalId
  @NotNull
  @Column(columnDefinition = "BINARY(16)")
  @Type(type = "uuid-binary")
  private UUID processInstanceId;
  
  

  @OneToMany(mappedBy = "processes", fetch = FetchType.LAZY,
      cascade = CascadeType.ALL)
  @OrderBy("assignedDateTime DESC")
  private List<Tasks> tasks;
  
  

  private String processName;

  @NotNull
  @Column(columnDefinition = "VARCHAR(4000)")
  private String variables;

  @NotNull
  @Convert(converter = StatusConverter.class)
  private Status status;

  @NotNull
  private Timestamp startDateTime;

  private Timestamp completedDateTime;

  private String terminatedBy;

  private Timestamp terminatedDateTime;

  @NotNull
  private String lastModifiedBy;

  @NotNull
  private Timestamp lastModifiedDateTime;

  @NotNull
  private String eventType;
  
 //@Transient
  
  //@Column(name="assignee", table="tasks")
  private String assignee;

/**
 * @return the id
 */
public Long getId() {
return id;
}

/**
 * @param id the id to set
 */
public void setId(Long id) {
this.id = id;
}

/**
 * @return the tenantId
 */
public UUID getTenantId() {
return tenantId;
}

/**
 * @param tenantId the tenantId to set
 */
public void setTenantId(UUID tenantId) {
this.tenantId = tenantId;
}

/**
 * @return the tenantName
 */
public String getTenantName() {
return tenantName;
}

/**
 * @param tenantName the tenantName to set
 */
public void setTenantName(String tenantName) {
this.tenantName = tenantName;
}

/**
 * @return the processDefinitionId
 */
public UUID getProcessDefinitionId() {
return processDefinitionId;
}

/**
 * @param processDefinitionId the processDefinitionId to set
 */
public void setProcessDefinitionId(UUID processDefinitionId) {
this.processDefinitionId = processDefinitionId;
}

/**
 * @return the parentProcessInstanceId
 */
public UUID getParentProcessInstanceId() {
return parentProcessInstanceId;
}

/**
 * @param parentProcessInstanceId the parentProcessInstanceId to set
 */
public void setParentProcessInstanceId(UUID parentProcessInstanceId) {
this.parentProcessInstanceId = parentProcessInstanceId;
}

/**
 * @return the processInstanceId
 */
public UUID getProcessInstanceId() {
return processInstanceId;
}

/**
 * @param processInstanceId the processInstanceId to set
 */
public void setProcessInstanceId(UUID processInstanceId) {
this.processInstanceId = processInstanceId;
}

/**
 * @return the processName
 */
public String getProcessName() {
return processName;
}

/**
 * @param processName the processName to set
 */
public void setProcessName(String processName) {
this.processName = processName;
}

/**
 * @return the variables
 */
public String getVariables() {
return variables;
}

/**
 * @param variables the variables to set
 */
public void setVariables(String variables) {
this.variables = variables;
}

/**
 * @return the status
 */
public Status getStatus() {
return status;
}

/**
 * @param status the status to set
 */
public void setStatus(Status status) {
this.status = status;
}

/**
 * @return the startDateTime
 */
public Timestamp getStartDateTime() {
return startDateTime;
}

/**
 * @param startDateTime the startDateTime to set
 */
public void setStartDateTime(Timestamp startDateTime) {
this.startDateTime = startDateTime;
}

/**
 * @return the completedDateTime
 */
public Timestamp getCompletedDateTime() {
return completedDateTime;
}

/**
 * @param completedDateTime the completedDateTime to set
 */
public void setCompletedDateTime(Timestamp completedDateTime) {
this.completedDateTime = completedDateTime;
}

/**
 * @return the terminatedBy
 */
public String getTerminatedBy() {
return terminatedBy;
}

/**
 * @param terminatedBy the terminatedBy to set
 */
public void setTerminatedBy(String terminatedBy) {
this.terminatedBy = terminatedBy;
}

/**
 * @return the terminatedDateTime
 */
public Timestamp getTerminatedDateTime() {
return terminatedDateTime;
}

/**
 * @param terminatedDateTime the terminatedDateTime to set
 */
public void setTerminatedDateTime(Timestamp terminatedDateTime) {
this.terminatedDateTime = terminatedDateTime;
}

/**
 * @return the lastModifiedBy
 */
public String getLastModifiedBy() {
return lastModifiedBy;
}

/**
 * @param lastModifiedBy the lastModifiedBy to set
 */
public void setLastModifiedBy(String lastModifiedBy) {
this.lastModifiedBy = lastModifiedBy;
}

/**
 * @return the lastModifiedDateTime
 */
public Timestamp getLastModifiedDateTime() {
return lastModifiedDateTime;
}

/**
 * @param lastModifiedDateTime the lastModifiedDateTime to set
 */
public void setLastModifiedDateTime(Timestamp lastModifiedDateTime) {
this.lastModifiedDateTime = lastModifiedDateTime;
}

/**
 * @return the eventType
 */
public String getEventType() {
return eventType;
}

/**
 * @param eventType the eventType to set
 */
public void setEventType(String eventType) {
this.eventType = eventType;
}

/**
 * @return the tasks
 */
public List<Tasks> getTasks() {
return tasks;
}

/**
 * @param tasks the tasks to set
 */
public void setTasks(List<Tasks> tasks) {
this.tasks = tasks;
}

/**
 * @param id
 * @param tenantId
 * @param tenantName
 * @param processDefinitionId
 * @param parentProcessInstanceId
 * @param processInstanceId
 * @param tasks
 * @param processName
 * @param variables
 * @param status
 * @param startDateTime
 * @param completedDateTime
 * @param terminatedBy
 * @param terminatedDateTime
 * @param lastModifiedBy
 * @param lastModifiedDateTime
 * @param eventType
 */
public Processes(Long id, @NotNull UUID tenantId, String tenantName,
@NotNull UUID processDefinitionId,
UUID parentProcessInstanceId, @NotNull UUID processInstanceId, 
List<Tasks> tasks, String processName,
@NotNull String variables, @NotNull Status status, 
@NotNull Timestamp startDateTime,
Timestamp completedDateTime, String terminatedBy,
Timestamp terminatedDateTime,
@NotNull String lastModifiedBy, @NotNull Timestamp lastModifiedDateTime, 
@NotNull String eventType) {
super();
this.id = id;
this.tenantId = tenantId;
this.tenantName = tenantName;
this.processDefinitionId = processDefinitionId;
this.parentProcessInstanceId = parentProcessInstanceId;
this.processInstanceId = processInstanceId;
this.tasks = tasks;
this.processName = processName;
this.variables = variables;
this.status = status;
this.startDateTime = startDateTime;
this.completedDateTime = completedDateTime;
this.terminatedBy = terminatedBy;
this.terminatedDateTime = terminatedDateTime;
this.lastModifiedBy = lastModifiedBy;
this.lastModifiedDateTime = lastModifiedDateTime;
this.eventType = eventType;
}

@Override
public String toString() {
return "Processes [id=" + id + ", tenantId=" + tenantId + ","
+ " tenantName=" + tenantName
+ ", processDefinitionId=" + processDefinitionId + ", parentProcessInstanceId="
+ parentProcessInstanceId + ", processInstanceId=" +
processInstanceId + ", tasks=" + tasks
+ ", processName=" + processName + ", variables=" + variables + ","
+ " status=" + status
+ ", startDateTime=" + startDateTime + ", completedDateTime=" + 
completedDateTime + ", terminatedBy="
+ terminatedBy + ", terminatedDateTime=" + terminatedDateTime +
", lastModifiedBy=" + lastModifiedBy
+ ", lastModifiedDateTime=" + lastModifiedDateTime + ","
+ " eventType=" + eventType + "]";
}

/**
 * 
 */
public Processes() {
super();
}

public String getAssignee() {
	return assignee;
}

public void setAssignee(String assignee) {
	this.assignee = assignee;
}


}
