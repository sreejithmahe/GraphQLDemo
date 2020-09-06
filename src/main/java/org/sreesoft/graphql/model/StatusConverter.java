/**
 * 
 */
package org.sreesoft.graphql.model;

import javax.persistence.AttributeConverter;

/**
 * @author k_sre
 *
 */
public class StatusConverter implements AttributeConverter<Status,String>{

	@Override
	public String convertToDatabaseColumn(Status status) {
		return status.toString();
	}

	@Override
	public Status convertToEntityAttribute(String dbValue) {
		return Status.byDBValue(dbValue);
	}

}
