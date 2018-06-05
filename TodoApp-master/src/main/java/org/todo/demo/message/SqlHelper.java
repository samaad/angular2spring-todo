package org.todo.demo.message;

public interface SqlHelper {

	String GET_TASK = "SELECT * FROM Todos";
	String GET_TASK_BY_ID = "SELECT * FROM Todos WHERE id = ?";
	String DELETE_TASK_BY_ID = "DELETE FROM Todos WHERE id = ?";
	String CREATE_TASK = "INSERT INTO Todos(user_name,task_name,task_status,created_date) values(?,?,?,?)";
	String UPDATE_TASK = "UPDATE Todos SET user_name = ?, task_name = ?, task_status = ?,created_date= ? Where id = ?";
}
