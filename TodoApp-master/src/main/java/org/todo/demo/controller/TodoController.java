package org.todo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.todo.demo.message.Message;
import org.todo.demo.message.Response;
import org.todo.demo.message.Responses;
import org.todo.demo.message.StatusCode;
import org.todo.demo.message.StatusMessage;
import org.todo.demo.model.UserTask;
import org.todo.demo.service.UserTaskService;

@RestController
public class TodoController {

	Message message = new Message();
	
	@Autowired
	public UserTaskService userTaskService;
	
	@GetMapping("/all")
    public ResponseEntity<Responses> getAllTask(){
		 Responses responses = new Responses();
	        List<UserTask> userTask = userTaskService.getAllTask();
	        if(userTask != null){
	            responses.setUserTasks(userTask);
	            message.setStatusCode(StatusCode.S201);
	            message.setStatusMessage(StatusMessage.SUCCESS);
	            responses.setMessage(message);
	            return new ResponseEntity<Responses>(responses, HttpStatus.OK);
	        }else{
	            responses.setUserTasks(userTask);
	            message.setStatusCode(StatusCode.E205);
	            message.setStatusMessage(StatusMessage.FAIL);
	            responses.setMessage(message);
	            return new ResponseEntity<Responses>(responses, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	@GetMapping("/task/{id}")
    public ResponseEntity<Response> getTaskById(@PathVariable("id") Integer id){
        Response response = new Response();
        if(id == 0){
            message.setStatusCode(StatusCode.E202);
            message.setStatusMessage(StatusMessage.FAIL);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        UserTask userTask = userTaskService.getTask(id);
        if(userTask != null){
            response.setUserTask(userTask);
            message.setStatusCode(StatusCode.S201);
            message.setStatusMessage(StatusMessage.SUCCESS);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        }else{
            response.setUserTask(userTask);
            message.setStatusCode(StatusCode.E205);
            message.setStatusMessage(StatusMessage.FAIL);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @SuppressWarnings("unused")
	@PostMapping("/save")
    public ResponseEntity<Response> saveTask(@RequestBody UserTask userTask){
        Response response = new Response();
        if(userTask == null){
            message.setStatusCode(StatusCode.E204);
            message.setStatusMessage(StatusMessage.FAIL);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        UserTask userTasks = userTaskService.saveTask(userTask);
        if(userTask != null){
            response.setUserTask(userTasks);
            message.setStatusCode(StatusCode.S201);
            message.setStatusMessage(StatusMessage.SUCCESS);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        }else{
            response.setUserTask(userTasks);
            message.setStatusCode(StatusCode.E203);
            message.setStatusMessage(StatusMessage.FAIL);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Response> updateTask(@RequestBody UserTask userTask){

        Response response = new Response();
        if(userTask == null){
            message.setStatusCode(StatusCode.E204);
            message.setStatusMessage(StatusMessage.FAIL);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        userTaskService.updateTask(userTask);
        message.setStatusCode(StatusCode.S201);
        message.setStatusMessage(StatusMessage.SUCCESS);
        response.setMessage(message);
        return new ResponseEntity<Response>(response, HttpStatus.OK);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Response> removeTask(@PathVariable("id") Integer id){
        Response response = new Response();
        if(id == 0){
            message.setStatusCode(StatusCode.E202);
            message.setStatusMessage(StatusMessage.FAIL);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.FAILED_DEPENDENCY);
        }
        boolean isDeleted = userTaskService.deleteTask(id);
        if(isDeleted){
            message.setStatusCode(StatusCode.S201);
            message.setStatusMessage(StatusMessage.SUCCESS);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        }else{
            message.setStatusCode(StatusCode.E206);
            message.setStatusMessage(StatusMessage.FAIL);
            response.setMessage(message);
            return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
