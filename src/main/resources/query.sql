drop database graphqls;
create database graphqls;
use graphqls;


show tables;


desc tasks;


INSERT INTO processes(
                        id,completed_date_time, event_type,last_modified_by ,last_modified_date_time ,parent_process_instance_id, process_definition_id , 
                        process_instance_id, process_name,  start_date_time,  status,
                        tenant_id, tenant_name ,  terminated_by , terminated_date_time ,variables)
                VALUES (
                        100,curdate(), "Auto", "System", curdate(),"f0994733y","f135373537397654",
                        "f124252635379i63", "Change Salary", curdate(), 'PENDING',
                        "1002","Yamaha", 'System',curdate(), "Testdata0001"
                        );
INSERT INTO processes(
                        id,completed_date_time, event_type,last_modified_by ,last_modified_date_time ,parent_process_instance_id, process_definition_id , 
                        process_instance_id, process_name,  start_date_time,  status,
                        tenant_id, tenant_name ,  terminated_by , terminated_date_time ,variables)
                VALUES (
                        101,curdate(), "Auto", "System", curdate(),"f0994733y","f135373537397654",
                        "uuuuuugtyu", "Change Salary", curdate(), 'PENDING',
                        "1002","Holtcat", 'System',curdate(), "Testdata0001"
                        );
                        
INSERT INTO processes(
                        id,completed_date_time, event_type,last_modified_by ,last_modified_date_time ,parent_process_instance_id, process_definition_id , 
                        process_instance_id, process_name,  start_date_time,  status,
                        tenant_id, tenant_name ,  terminated_by , terminated_date_time ,variables)
                VALUES (
                        102,curdate(), "Auto", "System", curdate(),"f0994733y","f135373537397654",
                        "f124252635379i65", "Change Salary", curdate(), 'PENDING',
                        "1002","Holtcat-New", 'System',curdate(), "Testdata0001"
                        );
                        
      INSERT INTO tasks(
                        id,tenant_id,process_instance_id, task_instance_id,tenant_name ,task_name,task_type, variables,
                        status ,assignee, assigned_date_time,  start_date_time,  completed_by,completed_date_time, 
                        terminated_by,terminated_date_time,last_modified_by,last_modified_date_time,event_type,processes_id)
                VALUES(
                        1000,33345,'f124252635379i63', 't124252635teg63', 'Yamaha-veuthe','federal tax','User','Testdata0001',
                        'PENDING','Jeremy Miller', curdate(),curdate(), 'Jeremy Miller',curdate(),
                        'System',curdate(),'workflow.engine',curdate(),'AUTO','f124252635379i63'
                    );                  
      
      
        INSERT INTO tasks(
                        id,tenant_id,process_instance_id, task_instance_id,tenant_name ,task_name,task_type, variables,
                        status ,assignee, assigned_date_time,  start_date_time,  completed_by,completed_date_time, 
                        terminated_by,terminated_date_time,last_modified_by,last_modified_date_time,event_type,processes_id)
                VALUES(
                        1001,6776,'f124252635379i63', 't124252635teg63', 'Yamaha-vijayichu','federal tax','User','Testdata0001',
                        'PENDING','Jeremy Miller', curdate(),curdate(), 'Jeremy Miller',curdate(),
                        'System',curdate(),'workflow.engine',curdate(),'AUTO','f124252635379i63'
                        );                  
         
           INSERT INTO tasks(
                        id,tenant_id,process_instance_id, task_instance_id,tenant_name ,task_name,task_type, variables,
                        status ,assignee, assigned_date_time,  start_date_time,  completed_by,completed_date_time, 
                        terminated_by,terminated_date_time,last_modified_by,last_modified_date_time,event_type,processes_id)
                VALUES(
                        1002,9750,'uuuuuugtyu', 't124252635teg63', 'Yamaha-TestNew','federal tax','User','Testdata0001',
                        'PENDING','Jeremy Miller', curdate(),curdate(), 'Jeremy Miller',curdate(),
                        'System',curdate(),'workflow.engine',curdate(),'AUTO','uuuuuugtyu'
                        );   
                        
    select * from tasks;
      
      