package org.sreesoft.graphql.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.sreesoft.graphql.entity.Processes;

import com.google.common.collect.Lists;

public abstract class ProcessRepositoryImpl implements ProcessRepository {

	@Autowired
    private EntityManager em;
	
	public List<Processes> findPagedResultBySomethingElseId(long somethingElseId, int offset, int limit) {
        String query = "select s.* from Something s "
                + "join somethingelse selse on selse.id = s.fk_somethingelse "
                + "where selse.id = :somethingElseId "
                + "order by selse.date";
        Query nativeQuery = em.createNativeQuery(query);
        nativeQuery.setParameter("somethingElseId", somethingElseId);
        //Paginering
        nativeQuery.setFirstResult(offset);
        nativeQuery.setMaxResults(limit);
        final List<Object[]> resultList = nativeQuery.getResultList();
        List<Processes> somethingList = Lists.newArrayList();
      //  resultList.forEach(object -> somethingList.add(//map obj to something));
        return somethingList;
    }
}
