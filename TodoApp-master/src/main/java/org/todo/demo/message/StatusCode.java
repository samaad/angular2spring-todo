package org.todo.demo.message;

public enum StatusCode {
	S201("Success"), E201("Error due to database connection"), E202("UserTask id cannot be empty"), E204(
			"Please fill all mandatory records"), E203("Failed to Save the user task data"), E205(
					"Failed to retrive data"), E206("Failed to delete the recorde");

	private String message;

	private StatusCode(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
