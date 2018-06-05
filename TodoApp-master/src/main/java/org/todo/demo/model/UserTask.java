package org.todo.demo.model;

public class UserTask {
	private Integer id;
	private String user_name;
	private String task_name;
	private int task_status;
	private String created_date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public int getTask_status() {
		return task_status;
	}

	public void setTask_status(int task_status) {
		this.task_status = task_status;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserTask userTask = (UserTask) o;

		if (task_status != userTask.task_status)
			return false;
		if (!id.equals(userTask.id))
			return false;
		if (!user_name.equals(userTask.user_name))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + user_name.hashCode();
		result = 31 * result + task_status;
		return result;
	}

	@Override
	public String toString() {
		return "UserTask{" + "id=" + id + ", user_name='" + user_name + '\'' + ", task_name='" + task_name + '\''
				+ ", task_status=" + task_status + ", created_date='" + created_date + '\'' + '}';
	}
}
