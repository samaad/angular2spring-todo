package org.todo.demo.message;

public class Message {

	StatusMessage statusMessage;
	StatusCode statusCode;

	public StatusMessage getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(StatusMessage statusMessage) {
		this.statusMessage = statusMessage;
	}

	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "Message{" + "statusMessage=" + statusMessage + ", statusCode=" + statusCode + '}';
	}
}
