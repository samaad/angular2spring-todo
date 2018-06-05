package org.todo.demo.service;

import java.util.List;

import org.todo.demo.model.UserTask;


public interface UserTaskService {

	List<UserTask> getAllTask();

	UserTask getTask(int id);

	UserTask saveTask(UserTask userTask);

	void updateTask(UserTask userTask);

	boolean deleteTask(Integer id);
}
