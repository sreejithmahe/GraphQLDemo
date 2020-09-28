package org.sreesoft.graphql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sreesoft.graphql.entity.Tasks;
import org.sreesoft.graphql.repository.TaskRepository;



/**
 * @author k_sre
 *
 */
@Service
public class TaskService {

/**
 *
 */
private TaskRepository taskRepository;

    /**
     * @param taskRepository taskRepository
     */
    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    /**
     * @return result
     */
@Transactional(readOnly = true)
public List<Tasks> getTaskAll() {
return this.taskRepository.findAll().stream().collect(Collectors.toList());
    }
    /**
     * @param count count
     * @return count
     */
    @Transactional(readOnly = true)
public List<Tasks> getTask(final int count) {
if (count == 0) {
    return this.taskRepository.findAll().stream().collect(Collectors.toList());
}
        return this.taskRepository.findAll().stream().limit(count).
        collect(Collectors.toList());
    }
    /**
     * @param page size
     * @param size size
     * @return size
     */
    public Page<Tasks> getPageInfo(final int page, final int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.taskRepository.findAll(pageable);
}
}
