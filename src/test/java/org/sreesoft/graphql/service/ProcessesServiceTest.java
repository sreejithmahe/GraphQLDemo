package org.sreesoft.graphql.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sreesoft.graphql.entity.Processes;
import org.sreesoft.graphql.query.ProcessQuery;


@ExtendWith(MockitoExtension.class)
class ProcessesServiceTest {
       @Mock
       ProcessService processService;
	   @InjectMocks
	   ProcessQuery processQuery;
	  
	   @Test
	  public void getProcessTest() {
	    List<Processes> list = new ArrayList<Processes>();  
	    Processes p = new ProcessBuilder().build();
	    Processes p1 = new ProcessBuilder().build();
	    list.add(p);
	    list.add(p1);
	   when(processService.getProcess(3)).thenReturn(list);
	    assertNotNull(processQuery.getProcessAll(3));
	   }
	@Test
	void getProcessAllTest() {
		List<Processes> list = new ArrayList<Processes>();  
	    Processes p = new ProcessBuilder().build();
	    Processes p1 = new ProcessBuilder().build();
	    list.add(p);
	    list.add(p1);
	   when(processService.getProcess(2)).thenReturn(list);
	    assertNotNull(processQuery.getProcessAll(2));
	}

	@Test
	void getProcessAllTest1() {
		List<Processes> list = new ArrayList<Processes>();  
	    Processes p = new ProcessBuilder().build();
	    Processes p1 = new ProcessBuilder().build();
	    list.add(p);
	    list.add(p1);
	   when(processService.getProcess(2)).thenReturn(list);
	    assertNotNull(processQuery.getProcess1(2));
	}

}
