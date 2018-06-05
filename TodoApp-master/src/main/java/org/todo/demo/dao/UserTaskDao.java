package org.todo.demo.dao;

import java.util.ArrayList;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.todo.demo.mapper.UserTaskMapper;
import org.todo.demo.message.SqlHelper;
import org.todo.demo.model.UserTask;

@Repository
public class UserTaskDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<UserTask> getAllTask() {
		List<UserTask> task = new ArrayList<UserTask>();
		task = jdbcTemplate.query(SqlHelper.GET_TASK, new UserTaskMapper());
		return task;
	}

	public UserTask getTask(int id) {
		UserTask task = new UserTask();
		task = jdbcTemplate.queryForObject(SqlHelper.GET_TASK_BY_ID, new Object[]{id}, new UserTaskMapper());
		return task;
	}

	public UserTask saveTask(UserTask userTask) {
		UserTask task = new UserTask();
		int isSuccss = jdbcTemplate.update(SqlHelper.CREATE_TASK, new Object[]{userTask.getUser_name(), userTask.getTask_name(), userTask.getTask_status(), userTask.getCreated_date()});
		if(isSuccss == 1){
			int taskId = jdbcTemplate.queryForObject( "select last_insert_id()",Integer.class);
			task = getTask(taskId);
		}
		return task;
	}

	public void updateTask(UserTask userTask) {
		jdbcTemplate.update(SqlHelper.UPDATE_TASK, new Object[]{
				userTask.getUser_name(), userTask.getTask_name(), userTask.getTask_status(), userTask.getCreated_date(),userTask.getId()});		

	}

	public boolean deleteTask(Integer id) {
		int isDelete = jdbcTemplate.update(SqlHelper.DELETE_TASK_BY_ID, new Object[]{id});
		if(isDelete == 1){
			return true;
		}
		return false;
	}
}
