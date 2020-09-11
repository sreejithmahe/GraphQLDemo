package org.sreesoft.graphql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.repository.ProcessRepository;

@Service
public class ProcessService {
	
	
	//@Autowired
    //ProcessRepository processRepository;
	
	private final ProcessRepository processRepository ;
	
    public ProcessService(final ProcessRepository processRepository) {
        this.processRepository = processRepository ;
    }
	
	@Transactional(readOnly = true)
	public List<Processes> getProcess(final int count) {
        return this.processRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
}
