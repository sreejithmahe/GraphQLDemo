package org.sreesoft.graphql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sreesoft.graphql.config.CustomContainer;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.exception.SreesoftCustomException;
import org.sreesoft.graphql.repository.ProcessRepository;

import graphql.GraphQLException;



@Service
@PropertySources(value = { @PropertySource("classpath:application-exception-messages.yaml") })
public class ProcessService {
	
	private static final Logger log= LoggerFactory.getLogger(CustomContainer.class);
	
	 @Value("${error.audit.500.message}")
	  private String errorMessage500;
	  @Value("${error.audit.504.message}")
	  private String errorMessage504;
	  @Value("${error.audit.400.message}")
	  private String errorMessage400;
	
	
	
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
		
		
	try {
		if(count == 0) 
			return this.processRepository.findAll().stream().collect(Collectors.toList());
        return this.processRepository.findAll().stream().limit(count).collect(Collectors.toList());
	 } catch (GraphQLException ex) {
	      throw new SreesoftCustomException(errorMessage400);
	    } catch (SreesoftCustomException ex) {
	      throw new SreesoftCustomException(errorMessage504);
	    } catch (Exception ex) {
	      throw new SreesoftCustomException(errorMessage500);
	    }
		
		
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
