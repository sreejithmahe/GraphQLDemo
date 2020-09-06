package org.sreesoft.graphql.service.datafetcher;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.repository.ProcessRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class ProcessDataFetcher implements DataFetcher<List<Processes>>{
	
	@Autowired
	ProcessRepository processRepository;
	
	@Override
    public List<Processes> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return processRepository.findAll();
    }

}
