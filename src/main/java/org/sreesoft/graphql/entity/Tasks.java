package org.sreesoft.graphql.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;


@Table(name = "tasks")
@Entity
public class Tasks {
	
	@Id
	//  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	 // @GenericGenerator(name = "native", strategy = "native")
	
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

	
	  private Long id;


	  @NotNull
	  @Column(columnDefinition = "BINARY(16)")
	  @Type(type = "uuid-binary")
	  private UUID tenantId;

	  private String tenantName;

	  @NotNull
	  @Column(columnDefinition = "BINARY(16)")
	  @Type(type = "uuid-binary")
	  private UUID taskInstanceId;

	  private String taskName;

	  private String taskType;

	  @NotNull
	  @Column(columnDefinition = "BINARY(16)")
	  @Type(type = "uuid-binary")
	  private UUID processInstanceId;
	  
	  
	  
	  @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "processes_id", nullable = false,referencedColumnName = "processInstanceId")
	  private Processes processes;
	  
	  

	  @NotNull
	  @Column(columnDefinition = "VARCHAR(4000)")
	  private String variables;

	  @NotNull
	 // @Convert(converter = StatusConverter.class)
	  private String status;

	  private String assignee;

	  private Timestamp assignedDateTime;

	  @NotNull
	  private Timestamp startDateTime;

	  private String completedBy;

	  private Timestamp completedDateTime;

	  private String terminatedBy;

	  private Timestamp terminatedDateTime;

	  @NotNull
	  private String lastModifiedBy;

	  @NotNull
	  private Timestamp lastModifiedDateTime;

	  @NotNull
	  private String eventType;

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
	 * @return the taskInstanceId
	 */
	public UUID getTaskInstanceId() {
		return taskInstanceId;
	}

	/**
	 * @param taskInstanceId the taskInstanceId to set
	 */
	public void setTaskInstanceId(UUID taskInstanceId) {
		this.taskInstanceId = taskInstanceId;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the taskType
	 */
	public String getTaskType() {
		return taskType;
	}

	/**
	 * @param taskType the taskType to set
	 */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
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
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the assignee
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	/**
	 * @return the assignedDateTime
	 */
	public Timestamp getAssignedDateTime() {
		return assignedDateTime;
	}

	/**
	 * @param assignedDateTime the assignedDateTime to set
	 */
	public void setAssignedDateTime(Timestamp assignedDateTime) {
		this.assignedDateTime = assignedDateTime;
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
	 * @return the completedBy
	 */
	public String getCompletedBy() {
		return completedBy;
	}

	/**
	 * @param completedBy the completedBy to set
	 */
	public void setCompletedBy(String completedBy) {
		this.completedBy = completedBy;
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
	 * @return the processes
	 */
	public Processes getProcesses() {
		return processes;
	}

	/**
	 * @param processes the processes to set
	 */
	public void setProcesses(Processes processes) {
		this.processes = processes;
	}

	/**
	 * @param id
	 * @param tenantId
	 * @param tenantName
	 * @param taskInstanceId
	 * @param taskName
	 * @param taskType
	 * @param processInstanceId
	 * @param processes
	 * @param variables
	 * @param status
	 * @param assignee
	 * @param assignedDateTime
	 * @param startDateTime
	 * @param completedBy
	 * @param completedDateTime
	 * @param terminatedBy
	 * @param terminatedDateTime
	 * @param lastModifiedBy
	 * @param lastModifiedDateTime
	 * @param eventType
	 */
	public Tasks(Long id, @NotNull UUID tenantId, String tenantName, @NotNull UUID taskInstanceId, String taskName,
			String taskType, @NotNull UUID processInstanceId, Processes processes, @NotNull String variables,
			@NotNull String status, String assignee, Timestamp assignedDateTime, @NotNull Timestamp startDateTime,
			String completedBy, Timestamp completedDateTime, String terminatedBy, Timestamp terminatedDateTime,
			@NotNull String lastModifiedBy, @NotNull Timestamp lastModifiedDateTime, @NotNull String eventType) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.taskInstanceId = taskInstanceId;
		this.taskName = taskName;
		this.taskType = taskType;
		this.processInstanceId = processInstanceId;
		this.processes = processes;
		this.variables = variables;
		this.status = status;
		this.assignee = assignee;
		this.assignedDateTime = assignedDateTime;
		this.startDateTime = startDateTime;
		this.completedBy = completedBy;
		this.completedDateTime = completedDateTime;
		this.terminatedBy = terminatedBy;
		this.terminatedDateTime = terminatedDateTime;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDateTime = lastModifiedDateTime;
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", tenantId=" + tenantId + ", tenantName=" + tenantName + ", taskInstanceId="
				+ taskInstanceId + ", taskName=" + taskName + ", taskType=" + taskType + ", processInstanceId="
				+ processInstanceId + ", processes=" + processes + ", variables=" + variables + ", status=" + status
				+ ", assignee=" + assignee + ", assignedDateTime=" + assignedDateTime + ", startDateTime="
				+ startDateTime + ", completedBy=" + completedBy + ", completedDateTime=" + completedDateTime
				+ ", terminatedBy=" + terminatedBy + ", terminatedDateTime=" + terminatedDateTime + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedDateTime=" + lastModifiedDateTime + ", eventType=" + eventType + "]";
	}

	/**
	 * 
	 */
	public Tasks() {
		super();
	}
	  
	  
	  
	  
}
