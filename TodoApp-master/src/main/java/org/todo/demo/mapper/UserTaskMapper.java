package org.todo.demo.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.todo.demo.model.UserTask;


public class UserTaskMapper implements RowMapper<UserTask>{

	public UserTask mapRow(ResultSet aResultSet, int arg1) throws SQLException {
		UserTask task = new UserTask();
		
		task.setId(0<aResultSet.getInt("id")?aResultSet.getInt("id"):0);
		task.setUser_name(null!=aResultSet.getString("user_name")?aResultSet.getString("user_name"):"");
		task.setTask_name(null!=aResultSet.getString("task_name")?aResultSet.getString("task_name"):"");
		task.setTask_status(0<aResultSet.getInt("task_status")?aResultSet.getInt("task_status"):0);
		task.setCreated_date(null!=aResultSet.getString("created_date")?aResultSet.getString("created_date"):"");
		return task;
	}

}
