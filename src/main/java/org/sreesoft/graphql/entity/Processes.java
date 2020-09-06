/**
 * 
 */
package org.sreesoft.graphql.entity;

import java.sql.Timestamp;

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
public class Processes {
	
	  @Id
	  private Long id;
	  private String tenantId;
	  private String tenantName;
	  private String processDefinitionId;
	  private String parentProcessInstanceId;
	  private String processInstanceId;
	  private String processName;
	  private String variables;
	 // @Convert(converter = StatusConverter.class)
	  private Status status;
	  private Timestamp startDateTime;
	  private String terminatedBy;
	  private String terminatedDateTime;
	  private String lastModifiedBy;
	  private String lastModifiedDateTime;
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
	public String getTenantId() {
		return tenantId;
	}
	/**
	 * @param tenantId the tenantId to set
	 */
	public void setTenantId(String tenantId) {
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
	public String getProcessDefinitionId() {
		return processDefinitionId;
	}
	/**
	 * @param processDefinitionId the processDefinitionId to set
	 */
	public void setProcessDefinitionId(String processDefinitionId) {
		this.processDefinitionId = processDefinitionId;
	}
	/**
	 * @return the parentProcessInstanceId
	 */
	public String getParentProcessInstanceId() {
		return parentProcessInstanceId;
	}
	/**
	 * @param parentProcessInstanceId the parentProcessInstanceId to set
	 */
	public void setParentProcessInstanceId(String parentProcessInstanceId) {
		this.parentProcessInstanceId = parentProcessInstanceId;
	}
	/**
	 * @return the processInstanceId
	 */
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	/**
	 * @param processInstanceId the processInstanceId to set
	 */
	public void setProcessInstanceId(String processInstanceId) {
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
	public String getTerminatedDateTime() {
		return terminatedDateTime;
	}
	/**
	 * @param terminatedDateTime the terminatedDateTime to set
	 */
	public void setTerminatedDateTime(String terminatedDateTime) {
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
	public String getLastModifiedDateTime() {
		return lastModifiedDateTime;
	}
	/**
	 * @param lastModifiedDateTime the lastModifiedDateTime to set
	 */
	public void setLastModifiedDateTime(String lastModifiedDateTime) {
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
	 * @param id
	 * @param tenantId
	 * @param tenantName
	 * @param processDefinitionId
	 * @param parentProcessInstanceId
	 * @param processInstanceId
	 * @param processName
	 * @param variables
	 * @param startDateTime
	 * @param terminatedBy
	 * @param terminatedDateTime
	 * @param lastModifiedBy
	 * @param lastModifiedDateTime
	 * @param eventType
	 * @param status
	 */
	public Processes(Long id, String tenantId, String tenantName, String processDefinitionId, String parentProcessInstanceId,
			String processInstanceId, String processName, String variables, Timestamp startDateTime,
			String terminatedBy, String terminatedDateTime, String lastModifiedBy, String lastModifiedDateTime,
			String eventType,Status status) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.processDefinitionId = processDefinitionId;
		this.parentProcessInstanceId = parentProcessInstanceId;
		this.processInstanceId = processInstanceId;
		this.processName = processName;
		this.variables = variables;
		this.startDateTime = startDateTime;
		this.terminatedBy = terminatedBy;
		this.terminatedDateTime = terminatedDateTime;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDateTime = lastModifiedDateTime;
		this.eventType = eventType;
		this.status = status;
	}
	/**
	 * 
	 */
	public Processes() {
		super();
	}
	@Override
	public String toString() {
		return "Process [id=" + id + ", tenantId=" + tenantId + ", tenantName=" + tenantName + ", processDefinitionId="
				+ processDefinitionId + ", parentProcessInstanceId=" + parentProcessInstanceId + ", processInstanceId="
				+ processInstanceId + ", processName=" + processName + ", variables=" + variables + ", status=" 
				+ ", startDateTime=" + startDateTime + ", terminatedBy=" + terminatedBy + ", terminatedDateTime="
				+ terminatedDateTime + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDateTime="
				+ lastModifiedDateTime + ", eventType=" + eventType + "]";
	}
	  

}
