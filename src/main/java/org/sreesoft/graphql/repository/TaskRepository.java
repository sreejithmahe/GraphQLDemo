/**
 *
 */
package org.sreesoft.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sreesoft.graphql.entity.Tasks;

/**
 * @author k_sre
 *
 */
@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
