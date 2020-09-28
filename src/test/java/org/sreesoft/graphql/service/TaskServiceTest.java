package org.sreesoft.graphql.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.sreesoft.graphql.entity.Tasks;
import org.sreesoft.graphql.model.TaskModel;
import org.sreesoft.graphql.query.TaskQuery;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
       @Mock
	  TaskService taskService;
	   @InjectMocks
	  TaskQuery taskQuery;
	  
	   @Test
	  public void getAuditTaskAllTest() {
	    List<Tasks> list = new ArrayList<Tasks>();  
	    Tasks task = new TaskBuilder().build();
	    Tasks task1 = new TaskBuilder().build();
	    list.add(task1);
	    list.add(task);
	   when(taskService.getTaskAll()).thenReturn(list);
	    assertNotNull(taskQuery.getTask());
	    assertEquals(list, taskService.getTaskAll());
	    }
	@Test
	void testGetTask() {
		List<Tasks> list = new ArrayList<Tasks>();  
	    Tasks task = new TaskBuilder().build();
	    Tasks task1 = new TaskBuilder().build();
	    list.add(task1);
	    list.add(task);
	   when(taskService.getTask(1)).thenReturn(list);
	    assertNotNull(taskQuery.getTaskAll(1));
	    assertEquals(list, taskService.getTask(1));
	}

	@Test
	void testGetPageInfo() {
		 TaskModel taskModel =new TaskModel();
		Page<Tasks> page = Mockito.mock(Page.class);
	    when(taskService.getPageInfo(0, 4)).thenReturn(page);
	    assertEquals(0, taskQuery.totalElements(taskModel, 0, 4).getSize());
	    
	    assertEquals(page,taskService.getPageInfo(0, 4));  
	}

}
