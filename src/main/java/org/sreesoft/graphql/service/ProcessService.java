package org.sreesoft.graphql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.repository.ProcessRepository;



@Service
public class ProcessService {
	
	private final ProcessRepository processRepository ;
	
    public ProcessService(final ProcessRepository processRepository) {
        this.processRepository = processRepository ;
    }
    @Transactional(readOnly = true)
    public List<Processes> getProcessAll() {
    	return this.processRepository.findAll().stream().collect(Collectors.toList());
	}
    
	@Transactional(readOnly = true)
	public List<Processes> getProcess(final int count) {
		if(count == 0) 
			return this.processRepository.findAll().stream().collect(Collectors.toList());
        return this.processRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }
	
	@Transactional(readOnly = true)
	public Processes getByTenantName(final String tenantName) {
        return this.processRepository.findByTenantName(tenantName);
    }
	
	@Transactional(readOnly=true)
    public List<Processes> getProcessByPage(int page, int size){
		Pageable pageable = PageRequest.of(page, size);
		return this.processRepository.findAll(pageable).stream().collect(Collectors.toList());
	}
	@Transactional(readOnly=true)
    public List<Processes> getProcessByPageSortedByTenantName(int page, int size,String SortBy){
		Pageable pageable = PageRequest.of(page, size,Sort.by(SortBy));
		return this.processRepository.findAll(pageable).stream().collect(Collectors.toList());
	}
	public Integer getTotalCount() {
		return this.processRepository.findAll().size();
	}
	public Integer getTotalPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
       return this.processRepository.findAll(pageable).getTotalPages();
	}
	public Page<Processes> getPageInfo(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.processRepository.findAll(pageable);
	}
	public boolean getPageable(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
        return this.processRepository.findAll(pageable).getPageable().isPaged();
	}
}
