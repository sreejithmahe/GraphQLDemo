package org.sreesoft.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.sreesoft.graphql.entity.TaskAudit;

public interface TaskAuditRepository extends CrudRepository<TaskAudit, Long>{

}
