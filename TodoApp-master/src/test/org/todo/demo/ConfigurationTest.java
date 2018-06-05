package org.todo.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * Created by Dell on 10/23/2017.
 */
@SpringBootTest(classes = TestTodoApplication.class)
public abstract class ConfigurationTest {

    @Autowired(required = false)
    private TestRestTemplate testRestTemplate;

    protected static final String HOST="localhost";
    protected static final String PORT="8081";


    public TestRestTemplate getTestRestTemplate() {
        return testRestTemplate!=null ? testRestTemplate: new TestRestTemplate();
    }

    public void setTestRestTemplate(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    public ResponseEntity<String> invokeRestCall(String url, HttpMethod method, HttpEntity<?> httpEntity){
        return getTestRestTemplate().exchange(url,method, httpEntity, String.class);
    }

    public HttpHeaders getDefaultHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return headers;
    }

    public String buildUrl(String host, String port, String path, Map<String, String> uriValue){
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("Todoapp/"+path)
                .host(host).port(port).scheme("http");
        UriComponents uriComponents = uriValue != null && !uriValue.isEmpty() ? builder.buildAndExpand(uriValue): builder.build();
        return uriComponents.toUri().toString();
    }

    public String buildUrl(String host, String port, String path){
        return buildUrl(host, port, path,null);
    }
}
