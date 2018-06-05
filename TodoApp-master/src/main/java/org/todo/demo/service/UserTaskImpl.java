package org.todo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.todo.demo.dao.UserTaskDao;
import org.todo.demo.model.UserTask;

@Service
public class UserTaskImpl implements UserTaskService{

	@Autowired
	private UserTaskDao userTaskDao;
	
	public List<UserTask> getAllTask() {
		return userTaskDao.getAllTask();
	}

	public UserTask getTask(int id) {
		return userTaskDao.getTask(id);
	}

	public UserTask saveTask(UserTask userTask) {
		return userTaskDao.saveTask(userTask);
	}

	public void updateTask(UserTask userTask) {
		userTaskDao.updateTask(userTask);
		
	}

	public boolean deleteTask(Integer id) {
		return userTaskDao.deleteTask(id);
	}

}
