/**
 * 
 */
package org.sreesoft.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sreesoft.graphql.entity.Processes;

/**
 * @author k_sre
 *
 */
public interface ProcessRepository extends JpaRepository<Processes,Long>{

}
