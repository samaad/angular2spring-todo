'use strict';

angular.module('todoapp').controller('userCtrl',
    ['TaskService', '$scope', '$q', function( TaskService, $scope,$q) {

        var vm = this;
        vm.user = {};
        vm.users=[];

        vm.submit = submit;
        vm.createTask = createTask;
        vm.updateTask = updateTask;
        vm.removeTask = removeTask;
        vm.editTask = editTask;
        vm.reset = reset;

        vm.successMessage = '';
        vm.errorMessage = '';
        vm.done = false;
        
        vm.dateOptions = {
		    formatYear: 'yy',
		    maxDate: new Date(2020, 5, 22),
		    minDate: new Date(),
		    startingDay: 1
	    };
        
        vm.today = function() {
        	vm.user.created_date = new Date();
      	};
        
      	vm.today();

        vm.clear = function() {
        	vm.user.created_date = null;
        };

        vm.open2 = function() {
        	vm.popup2.opened = true;
        };
        vm.popup2 = {
    		opened: false
        };
		  
    	  ;
        init();
        
        function init(){
        	TaskService.loadAllTask().then(function(result){
        		console.log(result)
        		vm.userdata = result.userTasks;
        	});
        }

        function submit() {
            console.log('Submitting');
            if (vm.user.id === undefined || vm.user.id === null) {
                createTask(vm.user);
            } else {
                updateTask(vm.user, vm.user.id);
            }
        }

        function createTask(user) {
        	user.created_date  = user.created_date.getUTCFullYear() + "-" +(parseInt(user.created_date.getUTCMonth())+1) + "-" +user.created_date.getUTCDate();
           
            TaskService.createTask(user)
                .then(
                    function (response) {
                       
                        vm.successMessage = 'User created successfully';
                        vm.errorMessage='';
                        vm.done = true;
                        vm.user={};
                        $scope.myForm.$setPristine();
                        vm.userdata.push(response.userTask);
                    },
                    function (errResponse) {
                       
                        vm.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
                        vm.successMessage='';
                    }
                );
        }


        function updateTask(user, id){
        	user.created_date  = user.created_date.getUTCFullYear() + "-" +(parseInt(user.created_date.getUTCMonth())+1) + "-" +user.created_date.getUTCDate();
        	TaskService.updateTask(user, id)
                .then(
                    function (response){
                        vm.successMessage='Task updated successfully';
                        vm.errorMessage='';
                        vm.done = true;
                        _.filter(vm.userdata, function(task){
                        	if(task.id == id){
                        		task.id = user.id;
                        		task.task_name = user.task_name;
                        		task.user_name = user.user_name;
                        		task.task_status = user.task_status;
                        		task.created_date = user.created_date;
                        	}
                        });
                        $scope.myForm.$setPristine();
                        vm.user = {};
                    },
                    function(errResponse){
                        vm.errorMessage='Error while updating Task '+errResponse.data;
                        vm.successMessage='';
                    }
                );
        }


        function removeTask(id){
            TaskService.removeTask(id)
                .then(
                    function(){
                    	vm.userdata = _.chain(vm.userdata)
                    			.filter(function(task){
		                    		if (task.id != id){
		                    			return task; 
		                    		}
                    			
                				}).map(function(task){
                					return task;
                				}).value();
                    },
                    function(errResponse){
                        console.error('Error while removing Task '+id +', Error :'+errResponse.data);
                    }
                );
        }



        function editTask(id) {
            vm.successMessage='';
            vm.errorMessage='';
            TaskService.getTask(id).then(
                function (user) {
                    vm.user = user.userTask;
                    vm.user.created_date = new Date(vm.user.created_date);
                },
                function (errResponse) {
                    console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            vm.successMessage='';
            vm.errorMessage='';
            vm.user={};
            $scope.myForm.$setPristine(); 
        }
    }


    ]);