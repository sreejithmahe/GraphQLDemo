/**
 * 
 */
package org.sreesoft.graphql.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.sreesoft.graphql.model.Status;
import org.sreesoft.graphql.model.StatusConverter;

/**
 * @author k_sre
 *
 */
@Table
@Entity
public class Processes2 {
	
	  @Id
	  private Long id;
	  private UUID tenantId;
	  private String tenantName;
	  private UUID processDefinitionId;
	  private UUID parentProcessInstanceId;
	  private UUID processInstanceId;
	  private String processName;
	  private String variables;
	  @Convert(converter = StatusConverter.class)
	  private Status status;
	  private Timestamp startDateTime;
	  private String terminatedBy;
	  private Timestamp terminatedDateTime;
	  private String lastModifiedBy;
	  private Timestamp lastModifiedDateTime;
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
	 * @param id
	 * @param tenantId
	 * @param tenantName
	 * @param processDefinitionId
	 * @param parentProcessInstanceId
	 * @param processInstanceId
	 * @param processName
	 * @param variables
	 * @param status
	 * @param startDateTime
	 * @param terminatedBy
	 * @param terminatedDateTime
	 * @param lastModifiedBy
	 * @param lastModifiedDateTime
	 * @param eventType
	 */
	public Processes2(Long id, UUID tenantId, String tenantName, UUID processDefinitionId, UUID parentProcessInstanceId,
			UUID processInstanceId, String processName, String variables, Status status, Timestamp startDateTime,
			String terminatedBy, Timestamp terminatedDateTime, String lastModifiedBy, Timestamp lastModifiedDateTime,
			String eventType) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.processDefinitionId = processDefinitionId;
		this.parentProcessInstanceId = parentProcessInstanceId;
		this.processInstanceId = processInstanceId;
		this.processName = processName;
		this.variables = variables;
		this.status = status;
		this.startDateTime = startDateTime;
		this.terminatedBy = terminatedBy;
		this.terminatedDateTime = terminatedDateTime;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDateTime = lastModifiedDateTime;
		this.eventType = eventType;
	}
	/**
	 * 
	 */
	public Processes2() {
		super();
	}
	@Override
	public String toString() {
		return "Process [id=" + id + ", tenantId=" + tenantId + ", tenantName=" + tenantName + ", processDefinitionId="
				+ processDefinitionId + ", parentProcessInstanceId=" + parentProcessInstanceId + ", processInstanceId="
				+ processInstanceId + ", processName=" + processName + ", variables=" + variables + ", status=" + status
				+ ", startDateTime=" + startDateTime + ", terminatedBy=" + terminatedBy + ", terminatedDateTime="
				+ terminatedDateTime + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDateTime="
				+ lastModifiedDateTime + ", eventType=" + eventType + "]";
	}
	  

}
