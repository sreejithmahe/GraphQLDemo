/**
 *
 */
package org.sreesoft.graphql.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.sreesoft.graphql.entity.Processes;

/**
 * @author k_sre
 *
 */
@Repository
public interface ProcessRepository extends JpaRepository<Processes, Long> {

/**
 *
 */
String FIND_BY_TENANT_QUERY =
"from Processes where tenantName= :tenantName";
/**
 *
 */
String FIND_BY_LATEST_ASSIGNEE =
"from Processes where processInstanceId = :processInstanceId";

/**
 *
 */
String FIND_BY_LATEST_ASSIGNEE_1 =
"from Processes P LEFT JOIN Tasks T  ON  P.processInstanceId ="
+ " T.processInstanceId and P.processInstanceId = :processInstanceId";

/**
 *
 */
String FIND_BY_LATEST_ASSIGNEE_2 =
"from Processes P ,Tasks T  WHERE  P.processInstanceId ="
+ " T.processInstanceId and P.processInstanceId = :processInstanceId";

/**
 *
 */
String FIND_BY_LATEST_ASSIGNEE_3 =
"from processes P LEFT JOIN tasks T  ON  T.id ="
+ " (select  T.id from tasks T where assigned_date_time ="
+ " ( select Max(assigned_date_time) from tasks ))"
+ " AND P.process_Instance_Id = T.process_Instance_Id ";
  /**
 * @param tenantName tenantName
 * @return result
 */
@Query(FIND_BY_TENANT_QUERY)
Processes findByTenantName(@Param("tenantName")
      String tenantName);


/**
 * @param processInstanceId processInstanceId
 * @return Processes
 */
List<Processes> findTopByProcessInstanceIdOrderByIdDesc(UUID processInstanceId);

/**
 * @param processInstanceId processInstanceId
 * @return Processes Processes
 */
@Query(FIND_BY_LATEST_ASSIGNEE_3)
List<Processes> findLatestAssignee(@Param("processInstanceId")
UUID processInstanceId);
 }
