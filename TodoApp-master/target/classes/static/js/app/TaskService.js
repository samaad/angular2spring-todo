'use strict';

angular.module('todoapp').factory('TaskService',
    ['$http', '$q', 'urls',
        function ($http, $q, urls) {

            var factory = {
        		loadAllTask: loadAllTask,
                getTask: getTask,
                createTask: createTask,
                updateTask: updateTask,
                removeTask: removeTask
            };

            return factory;
        
            function httpExecute(requestUrl, method, data){
                
                return $http({
                    url: requestUrl,
                    method: method,
                    data: data
                }).then(function(response){
                    
                    return response.data;
                });
            }

            function httpGet(url){
                return httpExecute(url, 'GET');
            }

           
            
            function loadAllTask() {
            		return httpGet(urls.GET_ALL); 
                               
            }

            function getTask(id) {
                return httpGet(urls.GET_BY_ID + id);
            }

            function createTask(user) {
                var deferred = $q.defer();
                $http.post(urls.SAVE, user)
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating Task : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateTask(user) {
                var deferred = $q.defer();
                $http.put(urls.UPDATE, user)
                    .then(
                        function (response) {
                        	deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating task with id :'+user.id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeTask(id) {
                var deferred = $q.defer();
                $http.delete(urls.REMOVE + id)
                    .then(
                        function (response) {
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);