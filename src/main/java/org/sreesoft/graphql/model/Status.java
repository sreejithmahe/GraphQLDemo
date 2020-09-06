/**
 * 
 */
package org.sreesoft.graphql.model;

/**
 * @author k_sre
 *
 */
public enum Status {
	PENDING{
		@Override
		public String toString() {
			return "Pending";
		}
	}, COMPLETED{
		@Override
		public String toString() {
			return "Completed";
		}
	}, TERMINATED{
		@Override
		public String toString() {
			return "Terminated";
		}
	};

	public static Status byDBValue(String dbValue) {
		for(Status status : values()) {
			if(status.toString().equalsIgnoreCase(dbValue)) {
				return status;
			}
			throw new IllegalArgumentException();
		}
		return Status.PENDING;
	}
}
