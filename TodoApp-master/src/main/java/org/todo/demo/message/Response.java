package org.todo.demo.message;

import org.todo.demo.model.UserTask;


public class Response {
	private Message message;
    private UserTask userTask;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public UserTask getUserTask() {
        return userTask;
    }

    public void setUserTask(UserTask userTask) {
        this.userTask = userTask;
    }
}
