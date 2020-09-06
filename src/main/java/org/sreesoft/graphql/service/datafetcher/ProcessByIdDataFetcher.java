package org.sreesoft.graphql.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.repository.ProcessRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ProcessByIdDataFetcher implements DataFetcher<Processes>{
	@Autowired
	ProcessRepository processRepository;
	
	@Override
	public Processes get(DataFetchingEnvironment dataFetchingEnvironment) {
		 Long processId = dataFetchingEnvironment.getArgument("id");
          return processRepository.findById(processId).get();
	}
}
