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



@Service
public class TaskService {
	
	private final TaskRepository taskRepository ;
	
    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository ;
    }
    @Transactional(readOnly = true)
	public List<Tasks> getTask(final int count) {
		if(count == 0) 
			return this.taskRepository.findAll().stream().collect(Collectors.toList());
        return this.taskRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
    public Page<Tasks> getPageInfo(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.taskRepository.findAll(pageable);
	}
}
