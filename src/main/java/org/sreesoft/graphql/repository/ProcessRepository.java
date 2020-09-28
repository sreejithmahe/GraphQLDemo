/**
 *
 */
package org.sreesoft.graphql.repository;

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
 * @param tenantName tenantName
 * @return result
 */
@Query(FIND_BY_TENANT_QUERY) Processes findByTenantName(@Param("tenantName")
      String tenantName);

 }
