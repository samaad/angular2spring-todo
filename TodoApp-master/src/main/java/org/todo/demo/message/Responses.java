package org.todo.demo.message;
import java.util.List;

import org.todo.demo.model.UserTask;

public class Responses {

	 private Message message;
	 private List<UserTask> userTasks;

	    public Message getMessage() {
	        return message;
	    }

	    public void setMessage(Message message) {
	        this.message = message;
	    }

	    public List<UserTask> getUserTasks() {
	        return userTasks;
	    }

	    public void setUserTasks(List<UserTask> userTasks) {
	        this.userTasks = userTasks;
	    }
}
