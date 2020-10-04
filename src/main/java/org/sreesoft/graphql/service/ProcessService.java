package org.sreesoft.graphql.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
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



/**
 * @author k_sre
 *
 */
@Service
@PropertySources(value = {
@PropertySource("classpath:application-exception-messages.yaml") })
public class ProcessService {

/**
 *
 */
private static final Logger LOG =
LoggerFactory.getLogger(CustomContainer.class);

 /**
 *
 */
@Value("${error.audit.500.message}")
  private String errorMessage500;
  /**
 *
 */
@Value("${error.audit.504.message}")
  private String errorMessage504;
  /**
 *
 */
@Value("${error.audit.400.message}")
  private String errorMessage400;



/**
 *
 */
private ProcessRepository processRepository;

    /**
     * @param processRepository processRepository
     */
    public ProcessService(final ProcessRepository processRepository) {
        this.processRepository = processRepository;
    }
    /**
     * @return allProcess
     */
    @Transactional(readOnly = true)
    public List<Processes> getProcessAll() {
    return this.processRepository.findAll().stream().
    collect(Collectors.toList());
}

/**
 * @param count count
 * @return count
 */
@Transactional(readOnly = true)
public List<Processes> getProcess(final int count) {

LOG.info("Logger");
try {
if (count == 0) {
return this.processRepository.findAll().stream().collect(Collectors.toList());
}
        return this.processRepository.findAll().stream().
        limit(count).collect(Collectors.toList());
 } catch (GraphQLException ex) {
      throw new SreesoftCustomException(errorMessage400);
    } catch (SreesoftCustomException ex) {
      throw new SreesoftCustomException(errorMessage504);
    } catch (Exception ex) {
      throw new SreesoftCustomException(errorMessage500);
    }


}
/**
 * @param tenantName tenantName
 * @return name
 */
@Transactional(readOnly = true)
public Processes getByTenantName(final String tenantName) {
        return this.processRepository.findByTenantName(tenantName);
    }

/**
 * @param page page
 * @param size size
 * @return size
 */
@Transactional(readOnly = true)
public List<Processes> getProcessByPage(final int page, final int size) {
Pageable pageable = PageRequest.of(page, size);
return this.processRepository.findAll(pageable).stream().
collect(Collectors.toList());
}
/**
 * @param page page
 * @param size size
 * @param sortBy sortBy
 * @return size
 */
@Transactional(readOnly = true)
    public List<Processes>
getProcessByPageSortedByTenantName(final int page, final int size,
final String sortBy) {
Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
return this.processRepository.findAll(pageable).stream().
collect(Collectors.toList());
}
/**
 * @return repo
 */
public Integer getTotalCount() {
return this.processRepository.findAll().size();
}
/**
 * @param page page
 * @param size size
 * @return size
 */
public Integer getTotalPage(final int page, final int size) {
        Pageable pageable = PageRequest.of(page, size);
       return this.processRepository.findAll(pageable).getTotalPages();
}
/**
 * @param page page
 * @param size size
 * @return size
 */
public Page<Processes> getPageInfo(final int page, final int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.processRepository.findAll(pageable);
}
/**
 * @param page page
 * @param size size
 * @return size
 */
public boolean getPageable(final int page, final int size) {
Pageable pageable = PageRequest.of(page, size);
        return this.processRepository.findAll(pageable).getPageable().isPaged();
        }
/**
 * @param processInstanceId processInstanceId
 * @return Processes
 */
public List<Processes> getProcessLatest(final UUID processInstanceId) {
  return this.processRepository.
         findTopByProcessInstanceIdOrderByIdDesc(processInstanceId).stream()
          .collect(Collectors.toList());
}
/**
 * @return Processes
 */
public List<Processes> getProcessLatestAssignee() {
List<Processes> process = processRepository.findAll();
 for (Processes p: process) {
 if (StringUtils.isBlank(p.getTasks().get(0).getAssignee())) {
 p.setAssignee(p.getProcessInstanceId().toString());
 } else {
 p.setAssignee(p.getTasks().get(0).getAssignee());

 }
 }
  return this.processRepository.findAll().stream()
          .collect(Collectors.toList());
 }
}
