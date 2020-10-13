package org.sreesoft.graphql.service;

import java.util.ArrayList;
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
 List<String> assignee = new ArrayList<String>();
List<Tasks> tasks = taskRepository.findAll();
 String s1 = "";
 for (Tasks t: tasks) {
 String s2 = t.getProcessInstanceId().toString();
    if (s1.equals(s2)) {
     assignee.add(t.getAssignee());
 t.setLatestAssignee(assignee);
     } else {
    s1 = t.getProcessInstanceId().toString();
    assignee = new ArrayList<String>();
     assignee.add(t.getAssignee());
 t.setLatestAssignee(assignee);
    }
 }
return tasks;
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
