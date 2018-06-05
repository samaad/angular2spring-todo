package org.todo.demo;

import cucumber.api.java.en.When;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dell on 10/23/2017.
 */
public class GetUsersTaskTest extends ConfigurationTest {

    private int userId;
    private ResponseEntity<String> responseEntity = null;

    @When("^the client calls \"([^\"]*)\" with id as (\\d+)$")
    public void get_with_user_id(String path, int userId) throws Throwable{
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id",String.valueOf(userId));
        String url = buildUrl(HOST,PORT,path,uriVariables);
        System.out.println("URL "+url);
        responseEntity = invokeRestCall(url, HttpMethod.GET, null);
    }
}
